package model;
import java.time.LocalDateTime;
// Model JavaBeans - wzorzec struktury składowych klasy
// 1. Wszystkie pola są prywatne
// 2. Publiczne gettery i settery - metody dostępowe
// 3. Konstruktor/y
// 4. Publiczna metoda ToString()
// Klasa User - to klasa modelu -> klasa determinująca strukturę danych
public class User extends Object{   // Każda klasa dziedziczy - prejmuje pola i metody klasy nadrzędnej
                                    // (zgodnie ze specyfikatorami dostępu)
    // pola klasowe -> pola o zasięgu widoczności w obrębie całej klasy
    private int userId;             // domyślnie 0
    private String name;            // domyślnie null
    private String lastName;        // domyślnie null
    private String email;           // domyślnie null
    private String password;        // domyślnie null
    private char gender;            // domyślnie ''
    private LocalDateTime registratationDateTime;   // domyślnie null
    private boolean status;         // domyślnie false
    // gdy nie ma innego kontruktora to zawsze jest tworzony konstruktor domyślny
    public User() {
        System.out.println("Jestem w konstruktorze domyślnym");
    }
    // konstruktor z wybranymi argumentami
    // Cel: przypisanie wartości z argumentów do pól klasowych
    public User(String name, String lastName, String email, String password, char gender) {
        this.name = name;           // przypisanie do pola klasowego wartości z argumentu
        // this.name -> przypisanie do pola name obiektu który został utworzony wartości z argumentu
        // this -> jest odwołaniem do obiektu czyli jego lokalizacji w pamięci podręcznej
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        // przypisanie domyślnego - aktualnego czasu rejestracji
        this.registratationDateTime = LocalDateTime.now();
        // przypisanie domyślnego statusu konta na true
        this.status = true;
        // przypisanie unikatowego identyfikatora użytkownika
        this.userId = 1;
        System.out.println("Jestem w konstruktorze z argumentami");
    }

    // Gettery i Settery
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public LocalDateTime getRegistratationDateTime() {
        return registratationDateTime;
    }
    public void setRegistratationDateTime(LocalDateTime registratationDateTime) {
        this.registratationDateTime = registratationDateTime;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
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
