package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository////wskazuje że klasa pozwala na dostęp do danych, np. wspiera obsługę bazy danych. Adnotacje tą stosujemy np. w obiektach typu DAO(obiekt dostępu do danych. Jest to klasa, która pozwala na pobieranie, dodawanie, usuwanie i modyfikowanie danych)
public interface UserRepository extends CrudRepository<User, Integer> {

    //interfejs typu crud pozwala na pozyskiwanie jak i zapisywanie informacji z / do bazy danych tabeli user

    Optional<User> findByEmail(String email);
}
