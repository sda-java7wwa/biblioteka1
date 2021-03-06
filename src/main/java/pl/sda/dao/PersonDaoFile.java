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
    private String fileName;

    public PersonDaoFile(String fileName) {
        this.fileName = fileName;
    }



    @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        Person deserializiedPerson = null;
        do {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.fileName));
                deserializiedPerson = (Person) inputStream.readObject();

                if (deserializiedPerson != null) {
                    list.add(deserializiedPerson);
                }
            } catch (EOFException e){
                    return null;
            } catch (FileNotFoundException e) {
                System.out.println("Nie udało pobrać się z bazy");
                e.printStackTrace();
                return null;


            } catch (ClassNotFoundException e) {
                System.out.println("Nie udało pobrać się z bazy");
                return null;
            } catch (IOException e) {
                System.out.println("Nie udało pobrać się z bazy");
                return null;
            }

        } while (deserializiedPerson != null);
        return list;
    }


    @Override
    public boolean savePerson(Person person) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.fileName, true));
            outputStream.writeObject(person);
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało zapisac się do bazy");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.out.println("Nie udało zapisac się do bazy");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

