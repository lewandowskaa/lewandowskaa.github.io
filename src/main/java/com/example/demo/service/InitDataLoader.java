//package com.example.demo.service;
//
//import com.example.demo.model.*;
//import com.example.demo.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class InitDataLoader {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private DogRepository dogRepository;
//
//    @Autowired
//    private DogServiceRepository dogServiceRepository;
//
//    @Autowired
//    private DogServiceTypeRepository dogServiceTypeRepository;
//
//    @Autowired
//    private VisitRepository visitRepository;
//
//    @PostConstruct
//    public void initialize() {
//        List<Dog> dogList = initializeDog();
//        List<DogServiceType> dogServiceTypeList = initializeDogServiceType();
//        List<DogService> dogServiceList = initializeDogService(dogList, dogServiceTypeList);
//
//        User user = new User(null, "admin", "admin", "a@a", "aaa", UserRole.ADMIN, Collections.emptyList());
//        userRepository.save(user);
//
//        user = new User(null, "user", "user", "u@u", "uuu", UserRole.USER, Collections.emptyList());
//        userRepository.save(user);
//
//        Visit visit = new Visit(null, LocalDate.now().plusDays(2), LocalTime.parse("11:00"), VisitStatus.WAITING, 0, LocalTime.of(0, 0), user, Collections.emptyList());
//        visitRepository.save(visit);
//    }
//
//    private List<Dog> initializeDog() {
//        List<Dog> dogList = new ArrayList<>();
//        Dog dog = new Dog(null, "West Highland White Terier", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Cavalier King Charles Spaniel", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Hawańczyk", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Pudel", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Shih Tzu", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Yorkshire terier", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Sznaucer", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Cairn Terrier", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Jack Russel Terrier", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Wyżeł niemiecki szorstkowłosy", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Jamnik Szorstkowłosy", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Bichon frise", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Fox terier", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Maltańczyk", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Labrador", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Syberian Husky", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Owczarek Niemiecki", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        dog = new Dog(null, "Pozostałe rasy", Collections.emptyList());
//        dogRepository.save(dog);
//        dogList.add(dog);
//
//        return dogList;
//    }
//
//    private List<DogServiceType> initializeDogServiceType() {
//        List<DogServiceType> dogServiceTypeList = new ArrayList<>();
//        DogServiceType dogServiceType = new DogServiceType(null, "Strzyżenie", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Trymowanie", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Usuwanie podszerstka", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Kąpiel higieniczna + suszenie + rozczesanie", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Przycinanie pazurków", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Czyszczenie uszu", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Pielęgnacja oczu", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Czyszczenie uszu i oczu", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Pełny pakiet pielęgnacji", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        dogServiceType = new DogServiceType(null, "Wizyta adaptacyjna", Collections.emptyList());
//        dogServiceTypeRepository.save(dogServiceType);
//        dogServiceTypeList.add(dogServiceType);
//
//        return dogServiceTypeList;
//    }
//
//    private List<DogService> initializeDogService(List<Dog> dogList, List<DogServiceType> dogServiceTypeList) {
//        //West Highland White Terier
//        List<DogService> dogServiceList = new ArrayList<>();
//        DogService dogService = new DogService(null, 80, LocalTime.of(1, 0), dogList.get(0), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 120, LocalTime.of(1, 30), dogList.get(0), dogServiceTypeList.get(1), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(0), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(0), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(0), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 15), dogList.get(0), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(0), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(0), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 200, LocalTime.of(2, 0), dogList.get(0), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(0), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//        dogServiceList.add(dogService);
//
//
//        //Cavalier King Charles Spaniel
//        dogService = new DogService(null, 70, LocalTime.of(0, 50), dogList.get(1), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(1), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(1), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(1), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(1), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(1), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(1), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 180, LocalTime.of(1, 30), dogList.get(1), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(1), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Hawańczyk
//        dogService = new DogService(null, 70, LocalTime.of(0, 50), dogList.get(2), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(2), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 90, LocalTime.of(1, 30), dogList.get(2), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(2), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(2), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(2), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(2), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 190, LocalTime.of(1, 40), dogList.get(2), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(2), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Pudel
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(3), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(3), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 90, LocalTime.of(1, 30), dogList.get(3), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(3), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(3), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(3), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(3), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 190, LocalTime.of(1, 40), dogList.get(3), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(3), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Shih Tzu
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(4), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(4), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 90, LocalTime.of(1, 30), dogList.get(4), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(4), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(4), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(4), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(4), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 190, LocalTime.of(1, 40), dogList.get(4), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(4), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Yorkshire terier
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(5), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(5), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 110, LocalTime.of(2, 0), dogList.get(5), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(5), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(5), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(5), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(5), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 200, LocalTime.of(2, 0), dogList.get(5), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(5), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Sznaucer
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(6), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(1, 30), dogList.get(6), dogServiceTypeList.get(1), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(6), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(2, 0), dogList.get(6), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(6), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(6), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(6), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(6), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 190, LocalTime.of(1, 40), dogList.get(6), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(6), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Cairn Terrier
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(7), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(1, 30), dogList.get(7), dogServiceTypeList.get(1), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 25, LocalTime.of(0, 20), dogList.get(7), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(2, 0), dogList.get(7), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(7), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(7), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(7), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(7), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 190, LocalTime.of(1, 40), dogList.get(7), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(7), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Jack Russel Terrier
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(8), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(1, 30), dogList.get(8), dogServiceTypeList.get(1), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 25, LocalTime.of(1, 20), dogList.get(8), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(2, 0), dogList.get(8), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(8), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(8), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(8), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(8), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 150, LocalTime.of(1, 40), dogList.get(8), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(8), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Wyżeł niemiecki szorstkowłosy
//        dogService = new DogService(null, 60, LocalTime.of(0, 40), dogList.get(9), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 80, LocalTime.of(1, 0), dogList.get(9), dogServiceTypeList.get(1), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(9), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 110, LocalTime.of(2, 0), dogList.get(9), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(9), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(9), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(9), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(9), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 200, LocalTime.of(2, 0), dogList.get(9), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(9), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Jamnik Szorstkowłosy
//        dogService = new DogService(null, 50, LocalTime.of(0, 50), dogList.get(10), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 70, LocalTime.of(2, 0), dogList.get(10), dogServiceTypeList.get(1), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(10), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 80, LocalTime.of(1, 0), dogList.get(10), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(10), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(10), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(10), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(10), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(1, 0), dogList.get(10), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(10), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Bichon frise
//        dogService = new DogService(null, 90, LocalTime.of(1, 30), dogList.get(11), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(11), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 110, LocalTime.of(2, 0), dogList.get(11), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(11), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(11), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(11), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(11), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 180, LocalTime.of(2, 0), dogList.get(11), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(11), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Fox terier
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(12), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(12), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(1, 40), dogList.get(12), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(12), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(12), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(12), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(12), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 150, LocalTime.of(2, 0), dogList.get(12), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(12), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Maltańczyk
//        dogService = new DogService(null, 90, LocalTime.of(1, 30), dogList.get(13), dogServiceTypeList.get(0), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(13), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 110, LocalTime.of(1, 50), dogList.get(13), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(13), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(13), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(13), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(13), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 160, LocalTime.of(2, 0), dogList.get(13), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(13), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Labrador
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(14), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 70, LocalTime.of(1, 0), dogList.get(14), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(14), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(14), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(14), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(14), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 110, LocalTime.of(1, 30), dogList.get(14), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(14), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Syberian Husky
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(15), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 70, LocalTime.of(1, 0), dogList.get(15), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(15), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(15), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(15), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(15), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 120, LocalTime.of(1, 0), dogList.get(15), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(15), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Owczarek Niemiecki
//        dogService = new DogService(null, 30, LocalTime.of(0, 20), dogList.get(16), dogServiceTypeList.get(2), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 75, LocalTime.of(1, 0), dogList.get(16), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(16), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(16), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(16), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(16), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 120, LocalTime.of(1, 0), dogList.get(16), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(16), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
////        Pozostałe rasy
//        dogService = new DogService(null, 80, LocalTime.of(1, 30), dogList.get(17), dogServiceTypeList.get(3), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 15), dogList.get(17), dogServiceTypeList.get(4), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 15, LocalTime.of(0, 10), dogList.get(17), dogServiceTypeList.get(5), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 10, LocalTime.of(0, 10), dogList.get(17), dogServiceTypeList.get(6), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 20, LocalTime.of(0, 20), dogList.get(17), dogServiceTypeList.get(7), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 100, LocalTime.of(2, 0), dogList.get(17), dogServiceTypeList.get(8), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        dogService = new DogService(null, 0, LocalTime.of(0, 20), dogList.get(17), dogServiceTypeList.get(9), Collections.emptyList());
//        dogServiceRepository.save(dogService);
//
//        return dogServiceList;
//    }
//}
