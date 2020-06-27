package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

// UserController - klasa kontrolera -> klasa obsługująca i dostarczająca logikę biznesową aplikacji
public class UserController implements UserControllerTemplate{
    @Override
    public void registerUser(User user) {
        // 1. Zapisz użytkownika w liście users utworzonej w interfejsie UserControllerTemplate
        users.add(user);
        System.out.println("Zarejestrowano nowego użytkownika: " + user.toString());
    }
    @Override
    public void printAllUsers() {
        // 1. W pętli wypisz wszystkie elementy
//        for(int i=0; i<users.size(); i++){          // WYTYCZNE: stosujemy gdy znana jest liczba iteracji
//            System.out.println(users.get(i));
//        }
//        int i = 0;
//        while (i < users.size()){                   // WYTYCZNE: sosujemy gdy nieznana jest liczba iteracji
//            System.out.println(users.get(i));
//            i ++;
//        }
//        for(User user : users){                     // for(TypElementuKolekcji nazwaTymczasowegoObiektu : kolekcja)
//            System.out.println(user);               // WYTYCZNE: stosujemy do kolekcji, ale tylko do odczytu
//        }
        // CTRL + Space -> utwórz predykat -> przekształcenie
        // LambdaExpression - wyrażenie lambda
        // StreamAPI
        users.forEach(user -> System.out.println(user));
//        users.forEach(System.out::println);         // jeszcze krócej
    }
    @Override
    public boolean loginUser(String email, String password) {
        // 1. W pętli szukamy użytkownika z emailem i hasłem jak w argumentach
        for(User user : users){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;        // return działa jak break czyli gdy wystąpi przerywa wykonywanie metody
            }
        }
        return false;
    }
    @Override
    public void updatePasswordByUserId(int userId, String newPassword) {
        try {                                       // try{ zawiera linijki kodu w których może wystąpić wyjątek }
            User user = findUserById(userId);       // jeżeli wystąpi wyjątek przechodzimy do bloku catch
            user.setPassword(newPassword);          // jeżeli nie wystąpi wyjątek blok catch się nie wykonuje
        } catch(NullPointerException e){            // argumentem w bloku catch jest klasa wyjątku
            System.out.println("Nie ma użytkownika o id=" + userId);
            e.printStackTrace();                    // metoda drukująca na konsoli systemowy komunikat błędu
        } catch (Exception e){
            System.out.println("Wystąpił jakiś błąd?!");
        } finally {                                 // wykonywane jest zawsze niezależnie czy wystąpił błąd czy nie
            System.out.println("Jestem w finally");
        }
    }
    // metoda nie znajdująca się w interfejsie
    public User findUserById(int userId){
        for (User user : users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;    // gdy nie znaleziono użytkownika zwróć null -> brak wartości
    }

    public static void main(String[] args) {
        UserController uc = new UserController();
        uc.registerUser(new User("X","X","x@x.pl","x",'K'));
        uc.registerUser(new User("Y","Y","y@y.pl","y",'M'));
        uc.registerUser(new User("Z","Z","z@z.pl","z",'M'));
        System.out.println("Wypisanie wszystkich użytkowników:");
        uc.printAllUsers();
        // Wyrażenie 3-argumentowe: warunek ? wartość zwracana jeżeli true : wartość zwracana jeżeli false
        String login = "z@z.pl";
        String password = "z";
        System.out.println(uc.loginUser(login,password) ? "zalogowano: "+login : "błąd logowania");
        System.out.println("Zmiana hasła");
        uc.updatePasswordByUserId(10, "qwe123");
//        System.out.println(uc.findUserById(10).getPassword());
        System.out.println("Jeszcze działam!");
    }
}
