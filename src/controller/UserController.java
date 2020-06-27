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
        users.forEach(user -> System.out.println(user));
//        users.forEach(System.out::println);         // jeszcze krócej
    }
    @Override
    public boolean loginUser(String email, String password) {
        return false;
    }
    @Override
    public void updatePasswordByUserId(int userId, String newPassword) { }


    public static void main(String[] args) {
        UserController uc = new UserController();
        uc.registerUser(new User("X","X","x@x.pl","x",'K'));
        uc.registerUser(new User("Y","Y","y@y.pl","y",'M'));
        uc.registerUser(new User("Z","Z","z@z.pl","z",'M'));
        System.out.println("Wypisanie wszystkich użytkowników:");
        uc.printAllUsers();
    }
}
