package controller;

import exception.MyException;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            if(user == null) {
                throw new MyException();            // rzucanie wyjątku -> utworzenie obiektu klasy wyjątku
            }
            user.setPassword(newPassword);          // jeżeli nie wystąpi wyjątek blok catch się nie wykonuje
        } catch (MyException e){
            System.out.println("Obsługa mojego wyjątku");
            e.printStackTrace();
//        } catch(NullPointerException e){            // argumentem w bloku catch jest klasa wyjątku
//            System.out.println("Nie ma użytkownika o id=" + userId);
//            e.printStackTrace();                    // metoda drukująca na konsoli systemowy komunikat błędu
//        } catch (Exception e){
//            System.out.println("Wystąpił jakiś błąd?!");
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
    public void saveToFile(){
        try {
            // Klasa dedykowana do zapisu do pliku określonego ścieżką bezpośrednią
            PrintWriter pw = new PrintWriter(new File("C:\\Users\\PROXIMO\\Desktop\\TestGDA\\JavaBasic\\src\\file\\users.csv"));
            for (User user : users) {
                pw.write(user.getUserId()+";"+user.getName()+";"+user.getLastName()+";"+user.getEmail()
                +";"+user.getPassword()+";"+user.getGender()+"\n");
            }
            pw.close();             // zamknięcie pliku
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\PROXIMO\\Desktop\\TestGDA\\JavaBasic\\src\\file\\users.csv"));
            while (scanner.hasNextLine()){  // jeżeli istnieje kolejna linijka w pliku to przesuń kursor
                String line [] = scanner.nextLine().split(";");
                users.add(new User(line[1], line[2], line[3], line[4], line[5].charAt(0)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        UserController uc = new UserController();
//        uc.registerUser(new User("X","X","x@x.pl","x",'K'));
//        uc.registerUser(new User("Y","Y","y@y.pl","y",'M'));
//        uc.registerUser(new User("Z","Z","z@z.pl","z",'M'));
        // CLI - command line interface
        uc.readFromFile();                          // odczytujemy zawartośc z pliku i przepisujemy do listy users
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        while(isRun) {
            System.out.println("APLIKACJA X");
            System.out.println("1. rejestracja\n2. logowanie \n3. zmiana hasła \n4. pokaż wszystkich \n0. wyjście");
            int choice = scanner.nextInt();
            scanner.nextLine();         // instrukcja konsumująca \n po wprowadzonej liczbie - tak aby nie przesuwać kursora w konsoli
            switch (choice) {
                case 1:
                    System.out.println("Podaj imię: ");
                    String name = scanner.nextLine();
                    System.out.println("Podaj nazwisko: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Podaj email: ");
                    String login = scanner.nextLine();
                    System.out.println("Podaj hasło: ");
                    String password = scanner.nextLine();
                    System.out.println("Podaj płeć (M/K): ");
                    char gender = scanner.nextLine().toUpperCase().charAt(0);
                    if(gender == 'M' || gender == 'K') {
                        uc.registerUser(new User(name, lastName, login, password, gender));
                    } else {
                        System.out.println("Płeć musi być opisana M lub K");
                    }
                    break;
                case 2:
                    System.out.println("Podaj email: ");
                    String logEmail = scanner.nextLine();
                    System.out.println("Podaj hasło: ");
                    String logPassword = scanner.nextLine();
                    System.out.println(uc.loginUser(logEmail,logPassword) ? "zalogowano: "+logEmail : "błąd logowania");
                    break;
                case 3:
                    System.out.println("Podaj id użytkownika");
                    int userId = scanner.nextInt();
                    scanner.nextLine();             // konsumujemy \n
                    System.out.println("Podaj nowe hasło");
                    String newPassword = scanner.nextLine();
                    uc.updatePasswordByUserId(userId, newPassword);
                    System.out.println("Zapisano nowe hasło");
                    break;
                case 4:
                    uc.printAllUsers();
                    break;
                case 0:
                    isRun = false;
                    uc.saveToFile();                    // zapis aktualnych danych do pliku
                    break;
                default:
                    System.out.println("Błędny wybór");
            }
        }




    }
}
