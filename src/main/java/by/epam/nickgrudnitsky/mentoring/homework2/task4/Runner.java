package by.epam.nickgrudnitsky.mentoring.homework2.task4;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Author dostoevsky = new Author("Fyodor Dostoevsky", (short) 59, new ArrayList<>());
        Author bukowski = new Author("Charles Bukowski", (short) 73, new ArrayList<>());
        Author cervantes = new Author("Miguel de Cervantes", (short) 68, new ArrayList<>());

        Book idiot = new Book("The Idiot", Collections.singletonList(dostoevsky), 639);
        Book crimeAndPunishment = new Book("Crime and Punishment", Collections.singletonList(dostoevsky), 782);
        Book donQuixote = new Book("Don Quixote", Collections.singletonList(cervantes), 546);
        Book postOffice = new Book("Post Office", Collections.singletonList(bukowski), 215);
        Book women = new Book("Women", Collections.singletonList(bukowski), 365);
        Book factotum = new Book("Factotum", Collections.singletonList(bukowski), 165);

        dostoevsky.getBooks().add(idiot);
        dostoevsky.getBooks().add(crimeAndPunishment);
        cervantes.getBooks().add(donQuixote);
        bukowski.getBooks().add(postOffice);
        bukowski.getBooks().add(women);
        bukowski.getBooks().add(factotum);

        Author[] authors = {dostoevsky, bukowski, cervantes};
        Book[] books = {idiot, crimeAndPunishment, donQuixote, postOffice, women, factotum};
        System.out.println("Books with more than 200 pages:");
        Arrays.stream(books)
                .parallel()
                .filter(e -> e.getNumberOfPages() > 200)
                .forEach(System.out::println);

        Arrays.stream(books)
                .parallel()
                .min(Comparator.comparing(Book::getNumberOfPages))
                .ifPresent(min -> System.out.println("Min pages book is " + min));

        Arrays.stream(books)
                .parallel()
                .max(Comparator.comparing(Book::getNumberOfPages))
                .ifPresent(max -> System.out.println("Max pages book is " + max));

        System.out.println("Single author books:");
        Arrays.stream(books)
                .parallel()
                .filter(e -> e.getAuthors().size() == 1)
                .forEach(System.out::println);

        System.out.println("Sorted by pages number:");
        Arrays.stream(books)
                .parallel()
                .sorted(Comparator.comparing(Book::getNumberOfPages))
                .forEachOrdered(System.out::println);

        System.out.println("Sorted by title:");
        Arrays.stream(books)
                .parallel()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEachOrdered(System.out::println);

        System.out.println("Book's titles:");
        Arrays.stream(books)
                .parallel()
                .map(Book::getTitle)
                .forEach(System.out::println);

        System.out.println("Distinct authors:");
        Arrays.stream(books)
                .parallel()
                .map(Book::getAuthors)
                .distinct()
                .forEach(System.out::println);

        Arrays.stream(authors)
                .limit(1)
                .flatMap(e -> e.getBooks().stream())
                .max(Comparator.comparing(Book::getNumberOfPages))
                .ifPresent(book -> System.out.println("Title of the biggest book of some author " + book.getTitle()));

    }
}
