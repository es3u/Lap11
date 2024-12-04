package com.example.lap11.Controller;

import com.example.lap11.Model.User;
import com.example.lap11.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        List list = userService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid User user , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        userService.save(user);
        return ResponseEntity.ok().body("added successfully");
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody@Valid User user , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
       userService.updateUser(id,user);
        return ResponseEntity.ok().body("updated successfully");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("deleted successfully");
    }

    @GetMapping("/findUserByEmail")
    public ResponseEntity findUserByEmail(String email) {
        User user = userService.findUserByEmail(email);
        return ResponseEntity.ok().body(user);
    }







}
