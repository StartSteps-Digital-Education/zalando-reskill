package org.startsteps.week7.class_03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 10.99));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 2019, 12.50));
        books.add(new Book("1984", "George Orwell", 1949, 9.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 8.99));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 11.25));
        books.add(new Book("Moby-Dick", "Herman Melville", 1851, 14.75));
        books.add(new Book("War and Peace", "Leo Tolstoy", 2020, 13.99));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932, 10.25));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 12.99));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 17.50));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 15.75));
        books.add(new Book("The Odyssey", "Homer", 2022, 9.25));
        books.add(new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", 1892, 11.99));
        books.add(new Book("Frankenstein", "Mary Shelley", 1818, 8.50));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 12.99));

        

        long totalBooks = books.size();
        long totalBooksWithStream = books.stream().count();
        System.out.println(totalBooks);
        System.out.println(totalBooksWithStream);

        // find the avarage price of the books
        OptionalDouble averagePrice = books.stream()
                .mapToDouble(Book::getPrice)
                .average();


        Optional<Book> mostExpensiveBook = books.stream()
                .max(Comparator.comparing(Book::getPrice));

        // find books that were for the past 5 years
        int currentYear = LocalDate.now().getYear();
        List<Book> recentlyPublishedBooks = books.stream()
                .filter(book -> currentYear - book.getPublicationYear() <= 5)
                .toList();

        Map<String, List<Book>> booksWrittenByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));

        Map.Entry<String, List<Book>> authorWithMostWrittenBooks = booksWrittenByAuthor
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .orElse(null);

        long countBooksWithTitleStartingWithA = books.stream()
                .filter(book -> book.getTitle().startsWith("A"))
                .count();


        List<Book> topFiveExpensiveBooks = books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .limit(5)
                .toList();


        Map<String, Long> booksGroupedByDecade = books.stream()
                .collect(Collectors.groupingBy(book -> {
                    long from = (book.getPublicationYear() / 10) * 10;
                    long to = from + 9;

                    return from + "-" + to;
                }, Collectors.counting()));

        System.out.println(booksGroupedByDecade);
    }
}
