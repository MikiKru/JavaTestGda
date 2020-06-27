package exception;
// Klasa reprezentująca błąd działania aplikacji
// 1. Klasa którą można nasłuchiwać w bloku catch
// 2. Klasa dziedzicząca po nadklasie Exception
public class MyException extends Exception {
    public MyException() {
        System.out.println("Jesteśmy w moim wyjątku!");
    }
    @Override
    public void printStackTrace(){
        super.printStackTrace();            // super -> wywołanie metody z klasy nadrzędnej
        System.out.println("... tu może być mój dodatkowy komunikat");
    }

}
