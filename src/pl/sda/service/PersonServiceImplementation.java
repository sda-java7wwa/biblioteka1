package pl.sda.service;

import pl.sda.dao.PersonDao;
import pl.sda.dao.PersonDaoFile;
import pl.sda.model.Person;

/**
 * Created by yulia on 02.03.2018 at 19:17
 */
public class PersonServiceImplementation implements PersonService{
    private PersonDao personDao = new PersonDaoFile();

    @Override
    public boolean signUp(String name, String surname, String login, String password1, String password2) {
        if (loginNotExists(login)){
            if (password1.equals(password2)) {
                new Person(name, surname, login, password1);
                return true;
            }
        }
        return false;
    }

    private boolean loginNotExists(String login){
        return personDao.getPersons()
                .stream()
                .anyMatch(person -> !person.getLogin().equals(login));
    }

    @Override
    public boolean login(String login, String password) {
        return personDao.getPersons()
                .stream()
                .anyMatch(person -> person.getLogin().equals(login) && person.getPassword().equals(password));
    }

}
