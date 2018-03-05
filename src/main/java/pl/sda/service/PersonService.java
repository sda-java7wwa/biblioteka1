package pl.sda.service;

import pl.sda.model.Person;

/**
 * Created by yulia on 02.03.2018 at 19:16
 */
public interface PersonService {
    boolean signUp(String name, String surname, String login, String password1, String password2);
    boolean login(String login, String password);
}
