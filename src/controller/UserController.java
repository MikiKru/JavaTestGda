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
    public boolean loginUser(String email, String password) {
        return false;
    }
    @Override
    public void updatePasswordByUserId(int userId, String newPassword) { }
    @Override
    public void printAllUsers() { }

    public static void main(String[] args) {
        UserController uc = new UserController();
        uc.registerUser(new User("X","X","x@x.pl","x",'K'));
        uc.registerUser(new User("Y","Y","y@y.pl","y",'M'));
    }
}
