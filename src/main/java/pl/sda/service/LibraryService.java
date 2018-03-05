package pl.sda.service;

public interface LibraryService {

    void showBooks();
    boolean checkIfBookIsBorrowed();
    boolean checkIfBookIsReturned();

}