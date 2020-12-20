package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.model.Visit;
import com.example.demo.model.VisitStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository//wskazuje że klasa pozwala na dostęp do danych, np. wspiera obsługę bazy danych. Adnotacje tą stosujemy np. w obiektach typu DAO(obiekt dostępu do danych. Jest to klasa, która pozwala na pobieranie, dodawanie, usuwanie i modyfikowanie danych)
public interface VisitRepository extends CrudRepository<Visit, Integer> {

    //interfejs typu crud pozwala na pozyskiwanie jak i zapisywanie informacji z / do bazy danych tabeli visit


    Optional<Visit> findFirstByUserAndStatus(User user, VisitStatus visitStatus);

    List<Visit> findAllByUserAndStatus(User user, VisitStatus visitStatus);

    List<Visit> findAllByStatusOrderByDateAsc(VisitStatus visitStatus);

    List<Visit> findAllByStatusAndDateOrderByStartTime(VisitStatus visitStatus, LocalDate date);
}
