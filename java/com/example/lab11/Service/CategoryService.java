package com.example.lab11.Service;

import com.example.lab11.ApiResponce.ApiExeption;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    public void addNewCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category,Integer id){
        Category oldCategory=categoryRepository.findCategoriesByCategoryId(id);
        if(oldCategory==null){
            throw new ApiExeption("No users yet");
        }
        oldCategory.setName(category.getName());
   categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer id){
        Category category=categoryRepository.findCategoriesByCategoryId(id);
        if(category==null){
            throw new ApiExeption("No Category yet");
        }
       categoryRepository.delete(category);
    }

    public List<Category> getCategoryByName(String name){
        List<Category> newlist=categoryRepository.getCategoryByName(name);
        if(newlist==null){
            throw new ApiExeption("No Category yet");
        }

        return newlist;
    }

}
