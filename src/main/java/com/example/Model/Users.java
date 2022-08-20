package com.example.Model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="AUTHENTICATED_USERS_DB")
public class Users {
    @Id
    private String userId;
    @Email(message = "Email must be valid")
    @NonNull
    private String email;
   /* @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){8,100}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")*/
    @NonNull
    @Size(min = 8,max = 100)
    private String password;
    private boolean acc_active;
    @NonNull
    private String permissions;
    
}