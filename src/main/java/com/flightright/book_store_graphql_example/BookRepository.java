package com.flightright.book_store_graphql_example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {

    private final AuthorRepository authorRepository;

    private List<Book> books = new ArrayList<>();

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book save(BookInput bookInput) {
        List<Book> all = findAll();
        all.sort(Comparator.comparing(Book::id).reversed());

        Book book =  new Book(all.get(all.size() - 1).id() + 1,
                bookInput.getName(),
                bookInput.getPageCount(),
                Rating.ONE_STAR, Arrays.asList(authorRepository.findByName("Mark Heckler")));

        books.add(book);

        return book;
    }

    public Book findOne(Integer id) {
        return books.stream()
                .filter(book -> Objects.equals(book.id(), id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostConstruct
    private void init() {
        final Author author1 = new Author(1, "Josh", "Long", 1, 1);
        authorRepository.add(author1);

        final Author author2 = new Author(2, "Mark", "Heckler", 1, 2);
        authorRepository.add(author2);

        final Author author3 = new Author(3, "Greg", "Turnquist", 2, 3);
        authorRepository.add(author3);

        books.add(new Book(1,
                "Reactive Spring",
                484,
                Rating.FIVE_STARS,
                Arrays.asList(author1, author2)));

        books.add(new Book(2,
                "Spring Boot Up & Running",
                328,
                Rating.FIVE_STARS,
                List.of(author3)));

        books.add(new Book(3,
                "Hacking with Spring Boot 2.3",
                392,
                Rating.FIVE_STARS,
                null));
    }

    public Book findBookByName(String name) {
        return books.stream()
                .filter(book -> name.equals(book.title()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
