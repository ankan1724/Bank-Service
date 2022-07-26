package com.example.Model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String email;
    private String password;
    private boolean acc_active;
    private String permissions;
}