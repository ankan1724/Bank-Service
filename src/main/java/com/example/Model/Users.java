package com.example.Model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
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
    @Email
    @NonNull
    private String email;
    @Size(min = 8, max = 100)
    @NonNull
    private String password;
    private boolean acc_active;
    @NonNull
    private String permissions;
    
}