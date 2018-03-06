package pl.sda.service;


public class LibraryServiceImpl implements LibraryService {
    //private Library library;

    @Override
    public void showBooks() {

    }

    @Override
    public boolean checkIfBookIsBorrowed() {
//        if (library.getStatus().equals(BookStatus.AVAILABLE)) {
//            library.setStatus(BookStatus.UNAVAILABLE);
//            return true;
//        }
        return false;
    }

    @Override
    public boolean checkIfBookIsReturned() {
        return true;
        //return library.getStatus().equals(BookStatus.AVAILABLE);
    }
}