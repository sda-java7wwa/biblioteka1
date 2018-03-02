package pl.sda.dao;

import pl.sda.model.Person;

import java.util.List;

/**
 * Created by x on 2018-03-02 at 20:00
 */

//zapis i odczyt do pliku robimy poprzez Serializację i Desarializację!
public class PersonDaoFile implements PersonDao{


    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public boolean savePersons(List<Person> clients) {
        return false;
    }
}
