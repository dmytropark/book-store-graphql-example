package com.flightright.book_store_graphql_example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewBook {
    private Integer id;
    private String name;
    private Integer pageCount;
}
