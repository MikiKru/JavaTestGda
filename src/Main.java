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
        // odwołanie do pól klasowych
        u1.name = "Michał";
        u2.name = "Anna";
        // wyołanie metody toString() na obiekcie u1
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println("User 1: " + u1.name);
        System.out.println("User 2: " + u2.name);

    }
}
