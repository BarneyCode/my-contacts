package zw.co.barney.mycontacts.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import zw.co.barney.mycontacts.validation.PasswordPolicy;
import zw.co.barney.mycontacts.validation.UniqueUsername;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @NotEmpty(message = "please enter your firstname")
    private String firstName;
    @NotEmpty(message = "please enter your lastname")
    private String lastName;
    @NotEmpty(message = "please enter your username")
    //@UniqueUsername
    private String username;
    @NotEmpty(message = "please enter your password")
    @PasswordPolicy
    private String password;
    @NotEmpty(message = "please enter your email")
    @Email(message = "Email provided is not valid")
    //@UniqueEmail
    private String email;
    @NotEmpty(message = "please enter your phone number")
    private String phone;


    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;



    public User() {
    }
}
