package com.example.lap11.Repository;

import com.example.lap11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
//
    User findUserByEmail(String email);



}
