package pl.sda.dao;

import pl.sda.model.Book;
import pl.sda.model.BookCategory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yulia on 08.03.2018 at 17:58
 */
public class BookCategoriesDaoFile implements BookCategoryDao {
    private String fileName;

    public BookCategoriesDaoFile(String  fileName){
        this.fileName = fileName;
    }

    @Override
    public List<BookCategory> getListOfCategories() {
        List<BookCategory> list = new ArrayList<>();
        BookCategory deserializiedBookCategory = null;
        do {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.fileName));
                deserializiedBookCategory = (BookCategory) inputStream.readObject();
                if (deserializiedBookCategory != null) {
                    list.add(deserializiedBookCategory);
                }

            }catch (EOFException e){
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Nie udało pobrać się z bazy");
            } catch (ClassNotFoundException e) {
                System.out.println("Nie udało pobrać się z bazy");
            } catch (IOException e) {
                System.out.println("Nie udało pobrać się z bazy");
            }

        } while (deserializiedBookCategory != null);
        return list;
    }

    @Override
    public boolean saveListOfCategories(BookCategory bookCategory) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.fileName, true));
            outputStream.writeObject(bookCategory);
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
