package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@AllArgsConstructor                                                                             //Generuje konstruktor dla klasy, który przyjmuje jako argumenty wszystkie pola
@NoArgsConstructor                                                                                  //Generuje konstruktor dla klasy, który nie przyjmuje argumentów
@Data                                                                                           //generuje settery, gettery, oraz metody z klasy Object(@Getter, @Setter, @HashCodeAndEquals, @RequiredArgsConstructor oraz @ToString)
@Entity
public class Visit {
    // Klasa model / szablon wizyty | pozwala nam na zapis
    //wszelkich niezbednych informacji na temat wizyty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    private LocalTime startTime;
    private VisitStatus status;
    private double totalCost;
    private LocalTime totalTime;

    @ManyToOne(fetch = FetchType.LAZY)                                                      //Lazy -pobierz dopiero kiedy będzie pierwsze odwołanie do tego obiektu
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Visit_DogService",
            joinColumns = {@JoinColumn(name = "visit_id")},
            inverseJoinColumns = {@JoinColumn(name = "dogService_id")}
    )
    private List<DogService> dogServiceList;
}
