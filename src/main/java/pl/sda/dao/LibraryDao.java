package pl.sda.dao;

import pl.sda.model.Book;


import java.util.List;


public interface LibraryDao {
    List<Book> getListOfBooks();
    boolean saveListOfBooks(Book book);

}
