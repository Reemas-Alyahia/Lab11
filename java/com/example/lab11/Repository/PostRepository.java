package com.example.lab11.Repository;

import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findPostByPostId(Integer id);

    /// JPQL//
    @Query("select p from Post p where p.title=?1")
    List<Post> getAllTitle(String title);
}
