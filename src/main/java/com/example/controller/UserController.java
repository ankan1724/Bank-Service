package com.example.controller;

import com.example.Model.Users;
import com.example.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/add")
    @ApiOperation("to add users")
    public String addUsers(@RequestParam String email,
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
    public String enableUser(@RequestParam String email){
      List<Users> users= this.userRepository.findByEmail(email);
      if(users.size()>0){
          Users user=users.get(0);
          
          user.setAcc_active(true);
          this.userRepository.save(user);
      }
      return "user activated successfully";
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}