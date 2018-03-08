package pl.sda.dao;

import pl.sda.model.BookCategory;

import java.util.List;

/**
 * Created by yulia on 08.03.2018 at 17:57
 */
public interface BookCategoryDao {
    List<BookCategory> getListOfCategories();
    boolean saveListOfCategories(BookCategory bookCategory);
}
