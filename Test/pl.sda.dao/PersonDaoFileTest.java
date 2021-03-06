package pl.sda.dao;
//dwie versje sa nikompatybilne
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.model.Person;
import pl.sda.service.PersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2018-03-05 at 19:06
 */
public class PersonDaoFileTest {
    public static final String PERSON_FILE_NAME = "persons-test.txt";

    //new PersonDao w beforze dac
    private PersonDaoFile personDaoFile;

    @Before
    public void setUp() {
        personDaoFile = new PersonDaoFile(PERSON_FILE_NAME);
    }

    @After
    public void cleanUp() {
        // TODO remove persons file
    }

    @Test
    public void testSavePersons(){

      //  System.out.println("Test dymny");

        Person persons1 = new Person("Krzysztof", "Krupa", "Krisu", "123456");
        Person persons2 = new Person("Tomek", "Domek", "Tom", "123456789");


        personDaoFile.savePerson(persons1);
        personDaoFile.savePerson(persons2);

       // personDaoFile.getPersons();

    }

    @Test
    public void testGetPerson(){

        personDaoFile.getPersons()
                .forEach(System.out::print);

        Person person = personDaoFile
                .getPersons().get(1);
      //  Assertions.assertEquals(1,personDaoFile.getPersons().size());
        Assertions.assertEquals("Krzysztof" , person.getName());

    }
}
