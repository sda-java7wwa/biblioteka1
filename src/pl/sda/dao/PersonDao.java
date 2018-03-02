package pl.sda.dao;

import pl.sda.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by x on 2018-03-02 at 19:11
 */
public interface PersonDao {

    //dwie metody
    //metoda , logika biznesowa nie bedzie wiedziala skad pobiera , ona dostaje klienta i juz
    //zapisuje klientow z kontami

    List<Person> getPersons();

    //metoda do zapisu , metoda zwraca boolean
    // nie udalo sie zapisac bo costam

    //przekazujemy liste klientow ktorych chcemy zapisac
    boolean savePersons(List<Person> personss);

}
