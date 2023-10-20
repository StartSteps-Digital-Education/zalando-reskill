package org.startsteps.week7.class_02;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "Book title 1", "Author 1");
        Book book2 = new Book(1, "Book title 2", "Author 2");
        Book book3 = new Book(1, "Book title 3", "Author 3");
        Book book4 = new Book(1, "Book title 4", "Author 2");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.addBookToFavorites(book2);
        library.addBookToFavorites(book3);

        library.displayBooks();
        library.displayFavoriteBooks();

        System.out.println("Found book: " + library.findBookById(2));

        library.removeBook(book1);
        library.displayBooks();
        library.displayFavoriteBooks();

        List<Book> booksByAuthor = library.searchBookByAuthor("Author 2");
        System.out.println("Books by author 2");
        for (Book book : booksByAuthor) {
            System.out.println(book);
        }
    }
}
