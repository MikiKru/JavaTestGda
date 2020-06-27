package model;
// Hints:
// CTRL + D - duplikowanie lini kodu

import java.time.LocalDateTime;

// Klasa User - to klasa modelu -> klasa determinująca strukturę danych
public class User {
    // pola klasowe -> pola o zasięgu widoczności w obrębie całej klasy
    String name;
    String lastName;
    String email;
    String password;
    LocalDateTime registratationDateTime;

}
