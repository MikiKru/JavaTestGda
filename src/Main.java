import model.User;
// Hints:
// CTRL + D - duplikowanie lini kodu
// ALT + Ins - auto-generowanie fragmentów kodu
// ALT + Enter - auto-podpowiedź
// CTRL + / - auto-komentowanie/odkomentowanie
public class Main {
    public static void main(String[] args) {
        // utowrzenie obiektu
        User u1 = new User();
        User u2 = new User();
        // wywołanie setterów
        u1.setName("Michał");
        u2.setName("Anna");
        u2.setGender('K');
        // wyołanie metody toString() na obiekcie u1
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        // wywołanie getterów
        System.out.println("User 1: " + u1.getName());
        System.out.println("User 2: " + u2.getName());
        System.out.println("User 2: " + u2.getGender());
        // porównanie obiektów
        System.out.println("Czy obiekty są takie same? "
                + u1.equals(u2));
        User u3 = new User();   // inicjalizuje nowy obiekt
        u3.setName("Michał");
        System.out.println(u1.toString());
        System.out.println(u3.toString());
        System.out.println("Czy obiekty są takie same? "
                + u1.equals(u3));
        User u4 = u1;           // obiekt inicjalizowany istejącą instancją
        System.out.println("Czy obiekty są takie same? "
                + u1.equals(u4));
        u4.setEmail("test@test.pl");
        System.out.println(u1.toString());
        System.out.println(u4.toString());
    }
}
