package pl.sda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by TOSHIBA-L775 on 2018-03-07.
 */
public class BookCategory {
    private String name;
    private List<BookCategory> bookCategories;
    private List<Book> bookList;


    public BookCategory (String name) {
        this.name = name;
        this.bookCategories = new ArrayList<>();
        this.bookList = new ArrayList<>();
    }


    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void addSubcategory(BookCategory bookCategory) {
        this.bookCategories.add(bookCategory);
    }

}
