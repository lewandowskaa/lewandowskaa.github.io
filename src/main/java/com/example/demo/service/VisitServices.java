package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class VisitServices {

    // servis dla wizyty | tu jest glowne serce biznesowe aplikacji | znajduja sie tu metody umozliwiajace poprawne rezerwowanie wizyty i dodawanie kolejnych ich pozycji
    // a takze szukanie wlasciwej dla uzytkownika wizyty w przygotowaniu ( koszyka )

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DogServices dogServices;

    @Autowired
    private DogServiceServices dogServiceServices;

    // wyszukiwanie wizyty w przygotowaniu ( tzw koszyk )
    public Visit visitInPreparation(HttpServletRequest request) {
        User user = userService.loggedUser(request);

        if (user != null) {
            Visit visit = visitRepository.findFirstByUserAndStatus(user, VisitStatus.WAITING).isPresent() ? visitRepository.findFirstByUserAndStatus(user, VisitStatus.WAITING).get() : null;
            if (visit != null) {
                visit.setDate(null);
                visit.setStartTime(null);
            } else {
                visit = new Visit(null, null, null, VisitStatus.WAITING, 0, LocalTime.of(0, 0), user, Collections.emptyList());
            }

            save(visit);
            return visit;
        }
        return null;
    }

    public void save(Visit visit) {
        visitRepository.save(visit);
    }

    // dodawanie psiej uslugi do vizyty
    public void addDogServiceToVisit(Integer dogServiceId, Integer visitId) {
        DogService dogService = dogServiceServices.findById(dogServiceId);
        Visit visit = findById(visitId);

        if (dogService != null && visit != null) {
            visit.getDogServiceList().add(dogService);
            visit.setTotalCost(visit.getTotalCost() + dogService.getPrice());

            LocalTime temp = visit.getTotalTime();
            temp = temp.plusHours(dogService.getTime().getHour());
            temp = temp.plusMinutes(dogService.getTime().getMinute());
            visit.setTotalTime(temp);
            save(visit);
        }
    }

    public Visit findById(Integer visitId) {
        return visitRepository.findById(visitId).isPresent() ? visitRepository.findById(visitId).get() : null;
    }

    // usuwanie wskazanej wizyty
    public void removeDogServiceFromVisit(Integer visitId, Integer dogServiceId) {
        Visit visit = findById(visitId);
        DogService dogService = dogServiceServices.findById(dogServiceId);

        if (visit != null && dogService != null) {
            visit.getDogServiceList().remove(dogService);
            visit.setTotalCost(visit.getTotalCost() - dogService.getPrice());

            LocalTime temp = visit.getTotalTime();
            temp = temp.minusHours(dogService.getTime().getHour());
            temp = temp.minusMinutes(dogService.getTime().getMinute());
            visit.setTotalTime(temp);
            save(visit);
        }
    }

    // rejestracja wizyty ( jej proba ) jesli termin wizyty wskazany przez uzytkownika nie koliduje z inna nowa wizyta zostanie dodana do bazy danych |
    //     jesli termin bedzie juz zajety uzytkownikowi zostanie zaproponowany inny termin o tej samej godzinie
    public LocalDate visitRegistration(Integer visitId, String date, String time) {
        LocalDate visitDate = LocalDate.parse(date);
        Visit newVisit = findById(visitId);
        LocalDate availableDate;

        int counter = 0;
        while (counter < 100) {
            availableDate = visitDate.plusDays(counter);
            if (availableDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                counter++;
                continue;
            }

            List<Visit> currentlyVisitList = visitRepository.findAllByStatusAndDateOrderByStartTime(VisitStatus.ACCEPTED, availableDate);

            if (currentlyVisitList.isEmpty() || visitAvailable(newVisit, currentlyVisitList, LocalTime.parse(time))) {
                if (visitDate.equals(availableDate)) {
                    newVisit.setStatus(VisitStatus.ACCEPTED);
                    newVisit.setDate(LocalDate.parse(date));
                    newVisit.setStartTime(LocalTime.parse(time));
                    save(newVisit);
                }
                return availableDate;
            }
            counter++;
        }
        return null;
    }

    public Visit findByUserAndStatusWaiting(User user) {
        return visitRepository.findFirstByUserAndStatus(user, VisitStatus.WAITING).isPresent() ? visitRepository.findFirstByUserAndStatus(user, VisitStatus.WAITING).get() : null;
    }

    // metoda sprawdzajaca czy podana wizyta moze sie odbyc danego dnia ( porownywanie z innymi wizytami )
    // jesli nie ma kolizji w danym dniu dostajemy informacje ze mozemy rejestrowac na dany termin
    public boolean visitAvailable(Visit newVisit, List<Visit> oldVisit, LocalTime newStart) {
        LocalTime start = LocalTime.parse("10:00");

        LocalTime newEnd = newStart;
        newEnd = newEnd.plusHours(newVisit.getTotalTime().getHour());
        newEnd = newEnd.plusMinutes(newVisit.getTotalTime().getMinute());

        for (Visit e : oldVisit) {
            LocalTime oldStart = e.getStartTime();
            LocalTime oldEnd = oldStart.plusHours(e.getTotalTime().getHour());
            oldEnd = oldEnd.plusMinutes(e.getTotalTime().getMinute());

            if (newStart.equals(start) || newStart.isAfter(start)) {
                if (newStart.isBefore(oldStart) && (newEnd.isBefore(oldStart) || newEnd.equals(oldStart))) {
                    return true;
                } else {
                    start = oldEnd;
                }
            }
        }

        return newStart.isAfter(start) || newStart.equals(start);
    }

    public List<Visit> visitList(HttpServletRequest request) {
        User user = userService.loggedUser(request);
        if (user != null) {
            VisitStatus status = VisitStatus.ACCEPTED;
            return visitRepository.findAllByUserAndStatus(user, status);
        }
        return Collections.emptyList();
    }

    public void removeVisit(Integer visitId) {
        Visit visit = findById(visitId);
        visitRepository.delete(visit);
    }

    public List<Visit> findAllByStatusOrderByDate() {
        return visitRepository.findAllByStatusOrderByDateAsc(VisitStatus.ACCEPTED);
    }

    // odpowiedz wysylana do uzytkownika | sprawdzamy kilka ewentualnosci np. czy godziny pracy sie zgadzaja , czy czas zamowienia nie wykracza ponad czas pracy ,
    // czy uzytkownik nie chce rezerwowac wizyty z pustym koszykiem | jesli wszystko sie zgadza probujemy zarejestrowac wizyte, jesli termin jest wolny w przypadku gdy zajety
    // zwracamy nformacje o najblizszym mozliwym terminie
    public ModelAndView orderVisitResponse(HttpServletRequest request, Integer dogId, Integer visitId, String date, String time) {
        LocalDate visitDate = LocalDate.parse(date);
        Visit visit = findById(visitId);
        LocalTime visitStartTime = LocalTime.parse(time);
        LocalTime visitEndTime = visitStartTime.plusHours(visit.getTotalTime().getHour());
        visitEndTime = visitEndTime.plusMinutes(visit.getTotalTime().getMinute());

        if (visitDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) && visitEndTime.isAfter(LocalTime.parse("15:00"))) {
            return wrongHours(dogId, date, "15:00");
        } else if (visitEndTime.isAfter(LocalTime.parse("20:00"))) {
            return wrongHours(dogId, date, "20:00");
        }

        User user = userService.loggedUser(request);
        if (findByUserAndStatusWaiting(user).getDogServiceList().isEmpty()) {
            return emptyList(dogId);
        }

        LocalDate availableDate = visitRegistration(visitId, date, time);

        if (availableDate != null) {
            if (visitDate.equals(availableDate)) {
                return success(dogId);
            } else {
                return availableDate(dogId, availableDate.toString());
            }
        } else {
            return error(dogId);
        }
    }

    private ModelAndView wrongHours(Integer dogId, String date, String time) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dogId", dogId.toString());
        map.put("message", "W dniu " + date + " pracujemy do " + time + ". Twoja wizyta wymaga więcej czasu.");
        map.put("messageType", "danger");
        return new ModelAndView("redirect:orderVisit", map);
    }

    private ModelAndView success(Integer dogId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dogId", dogId.toString());
        map.put("message", "Wizyta zarejestrowana");
        map.put("messageType", "success");
        return new ModelAndView("redirect:orderVisit", map);
    }

    private ModelAndView availableDate(Integer dogId, String availableDate) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dogId", dogId.toString());
        map.put("message", "Termin zarezerwowany, kolejny najbliższy termin w tej godzinie to " + availableDate);
        map.put("messageType", "danger");
        return new ModelAndView("redirect:orderVisit", map);
    }

    private ModelAndView error(Integer dogId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dogId", dogId.toString());
        map.put("message", "Mamy zbyt dużo rezerwacji. Prosimy wybrać inny termin.");
        map.put("messageType", "danger");
        return new ModelAndView("redirect:orderVisit", map);
    }

    private ModelAndView emptyList(Integer dogId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("dogId", dogId.toString());
        map.put("message", "Twój koszyk jest pusty");
        map.put("messageType", "danger");
        return new ModelAndView("redirect:orderVisit", map);
    }
}
