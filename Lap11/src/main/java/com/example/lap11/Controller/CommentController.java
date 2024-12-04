package com.example.lap11.Controller;

import com.example.lap11.Model.Comment;
import com.example.lap11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/comment")

public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @PostMapping("/addComment")
    public ResponseEntity addComment(@RequestBody@Valid Comment comment , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        commentService.save(comment);
        return ResponseEntity.ok("added comment");
    }

    @PutMapping("/updateComment/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id ,@RequestBody@Valid Comment comment , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.ok("updated comment");
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.ok("deleted comment");
    }
    @GetMapping("/findCommentByUId/{id}")
    public ResponseEntity findCommentByUId(@PathVariable Integer id){
        return ResponseEntity.ok(commentService.findCommentByUId(id));
    }

    public ResponseEntity findCommentByPostAndDateAndUserID(Integer id, Integer postId, LocalDate date){
        Comment comment = commentService.findCommentByPostAndDateAndUserID(id, postId, date);
        return ResponseEntity.ok(comment);
    }

}
