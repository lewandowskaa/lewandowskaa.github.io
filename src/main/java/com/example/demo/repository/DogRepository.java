package com.example.demo.repository;

import com.example.demo.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository////wskazuje że klasa pozwala na dostęp do danych, np. wspiera obsługę bazy danych. Adnotacje tą stosujemy np. w obiektach typu DAO(obiekt dostępu do danych. Jest to klasa, która pozwala na pobieranie, dodawanie, usuwanie i modyfikowanie danych)
public interface DogRepository extends CrudRepository<Dog, Integer> {

    //interfejs typu crud pozwala na pozyskiwanie informacji z bazy danych z tabeli dog

    List<Dog> findAll();
}
