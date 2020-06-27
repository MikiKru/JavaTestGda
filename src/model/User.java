package model;
import java.time.LocalDateTime;

// Klasa User - to klasa modelu -> klasa determinująca strukturę danych
public class User extends Object{   // Każda klasa dziedziczy - prejmuje pola i metody klasy nadrzędnej
                                    // (zgodnie ze specyfikatorami dostępu)
    // pola klasowe -> pola o zasięgu widoczności w obrębie całej klasy
    int userId;             // domyślnie 0
    public String name;            // domyślnie null
    String lastName;        // domyślnie null
    String email;           // domyślnie null
    String password;        // domyślnie null
    char gender;            // domyślnie ''
    LocalDateTime registratationDateTime;   // domyślnie null
    boolean status;         // domyślnie false

    // public - widoczna w całym programie
    // String - typ zwracanej wartości w return
    // toString() - nazwa metody (nie przyjmuje argumentów)
    @Override       // nadpisuje implementację metody toString() z klasy Object
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", registratationDateTime=" + registratationDateTime +
                ", status=" + status +
                '}';
    }
}
