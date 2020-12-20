package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor//Generuje konstruktor dla klasy, który przyjmuje jako argumenty wszystkie pola
@NoArgsConstructor//Generuje konstruktor dla klasy, który nie przyjmuje argumentów
@Data //generuje settery, gettery, oraz metody z klasy Object(@Getter, @Setter, @HashCodeAndEquals, @RequiredArgsConstructor oraz @ToString)
@Entity//umieszczamy nad całą klasą, która ma być mapowana
public class DogServiceType {

    // Klasa model / szablon rodzaj psiej uslugi

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @OneToMany(mappedBy = "dogServiceType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DogService> dogServiceList;
}
