package com.example.lap11.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//
//    @NotEmpty(message = "user name can not Empty")
    @Column( columnDefinition = "varchar(10)")
//    @Size(min = 3, max = 10)
    private String UserName;
//    @NotEmpty(message = "password can not be Empty")
    @Column(columnDefinition = "varchar(12)")
////    @Size(min = 6, max = 12)

    private String password;

   // @Email
    @Column(unique = true, columnDefinition = "varchar(50)")
    private String email;

    @Column(columnDefinition = "datetime ")
    private LocalDateTime registerDate;



    public Integer getUserId() {
        return id;
    }

    public void setUserId(Integer userId) {
        id = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName( String userName) {
        UserName = userName;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        password = password;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
}
