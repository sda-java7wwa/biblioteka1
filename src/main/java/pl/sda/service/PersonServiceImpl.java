package pl.sda.service;

import pl.sda.Exception.InvalidUserException;
import pl.sda.dao.PersonDao;
import pl.sda.dao.PersonDaoFile;
import pl.sda.model.Person;

import java.util.stream.Stream;

/**
 * Created by yulia on 02.03.2018 at 19:17
 */
public class PersonServiceImpl implements PersonService{
    private PersonDaoFile personDao = new PersonDaoFile();

    @Override
    public Person signUp(String name, String surname, String login, String password1, String password2) throws
            InvalidUserException{
        try {
            if (loginNotExists(login)){
                if (password1.equals(password2)) {
                    Person person = new Person(name, surname, login, password1);
                    personDao.savePerson(person);
                    return person;
                } else {
                    throw new InvalidUserException("Passwords not equal");
                }
            } else {
                throw new InvalidUserException("This login is already taken");
            }

        } catch (NullPointerException e){
            System.out.println("Stream is empty");
        }
        return null;
    }

    private boolean loginNotExists(String login){
        return personDao.getPersons()
                .stream()
                .anyMatch(person -> !person.getLogin().equals(login));
    }

    @Override
    public Person login(String login, String password) throws InvalidUserException{
        if (personDao.getPersons().stream().anyMatch(person -> person.getLogin().equals(login)
                && person.getPassword().equals(password))){
            return personDao.getPersons()
                    .stream()
                    .filter(person -> person.getLogin().equals(login) && person.getPassword().equals(password))
                    .findFirst()
                    .get();
        } else {
            throw new InvalidUserException("Invalid login or password");
        }
    }

}
