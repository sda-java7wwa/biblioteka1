package pl.sda.view;

import pl.sda.model.Book;
import pl.sda.model.BookCategory;

/**
 * Created by yulia on 08.03.2018 at 19:48
 */
public class Maain {
    public static void main(String[] args) {
            BookCategory root = new BookCategory("Główna");

            BookCategory subcategory1 = new BookCategory("sub1");
            BookCategory subcategory2 = new BookCategory("sub2");

            BookCategory subcategory3 = new BookCategory("sub3");
            BookCategory subcategory4 = new BookCategory("sub4");

            root.addSubcategory(subcategory1);
            root.addSubcategory(subcategory2);

            subcategory2.addSubcategory(subcategory3);
            subcategory2.addSubcategory(subcategory4);


            Book book0 = new Book("Ogniem i mieczem", "Sienkiewicz", subcategory1, 4569);
            Book book1 = new Book("Pan Tadeusz", "Mickiewicz", subcategory2, 9987);
            Book book2 = new Book("Nad Niemnem", "Orzeszkowa", subcategory3, 8990);
            Book book3 = new Book("Balladyna", "Słowacki", subcategory4, 9897);

            subcategory1.addBook(book0);
            subcategory2.addBook(book1);
            subcategory4.addBook(book2);
            subcategory4.addBook(book3);


            printTreeNode(subcategory2);
    }

     private static void printTreeNode(BookCategory bookCategory) {
            System.out.println("Category : " + bookCategory.getName());

            System.out.println("Books:");
            for(Book book : bookCategory.getBookList()) {
                //System.out.println(" * " + book.toString());
                System.out.println(" * " + book.getAuthor() + " "
                        + book.getTitle() + " " + book.getId());
            }

            for(BookCategory bookCategory1 : bookCategory.getBookCategories()) {
                printTreeNode(bookCategory1);
            }
        }
}
