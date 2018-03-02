package pl.sda.service;

import pl.sda.model.Person;

/**
 * Created by yulia on 02.03.2018 at 19:16
 */
public interface PersonService {
    boolean singUp(String name, String surname, String login, String passowd);
    boolean login(String login, String password);
}
