package pl.sda.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2018-03-05 at 19:06
 */
public class PersonDaoFileTest {

    private PersonDaoFile personDaoFile = new PersonDaoFile();


    @Test
    public void testSavePersons(){

        System.out.println("Test dymny");

//        List<Person> persons1 = new ArrayList<>();
//
//        persons1.add(new Person("Krzysztof", "Krupa", "Krisu", "123456"));
//
//        personDaoFile.savePerson((Person) persons1);

    }

    @Test
    public void testGetPerson(){

        personDaoFile.getPersons()
                .forEach(System.out::print);

        Person person = personDaoFile
                .getPersons().get(0);
        Assertions.assertEquals(1,personDaoFile.getPersons().size());
        Assertions.assertEquals("Krzysztof" , person.getName());

    }
}
