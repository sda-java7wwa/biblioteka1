package pl.sda.dao;
import pl.sda.model.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TOSHIBA-L775 on 2018-03-05.
 */
public class LibraryDaoFile implements LibraryDao {
    private String fileName;

    public LibraryDaoFile(String  fileName){
        this.fileName = fileName;
    }

    @Override
    public List<Book> getListOfBooks() {
        List<Book> list = new ArrayList<>();
        Book deserializiedBook = null;
        do {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(this.fileName));
                deserializiedBook = (Book) inputStream.readObject();
                if (deserializiedBook != null) {
                    list.add(deserializiedBook);
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

        } while (deserializiedBook != null);
        return list;

    }

    @Override
    public boolean saveListOfBooks(Book book) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.fileName, true));
            outputStream.writeObject(book);
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
