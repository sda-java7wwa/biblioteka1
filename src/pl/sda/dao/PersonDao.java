package pl.sda.dao;

import pl.sda.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by x on 2018-03-02 at 19:11
 */
public interface PersonDao {

    //zwrocimy obiety typu person a jeszcze lepiej optional (opakowac go dodoatkowo)
    Optional<Person> getPersonByLogin (String login);


    //przekazujemy liste klientow ktorych chcemy zapisac
    boolean savePersons(List<Person> persons);
}
