package pl.sda.dao;

import pl.sda.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2018-03-02 at 20:00
 */

//zapis i odczyt do pliku robimy poprzez Serializację i Desarializację!
public class PersonDaoFile implements PersonDao {

    private static final String FILE_NAME = "datasource.txt";

    private static final String PERSON = "PERSON";
    // private static final String PASSWORD = "PASSWORD";
    private static final String DELIMITER = ";";
    // private static final String PASSOWRD = "PASSWORD";

    private static final Path PATH = Paths.get(FILE_NAME);


    @Override
    public List<Person> getPersons() {

        List<Person> persons = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(PATH);

            for (String line : lines) {
                String[] tab = line.split(DELIMITER);

                persons.add(getPersonWithGivenParams(tab));
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return persons;
    }

    //------------metoda pomocnicza---------------
    private Person getPersonWithGivenParams(String[] params) {
        return new Person(params[1], params[2], params[3], params[4]);
    }


    @Override
    public boolean savePersons(List<Person> persons) {

        try {
            for (Person person : persons) {
                Files.write(PATH, getPersonAsString(person).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String getPersonAsString(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PERSON)
                .append(DELIMITER)
                .append(person.getName())
                .append(DELIMITER)
                .append(person.getSurname())
                .append(DELIMITER)
                .append(person.getLogin())
                .append(DELIMITER)
                .append(person.getPassword())
                .append(DELIMITER)
                .append("\n");
        return sb.toString();
    }

}
