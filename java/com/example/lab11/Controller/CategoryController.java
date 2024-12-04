package com.example.lab11.Controller;

import com.example.lab11.ApiResponce.ApiResponce;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/get")
    public ResponseEntity getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }


    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
    categoryService.addNewCategory(category);
        return ResponseEntity.status(200).body("Category Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id,@RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        categoryService.updateCategory(category,id);
        return ResponseEntity.status(200).body("Category updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body("post Deleted");
    }

    @GetMapping("/getname/{name}")
    public ResponseEntity getAllTitle(@PathVariable String name){
        List<Category> categories=categoryService.getCategoryByName(name);
        return ResponseEntity.status(200).body(categories);
    }
}
