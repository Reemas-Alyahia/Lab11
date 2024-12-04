package com.example.lab11.Controller;

import com.example.lab11.ApiResponce.ApiResponce;
import com.example.lab11.Model.User;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UseController {

    private final UserService userService;

    public UseController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity getAlluser(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addnewUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addNewUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(user,id);
        return ResponseEntity.status(200).body("User updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User Deleted");
    }

    @GetMapping("/getUser/username/{username}/passwords/{pass}")
    public ResponseEntity logIn(@PathVariable String username,@PathVariable String pass){
        User user=userService.logIn(username,pass);
        return ResponseEntity.status(200).body(user);

    }
    @GetMapping("/getemail/{email}")
    public ResponseEntity getEmail(@PathVariable String email){
        User user=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

@GetMapping("/registration/{date}")
  public ResponseEntity getUsersByRegistrationDate(@PathVariable LocalDate date){
       List <User> user=userService.getUsersByRegistrationDate(date);
       return ResponseEntity.status(200).body(user);
  }

}
