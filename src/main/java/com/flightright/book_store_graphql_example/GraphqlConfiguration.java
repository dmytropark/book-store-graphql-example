package com.flightright.book_store_graphql_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setCategory("Post category");
                post.setText("Post " + postId + " + by author " + authorId);
                post.setAuthorId(authorId);
                posts.add(post);
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author(authorId, "Author FN" + authorId, "Author LN" + authorId, 1, 1);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }
}
