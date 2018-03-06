package pl.sda.model;

import pl.sda.bookEnum.BookCategory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book implements Serializable{
    private String title;
    private String author;
    private BookCategory category;
    private int id;

    public Book(String title, String author, BookCategory category, int id) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                category == book.category;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, category, id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", id=" + id +
                '}';
    }
}
