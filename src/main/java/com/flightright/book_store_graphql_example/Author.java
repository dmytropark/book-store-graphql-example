package com.flightright.book_store_graphql_example;

public record Author(Integer id, String firstName, String lastName, Integer bookId, Integer starRating) {

    public String fullName() {
        return firstName + " " + lastName;
    }

}
