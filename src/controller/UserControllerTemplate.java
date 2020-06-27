package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

// Czym jest interfejs?
// 1. Nie jest to klasa i nie możemy tworzyć obiektu interfejsu!
// 2. Szablon wymagań dla klasy go implementującej i udostępnia pola publiczne i statyczne
// 3. Może posiadać:
// 3.1. Metody abstrakcyjne
// 3.2. Wszystkie składowe są publiczne
// 3.3. Pola i metody statyczne
public interface UserControllerTemplate {
    // globalna kolekcja obiektów klasy User
    List<User> users = new ArrayList<>();       // lista zawsze indeksuje od 0 do size() - 1
                                                // przy usuwaniu nie ma 'dziur' w indeksach
    // Rejstracja użytkownika
    void registerUser(User user);
    // Logowanie użytkownika
    boolean loginUser(String email, String password);
    // Zmiana hasła użytkownika
    void updatePasswordByUserId(int userId, String newPassword);
    // Wypisanie wsystkich użytkowników
    void printAllUsers();
}
