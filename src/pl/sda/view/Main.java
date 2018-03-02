package pl.sda.view;

import com.sun.org.apache.xpath.internal.SourceTree;
import pl.sda.service.PersonServiceImplementation;

import java.util.Scanner;

/**
 * Created by TOSHIBA-L775 on 2018-03-02.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int input = scanner.nextInt();
        System.out.println("Wybierz:\n1 - Logowanie\n2 - Rejestracja\n0 - Zakonczenie Programu");

        switch (input) {
            case 0:
                System.out.println("Koniec programu");
                System.exit(0);
                break;

            case 1:
                System.out.println("Logowanie:");
                System.out.println("Podaj Login");
                String login1 = scanner.next();
                System.out.println("Podaj Hasło");
                String password = scanner.next();
                login(login1, password);
                break;

            case 2:
                System.out.println("Podaj Imie:");
                String name = scanner.next();
                System.out.println("Podaj Nazwisko:");
                String surname = scanner.next();
                System.out.println("Podaj Login:");
                String login2 = scanner.next();
                System.out.println("Podaj Hasło:");
                String password1 = scanner.next();
                System.out.println("Podaj Hasło (potwierdzenie):");
                String password2 = scanner.next();
                signUp(name, surname, login2, password1, password2);
                break;
            default:
                System.out.println("Coś poszło nie tak, spróbuj jeszcze raz");
        }

    }

}












