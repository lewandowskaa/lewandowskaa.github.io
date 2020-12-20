package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor                                                         ////Generuje konstruktor dla klasy, który przyjmuje jako argumenty wszystkie pola
@NoArgsConstructor                                                      ////Generuje konstruktor dla klasy, który nie przyjmuje argumentów
@Data                                                                   ///generuje settery, gettery, oraz metody z klasy Object(@Getter, @Setter, @HashCodeAndEquals, @RequiredArgsConstructor oraz @ToString)
@Entity                                                                     //umieszczamy nad całą klasą, która ma być mapowana
public class DogService {//tabela nazywa się tak jak klasa

    // Klasa model / szablon psiej uslugi dla wskazanego psa
    //wraz z cena i czasem wykonania
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double price;                                                   //kolumny nazywają się tak, jak pola i są odpowiedniego typu
    private LocalTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dog dog;

    @ManyToOne(fetch = FetchType.LAZY)
    private DogServiceType dogServiceType;

    @ManyToMany(mappedBy = "dogServiceList", fetch = FetchType.LAZY)
    private List<Visit> visitList;
}
