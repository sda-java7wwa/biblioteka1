package pl.sda.model;

import pl.sda.bookEnum.BookCategory;
import pl.sda.bookEnum.BookStatus;

import java.util.List;
import java.util.Objects;

public class Library {


    //FIXME to jest zbedne
    private List<Book> bookList;
    private BookStatus status;  //TODO status i person do book
    private Person person;

    public Library(List<Book> bookList, BookStatus status, Person person) {
        this.bookList = bookList;
        this.status = status;
        this.person = person;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(bookList, library.bookList) &&
                status == library.status &&
                Objects.equals(person, library.person);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookList, status, person);
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", status=" + status +
                ", person=" + person +
                '}';
    }


}
