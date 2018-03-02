package pl.sda.service;

import pl.sda.dao.PersonDao;
import pl.sda.model.Person;

/**
 * Created by yulia on 02.03.2018 at 19:17
 */
public class PersonServiceImplementation implements PersonService{
    private PersonDao personDao;

    @Override
    public boolean singUp(String name, String surname, String login, String password) {
//        if (!login.equals()){
//            new Person(name, surname, login, password);
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }

    @Override
    public boolean login(String login, String password) {
//        if (login.equals() ){
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }
}
