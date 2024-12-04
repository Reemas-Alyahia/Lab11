package com.example.lab11.Repository;

import com.example.lab11.Model.Comment;
import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findCommentByCommentId(Integer id);


    /// //JPQL

    @Query("select c from Comment c where c.postId=?1")
    List<Comment>getAllComment(Integer id);

    @Query("select c from  Comment c where c.commentDate = ?1")
    List<Comment> findsCommentDate(LocalDate commentDate);


}
