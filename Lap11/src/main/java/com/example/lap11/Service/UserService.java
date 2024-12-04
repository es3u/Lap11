package com.example.lap11.Service;

import com.example.lap11.ApiResponse.ApiException;
import com.example.lap11.Model.User;
import com.example.lap11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        return userRepository.findAll();

    }

    public void save(User user) {
        user.setRegisterDate(LocalDateTime.now());
        userRepository.save(user);
    }


    public void updateUser(Integer id ,User user) {

        User updateUser = userRepository.findUserById(id);

        if (updateUser != null) {
            updateUser.setUserName(user.getUserName());
            updateUser.setPassword(user.getPassword());
            updateUser.setEmail(user.getEmail());
            user.setRegisterDate(LocalDateTime.now());
            userRepository.save(updateUser);
        }
        throw new ApiException("user not found");
    }


    public void deleteUser(Integer id) {
        User deleteUser = userRepository.findUserById(id);
        if (deleteUser != null) {
            userRepository.delete(deleteUser);
        }
        throw new ApiException("user not found");
    }

    public User findUserByEmail(String email) {
       User user = userRepository.findUserByEmail(email);

        if(user == null) {
            throw new ApiException("user not found");
        }
        return user;

    }








}
