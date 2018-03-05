package pl.sda.dao;

import pl.sda.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by x on 2018-03-02 at 19:11
 */
public interface PersonDao {

    List<Person> getPersons();
    boolean savePerson(Person person);

}
