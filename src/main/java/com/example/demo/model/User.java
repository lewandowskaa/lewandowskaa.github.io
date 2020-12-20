package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor//Generuje konstruktor dla klasy, który przyjmuje jako argumenty wszystkie pola
@NoArgsConstructor//Generuje konstruktor dla klasy, który nie przyjmuje argumentów
@Data                                                                                                       //generuje settery, gettery, oraz metody z klasy Object(@Getter, @Setter, @HashCodeAndEquals, @RequiredArgsConstructor oraz @ToString)
@Entity//umieszczamy nad całą klasą, która ma być mapowana
public class User {

    // Klasa model / szablon bytu jakim jest uzytkownik

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visit> visitList;
}
