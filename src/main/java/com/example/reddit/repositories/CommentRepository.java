package com.example.reddit.repositories;

import com.example.reddit.models.Comment;
import com.example.reddit.models.Post;
import com.example.reddit.models.Subreddit;
import com.example.reddit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
