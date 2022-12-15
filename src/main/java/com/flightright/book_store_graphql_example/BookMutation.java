package com.flightright.book_store_graphql_example;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class BookMutation {

    private final BookRepository bookRepository;

    @MutationMapping
    public NewBook newBook(@Argument("input") BookInput bookInput) {
        Book book1 = bookRepository.save(bookInput);
        return new NewBook(book1.id(), book1.title(), book1.pages());
    }

    @MutationMapping
    public DeletedBook deleteBook(@Argument("input") DeleteBookInput deleteBookInput){
        return null;
//        Book deleteBook = new Book();
//        Optional<Book> findBook =  bookRepository.findById(deleteBookInput.getId());
//        if(findBook.isPresent()) {
//            bookRepository.delete(findBook.get());
//            deleteBook = findBook.get();
//        }
//        return new DeletedBook(deleteBook.getId(), deleteBook.getName(), deleteBook.getPageCount());
    }
}
