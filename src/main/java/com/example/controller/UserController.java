package com.example.controller;

import com.example.ExceptionHandlers.CustomUserException;
import com.example.Model.Users;
import com.example.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/add")
    @ApiOperation("to add users")
    public String   addUsers( @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String permissions,
                           @RequestParam boolean acc_active){
        Users users=new Users();
        users.setUserId(UUID.randomUUID().toString());
        users.setEmail(email);
        users.setPassword(passwordEncoder().encode(password));
        users.setPermissions(permissions);
        users.setAcc_active(acc_active);
        this.userRepository.save(users);
        return "user created successfully";
    }
    
    @PutMapping("/update")
    public String   enableUser(@RequestParam String email) throws  RuntimeException{
      List<Users> users= this.userRepository.findByEmail(email);
      if(users.size()>0){
          Users user=users.get(0);
          user.setAcc_active(true);
          this.userRepository.save(user);
      }
      else {
          throw  new CustomUserException("User"," email" ,email);
      }
      return "user activated successfully";
    }
    
    @PutMapping("/updatePassword")
    @ApiOperation("to update user password")
    public String updatePassword(@RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String newPassword) throws RuntimeException {
        List<Users> users= this.userRepository.findByEmail(email);
        if(users.size()<=0){
           throw  new CustomUserException("User"," email" ,email);
        }else{
            Users user  =  users.get(0);
         BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
         if(email.equals(user.getEmail()) &&encoder.matches(password,user.getPassword())) {
             user.setPassword(encoder.encode(newPassword));
             this.userRepository.save(user);
             return "password changed successfully";
         }
            else{
                return "Incorrect password";
            }
        }
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}