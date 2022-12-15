package com.flightright.book_store_graphql_example;

import lombok.Data;

@Data
public class Post {
    private String id;
    private String title;
    private String text;
    private String category;
    private Integer authorId;
}