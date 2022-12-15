package com.flightright.book_store_graphql_example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findById(int id) {
        return authors.stream()
                .filter(author -> author.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authors.stream()
                .filter(author -> author.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void add(Author author) {
        authors.add(author);
    }

    public Iterable<Author> findAllByBookId(Integer bookId) {
        return authors.stream()
                .filter(author -> author.bookId().equals(bookId))
                .collect(Collectors.toList());
    }
}
