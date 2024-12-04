package com.example.lab11.Service;

import com.example.lab11.ApiResponce.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CommentRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class CommentService {
    private final CommentRepository commentRepository;
   private  final UserRepository userRepository;
   private  final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getComment(){
        return commentRepository.findAll();
    }

    public void addComment(Comment comment){
        User user=userRepository.getUserByUserId(comment.getUserId());
        if(user==null){
            throw new ApiExeption("User not Found");
        }
      Post post1=postRepository.findPostByPostId(comment.getPostId());
        if(post1==null){
            throw new ApiExeption("Post not found...");
        }
        commentRepository.save(comment);

    }

    public void updateComment(Comment comment,Integer id){
     Comment oldcomment=commentRepository.findCommentByCommentId(id);
        if(oldcomment==null){
            throw new ApiExeption("No Comment yet");
        }
        User user=userRepository.getUserByUserId(comment.getUserId());
        if(user==null){
            throw new ApiExeption("User not Found");
        }
        Post post=postRepository.findPostByPostId(comment.getCommentId());
        if(post==null){
            throw new ApiExeption("Post not found...");
        }
        oldcomment.setPostId(comment.getPostId());
        oldcomment.setUserId(comment.getUserId());
        oldcomment.setCommentDate(comment.getCommentDate());
        oldcomment.setContent(comment.getContent());

        commentRepository.save(oldcomment); }


    public void deleteComment(Integer id){
       Comment comment=commentRepository.findCommentByCommentId(id);
        if(comment==null){
            throw new ApiExeption("No comment yet");
        }
     commentRepository.delete(comment);
    }

/// /get all Comment for one post by post_id
public List<Comment> getAllContent(Integer id){
    List<Comment> newlist=commentRepository.getAllComment(id);
    if(newlist==null){
        throw new ApiExeption("No content yet");
    }

    return newlist;
}

    public List<Comment> getCommentDate(LocalDate commente) {
        List<Comment>comments = commentRepository.findsCommentDate(commente);
        if (comments.isEmpty()) {
            throw new ApiExeption("No comments found with the comments date ");
        }
        return comments;
    }





}
