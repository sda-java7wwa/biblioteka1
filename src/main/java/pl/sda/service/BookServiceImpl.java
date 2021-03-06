package pl.sda.service;

import pl.sda.bookEnum.BookStatus;
import pl.sda.dao.LibraryDaoFile;
import pl.sda.model.Book;

import java.util.Iterator;
import java.util.List;

public class BookServiceImpl implements BookService {
    private LibraryDaoFile libraryDaoFile;

    public BookServiceImpl(String fileName) {
        this.libraryDaoFile = new LibraryDaoFile(fileName);
    }


    @Override
    public void showBooks() {
       Iterator<Book> it = libraryDaoFile.getListOfBooks().iterator();
       while (it.hasNext()) {
          System.out.println(it.next());
       }

    }



    @Override
    public boolean checkIfBookIsBorrowed(Book book) {
        if (book.getStatus().equals(BookStatus.AVAILABLE)) {
            book.setStatus(BookStatus.UNAVAILABLE);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfBookIsReturned(Book book) {
        return book.getStatus().equals(BookStatus.AVAILABLE);
    }
}