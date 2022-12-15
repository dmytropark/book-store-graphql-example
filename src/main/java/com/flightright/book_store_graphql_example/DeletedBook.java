package com.flightright.book_store_graphql_example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeletedBook {
    private Integer id;
    private String name;
    private String pageCount;
}
