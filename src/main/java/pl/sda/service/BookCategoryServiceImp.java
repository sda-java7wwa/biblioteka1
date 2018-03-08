package pl.sda.service;

import pl.sda.dao.BookCategoriesDaoFile;
import pl.sda.model.BookCategory;

/**
 * Created by yulia on 07.03.2018 at 21:36
 */
public class BookCategoryServiceImp implements BookCategoryService {
    private BookCategoriesDaoFile bookCategoriesDaoFile;

    public BookCategoryServiceImp(String fileName) {
        this.bookCategoriesDaoFile = new BookCategoriesDaoFile(fileName);
    }

    @Override
    public void showCategory(String nazwaBookCategory) {
        bookCategoriesDaoFile.getListOfCategories()
                .stream()
                .filter(bookCategory1 -> bookCategory1.getName().equals(nazwaBookCategory))
                .forEach(System.out::println);
    }
}
