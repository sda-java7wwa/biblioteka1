package pl.sda.view;

import pl.sda.Exception.InvalidUserException;
import pl.sda.model.Book;
import pl.sda.model.Person;
import pl.sda.service.LibraryServiceImpl;
import pl.sda.service.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * Created by TOSHIBA-L775 on 2018-03-02.
 */
public class Main {
    public static final String PERSON_FILE_NAME = "persons-prod.txt";

    public enum State {
        INIT,
        DURING_LOGIN,
        DURING_REGISTRATION,
        LOGGED_IN,
        STOP
    }

    private List<Book> bookList;

    private static Person currentUser = null;

    public static void main(String[] args) throws InvalidUserException {
        Scanner scanner = new Scanner(System.in);

        State state = State.INIT;

        while(state != State.STOP) {
            switch (state) {
                case INIT: {
                    state = handleInit(scanner);
                    break;
                }
                case DURING_LOGIN: {
                    state = handleDuringLogin(scanner);
                    break;
                }
                case DURING_REGISTRATION:
                    state = handleDuringRegistration(scanner);
                    break;
                case LOGGED_IN:
                    state = handleInitLoggedInShowBookAndShowCategory(scanner);
                    break;
                default:
                        System.out.println("Podano zła opcje");
            }
        }
    }

    private static State handleInit(Scanner scanner) {
        System.out.println("Dzień dobry");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - zalogować się");
        System.out.println("2 - zarejestrować się");
        System.out.println("3 - wyjść z programu");

        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                return State.DURING_LOGIN;
            case 2:
                return State.DURING_REGISTRATION;
            case 3:
                return State.STOP;
            default:
                System.out.println("Podano złą opcję");
                return State.INIT;
        }
    }

    private static State handleDuringLogin(Scanner scanner) throws InvalidUserException{
        System.out.println("Podaj login");
        String userlogin = scanner.next();
        System.out.println("Podaj hasło");
        String password = scanner.next();
        PersonServiceImpl userService = new PersonServiceImpl(PERSON_FILE_NAME);

        try {
            currentUser = userService.login(userlogin, password);
            return State.LOGGED_IN;
        } catch (InvalidUserException ex){
            return State.INIT;
        }

    }

    private static State handleDuringRegistration(Scanner scanner) throws InvalidUserException{
        System.out.println("Podaj Imie");
        String userName = scanner.next();
        System.out.println("Podaj Nazwisko");
        String userSurname = scanner.next();
        System.out.println("Podaj login");
        String userLogin = scanner.next();
        System.out.println("Podaj hasło");
        String userPassword = scanner.next();
        System.out.println("Podaj jeszcze raz  hasło");
        String userPassword2 = scanner.next();

        PersonServiceImpl userService = new PersonServiceImpl(PERSON_FILE_NAME);

        try {
            currentUser = userService.signUp(userName, userSurname, userLogin, userPassword, userPassword2);
            return State.LOGGED_IN;
        } catch (InvalidUserException e){
            return State.INIT;
        }
    }

    private static State handleInitLoggedInShowBookAndShowCategory(Scanner scanner){
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - Wyswietł liste ksiazek");
        System.out.println("2 - Wyswietł kategorie ksiazek");
        System.out.println("3 - wyjść z programu");

        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                libraryService.showBooks();
                handleInitCheckIfBookIsBorrowedORReturned(scanner);
                return State.LOGGED_IN;
            case 2:
                //Trzeba jeszcze napisać metode showCategory w LibraryServiceImpl ;
                //libraryService.showCategory();
                handleInitCheckIfBookIsBorrowedORReturned(scanner);
                return State.LOGGED_IN;
            case 3:
                return State.STOP;
            default:
                System.out.println("Podano złą opcję");
                return State.LOGGED_IN;
        }
    }

    //FIXME robisz kolejny stan kazdy moment kiedy pytasz co dalej to nowy stan
    private static State handleInitCheckIfBookIsBorrowedORReturned(Scanner scanner){
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - Wypożyczyć ksiżke");
        System.out.println("2 - Oddać książke");
        System.out.println("3 - wyjść z programu");

        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                libraryService.checkIfBookIsBorrowed();
                return State.LOGGED_IN;
            case 2:
                libraryService.checkIfBookIsReturned();
                return State.LOGGED_IN;
            case 3:
                return State.STOP;
            default:
                System.out.println("Podano złą opcję");
                return State.LOGGED_IN;
        }
    }
}












