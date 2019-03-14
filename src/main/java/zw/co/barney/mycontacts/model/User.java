package zw.co.barney.mycontacts.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import zw.co.barney.mycontacts.validation.PasswordPolicy;
import zw.co.barney.mycontacts.validation.UniqueEmail;
import zw.co.barney.mycontacts.validation.UniqueUsername;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 9:38 AM
 */
@Entity
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "please enter your First Name")
    private String firstName;
    @NotEmpty(message = "please enter your Last Name")
    private String lastName;
    @NotEmpty(message = "please enter your username")
    @UniqueUsername
    private String username;
    @NotEmpty(message = "please enter your Password")
    @PasswordPolicy
    private String password;
    @NotEmpty(message = "please enter your Email")
    @Email(message = "Email provided is not valid")
    @UniqueEmail
    private String email;
    @NotEmpty(message = "please enter your Phone Number")
    private String phone;


    @Column(updatable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;



    public User() {
    }
}
