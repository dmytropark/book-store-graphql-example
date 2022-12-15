package com.flightright.book_store_graphql_example;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

import static com.flightright.book_store_graphql_example.ListOrder.ASC;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookRepository.findOne(id);
    }

    @QueryMapping
    public Book getBookByName(@Argument("filter") BookFilter bookFilter){
        return bookRepository.findBookByName(bookFilter.getName());
    }

    @SchemaMapping(typeName="Book", field="authorsSorted")
    public Iterable<Author> authors(Book book, @Argument ListOrder order) {
        List<Author> allAuthors = (List<Author>) authorRepository.findAllByBookId(book.id());

        if (order != null) {
            if (order.equals(ASC)) {
                allAuthors.sort(Comparator.comparingInt(Author::starRating));
            } else {
                allAuthors.sort(Comparator.comparingInt(Author::starRating).reversed());
            }
        }

        return allAuthors;
    }
}
