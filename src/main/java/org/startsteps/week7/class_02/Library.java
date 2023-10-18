package org.startsteps.week7.class_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Library {
    private ArrayList<Book> books;
    private HashMap<Integer, Book> bookMap;
    private HashSet<Book> favoriteBooks;

    public Library() {
        books = new ArrayList<>();
        bookMap = new HashMap<>();
        favoriteBooks = new HashSet<>();
    }

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getId(), book);
    }

    public Book findBookById(int id) {
        return bookMap.get(id);
    }

    public void removeBook(Book book) {
        books.remove(book);
        bookMap.remove(book.getId());
        favoriteBooks.remove(book);
    }

    public void addBookToFavorites(Book book) {
        favoriteBooks.add(book);
    }

    public void removeBookFromFavorites(Book book) {
        favoriteBooks.remove(book);
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book: books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }

    // add search by title

    public void displayBooks() {
        System.out.println("All books: ");
        for (Book book: books) {
            System.out.println(book);
        }
    }

    public void displayFavoriteBooks() {
        System.out.println("Favorite books: ");
        for (Book book: favoriteBooks) {
            System.out.println(book);
        }
    }
}
