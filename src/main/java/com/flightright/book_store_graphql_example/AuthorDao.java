package com.flightright.book_store_graphql_example;

import java.util.List;
import java.util.Objects;

public class AuthorDao {
    private final List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public Author getAuthor(Integer id) {
        return authors.stream()
                .filter(author -> Objects.equals(id, author.id()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
