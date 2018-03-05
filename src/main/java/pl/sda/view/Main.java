package pl.sda.view;

import pl.sda.service.PersonServiceImpl;

import java.util.Scanner;

/**
 * Created by TOSHIBA-L775 on 2018-03-02.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String newLine = System.getProperty("line.separator");
        PersonServiceImpl personServiceImplementation = new PersonServiceImpl();
        System.out.println("Wybierz:"+newLine+"1 - Logowanie"+newLine+"2 - Rejestracja"+newLine+"0 - Zakonczenie Programu");
        int input = scanner.nextInt();

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
                personServiceImplementation.login(login1, password);
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
                personServiceImplementation.signUp(name, surname, login2, password1, password2);
                break;
            default:
                System.out.println("Coś poszło nie tak, spróbuj jeszcze raz");
        }

    }

}












