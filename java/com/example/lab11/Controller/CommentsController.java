package com.example.lab11.Controller;

import com.example.lab11.ApiResponce.ApiResponce;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {
    private final CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/get")
    public ResponseEntity getAllComments(){
        return ResponseEntity.status(200).body(commentService.getComment());
    }


    @PostMapping("/add")
    public ResponseEntity addComments(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
      commentService.addComment(comment);
        return ResponseEntity.status(200).body(" Comment Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@RequestBody @Valid Comment comment,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
       commentService.updateComment(comment,id);
        return ResponseEntity.status(200).body("Comment updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body("post Deleted");
    }

    @GetMapping("/commentDate/{date}")
    public ResponseEntity getCommentDate(@PathVariable LocalDate date){
        List<Comment>comments=commentService.getCommentDate(date);
        return ResponseEntity.status(200).body(comments);
    }
    @GetMapping("/allContent/{id}")
    public ResponseEntity getAllContent(@PathVariable Integer id){
        List<Comment>comments=commentService.getAllContent(id);
        return ResponseEntity.status(200).body(comments);

    }

}
