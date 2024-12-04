package com.example.lab11.Service;

import com.example.lab11.ApiResponce.ApiExeption;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){

        userRepository.save(user);
    }

    public void updateUser(User user,Integer id){
        User olduser=userRepository.getUserByUserId(id);
        if(olduser==null){
            throw new ApiExeption("No users yet");
        }
      olduser.setUsername(user.getUsername());
        olduser.setEmail(user.getEmail());
        olduser.setPassword(user.getPassword());
        olduser.setRegistrationDate(user.getRegistrationDate());
        userRepository.save(olduser);
    }

    public void deleteUser(Integer id){
        User user=userRepository.getUserByUserId(id);
        if(user==null){
            throw new ApiExeption("No users yet");
        }
        userRepository.delete(user);
    }

    public User logIn(String username,String passwords){
        User user =userRepository.login(username,passwords);
        if(user==null){
            throw new ApiExeption("Cannot found user like this");
        }
        return user;
    }

    public User findUserByEmail(String email){
        User user=userRepository.getEmail(email);
        if(user==null){
            throw new ApiExeption("Cannot found user like this");
        }
        return user;

    }

    public List<User> getUsersByRegistrationDate(LocalDate registrationDate) {
        List<User> users = userRepository.findByRegistrationDate(registrationDate);
        if (users.isEmpty()) {
            throw new ApiExeption("No users found with the registration date ");
        }
        return users;
    }


}
