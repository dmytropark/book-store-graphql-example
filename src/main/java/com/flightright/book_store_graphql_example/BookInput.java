package com.flightright.book_store_graphql_example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInput {
    String name;
    Integer pageCount;
}
