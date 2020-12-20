package com.example.demo.repository;

import com.example.demo.model.Dog;
import com.example.demo.model.DogService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository////wskazuje że klasa pozwala na dostęp do danych, np. wspiera obsługę bazy danych. Adnotacje tą stosujemy np. w obiektach typu DAO(obiekt dostępu do danych. Jest to klasa, która pozwala na pobieranie, dodawanie, usuwanie i modyfikowanie danych)
public interface DogServiceRepository extends CrudRepository<DogService, Integer> {

    //interfejs typu crud pozwala na pozyskiwanie jak i zapisywanie informacji z / do bazy danych tabeli dogService

    List<DogService> findAllByDog(Dog dog);
}
