package com.example.lap11.Controller;

import com.example.lap11.Model.Post;
import com.example.lap11.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
         List list =postService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping("/AddPost")
    public ResponseEntity AddPost(@RequestBody@Valid Post post , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }

        postService.save(post);
        return ResponseEntity.ok().body("added is successfully");
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id ,@Valid Post post, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }

        postService.updatePost(id ,post);
        return ResponseEntity.ok().body("updated is successfully");

    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return ResponseEntity.ok().body("deleted is successfully");
    }

    @GetMapping("/findPostByUserId/{userId}")
    public ResponseEntity findPostByUserId(@PathVariable Integer userId){
        List list =postService.findPostByUserId(userId);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/findByPublish_date/{publish_date}")
    public ResponseEntity findByPublish_date(@PathVariable LocalDate publish_date){
        List list =postService.findByPublish_date(publish_date);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/findPostByCategoryId/{categoryId}")
    public ResponseEntity findPostByCategoryId(@PathVariable Integer categoryId){
        List list =postService.findPostByCategoryId(categoryId);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/findPostByUserId/{title}/{user_id}")
    public ResponseEntity findPostByUserId(@PathVariable String title , @PathVariable Integer user_id){
        Post post =postService.findPostByUserId(title,user_id);

        return ResponseEntity.ok().body(post);
    }
    @GetMapping("/findByBetweenTwoDate/{startDate}/{endDate}")
    public ResponseEntity findByBetweenTwoDate(LocalDate startDate, LocalDate endDate){
        List list =postService.findByBetweenTwoDate(startDate, endDate);

        return ResponseEntity.ok().body(list);
    }










}
