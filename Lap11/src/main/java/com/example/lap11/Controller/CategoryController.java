package com.example.lap11.Controller;

import com.example.lap11.Model.Category;
import com.example.lap11.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){

        return ResponseEntity.ok().body(categoryService.findAll());
    }
    @PostMapping("/addCategory")
    public ResponseEntity addCategory(@RequestBody@Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        categoryService.save(category);
        return ResponseEntity.ok().body("added is successfully");
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@RequestBody@Valid Category category , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        categoryService.updateCategory(id,category);
        return ResponseEntity.ok().body("updated is successfully");
    }


    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body("deleted is successfully");
    }



}
