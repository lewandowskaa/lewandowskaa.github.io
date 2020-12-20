package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor                                                                     //Generuje konstruktor dla klasy, który przyjmuje jako argumenty wszystkie pola
@NoArgsConstructor                                                                      //Generuje konstruktor dla klasy, który nie przyjmuje argumentów
@Data                                                                                   //generuje settery, gettery, oraz metody z klasy Object(@Getter, @Setter, @HashCodeAndEquals, @RequiredArgsConstructor oraz @ToString)
@Entity                                                                                 //Adnotacja ta nie wymaga żadnych parametrów (możemy wybrać nazwę — pewnego rodzaju alias lub nazwe klasy)
public class Dog {                                                                      //tabela nazywa się tak jak klasa

    // Klasa model / szablon bytu jakim jest pies | pozwala na
    //przechowywanie niezbednych informacji do dzialania aplikacji na temat psa

    @Id                                                                                 //identyfikator (unikalny) tego obiektu. Najczęściej jest to pole typu Long o nazwie id lub podobnej
    @GeneratedValue(strategy = GenerationType.IDENTITY)                                 //identyfikator ten jest generowany automatycznie w momencie zapisu do bazy danych.
    private Integer id;

    private String type;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DogService> dogServiceList;
}
