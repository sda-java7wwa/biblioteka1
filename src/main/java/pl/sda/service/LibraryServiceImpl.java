package pl.sda.service;

import pl.sda.bookEnum.BookStatus;
import pl.sda.model.Book;
import pl.sda.model.Library;

public class LibraryServiceImpl implements LibraryService {
    private Library library;

    @Override
    public void showBooks() {

    }

    @Override
    public boolean checkIfBookIsBorrowed() {
        if (library.getStatus().equals(BookStatus.AVAILABLE)) {
            library.setStatus(BookStatus.UNAVAILABLE);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfBookIsReturned() {
        return library.getStatus().equals(BookStatus.AVAILABLE);
    }
}