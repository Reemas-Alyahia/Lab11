package com.example.lab11.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;


    @NotNull(message = "User Id cannot be Empty!..")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "User Id cannot be Empty!..")
    @Column(columnDefinition = "int not null")
    private Integer postId;


    @NotEmpty(message = "content cannot be Empty!..")
    @Column(columnDefinition = "varchar(30) not null")
    private String content;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate commentDate= LocalDate.now();

    public Comment(Integer commentId, Integer userId, Integer postId, String content, LocalDate commentDate) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.commentDate = commentDate;
    }

    public Comment() {

    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }
}

