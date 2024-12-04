package com.example.lab11.Service;

import com.example.lab11.ApiResponce.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private  final UserRepository userRepository;

    public PostService(PostRepository postRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }


    public List<Post> getPost(){
        return postRepository.findAll();
    }


    public void addPost(Post post){
        User user=userRepository.getUserByUserId(post.getUserId());
        if(user==null){
            throw new ApiExeption("User not Found");
        }
        Category category=categoryRepository.findCategoriesByCategoryId(post.getCategoryId());
        if(category==null){
            throw new ApiExeption("Category not found...");
        }
        postRepository.save(post);

    }

    public void updatePost(Post post,Integer id){
      Post oldpost=postRepository.findPostByPostId(id);
        if(oldpost==null){
            throw new ApiExeption("No Posts yet");
        }
        User user=userRepository.getUserByUserId(post.getUserId());
        if(user==null){
            throw new ApiExeption("User not Found");
        }
        Category category=categoryRepository.findCategoriesByCategoryId(post.getCategoryId());
        if(category==null){
            throw new ApiExeption("Category not found...");
        }
        oldpost.setCategoryId(post.getCategoryId());
        oldpost.setUserId(post.getUserId());
        oldpost.setTitle(post.getTitle());
        oldpost.setContent(post.getContent());
        postRepository.save(oldpost);
    }

    public void deletePost(Integer id){
        Post post=postRepository.findPostByPostId(id);
        if(post==null){
            throw new ApiExeption("No Posts yet");
        }
       postRepository.delete(post);
    }


    public List<Post> getAllTitle(String title){
        List<Post> newlist=postRepository.getAllTitle(title);
        if(newlist==null){
            throw new ApiExeption("No title yet");
        }

        return newlist;
    }

    public Post findPostById(Integer id){
        Post post=postRepository.findPostByPostId(id);
        if(post==null){
            throw new ApiExeption("No Posts yet");
        }
        return post;
    }

}
