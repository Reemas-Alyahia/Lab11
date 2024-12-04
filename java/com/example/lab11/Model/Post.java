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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @NotNull(message = "category Id cannot be Empty!..")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotEmpty(message = "title cannot be Empty!..")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;


    @NotEmpty(message = "content cannot be Empty!..")
    @Column(columnDefinition = "varchar(30) not null")
    private String content;

    @NotNull(message = "User Id cannot be Empty!..")
    @Column(columnDefinition = "int not null")
    private Integer userId;


        @JsonFormat(pattern = "yyyy-MM-dd")
       @Column(columnDefinition = "DATE", nullable = false)
        private LocalDate publishDate = LocalDate.now();

    public Post() {

    }

    public Post(Integer postId, Integer categoryId, String title, String content, Integer userId, LocalDate publishDate) {
        this.postId = postId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.publishDate = publishDate;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
