package com.flightright.book_store_graphql_example;

import java.util.List;

public record Book(Integer id, String title, Integer pages, Rating rating, List<Author> authors) {

}
