package pl.sda.dao;

import pl.sda.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2018-03-02 at 20:00
 */

//zapis i odczyt do pliku robimy poprzez Serializację i Desarializację!
public class PersonDaoFile implements PersonDao {



    private static String FILE_NAME = "datasource.txt";



    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        Person deserializiedPerson = null;
        do {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                deserializiedPerson = (Person) inputStream.readObject();
                if (deserializiedPerson != null) {
                    list.add(deserializiedPerson);
                }

                //FIXME cos co jest bledne ale zostawiamy na pozniej
                //TODO "sysetem r" - komunikaty o bledzie technicznym
            } catch (FileNotFoundException e) {
                System.out.println("Nie udało pobrać się z bazy");
            } catch (ClassNotFoundException e) {
                System.out.println("Nie udało pobrać się z bazy");
            } catch (IOException e) {
                System.out.println("Nie udało pobrać się z bazy");
            }

        } while (deserializiedPerson != null);
        return list;
    }


    @Override
    public boolean savePerson(Person person) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true));
            outputStream.writeObject(person);
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało zapisac się do bazy");
            return false;
        } catch (IOException e) {
            System.out.println("Nie udało zapisac się do bazy");
            return false;
        }
        return true;
    }

}

