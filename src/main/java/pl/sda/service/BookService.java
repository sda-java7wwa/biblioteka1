package pl.sda.service;

import pl.sda.model.Book;

public interface BookService {

    void showBooks();
    boolean checkIfBookIsBorrowed(Book book);
    boolean checkIfBookIsReturned(Book book);

}