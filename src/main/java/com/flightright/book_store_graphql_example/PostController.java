package com.flightright.book_store_graphql_example;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class PostController {
    private final PostDao postDao;
    private final AuthorDao authorDao;

    public PostController(PostDao postDao, AuthorDao authorDao) {
        this.postDao = postDao;
        this.authorDao = authorDao;
    }

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postDao.getRecentPosts(count, offset);
    }

    @MutationMapping
    public Post createPost(
            @Argument String title,
            @Argument String text,
            @Argument String category,
            @Argument Integer authorId) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);
        postDao.savePost(post);

        return post;
    }
}
