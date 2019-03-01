package zw.co.barney.mycontacts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/21/2019 10:48 AM
 */
@Entity
@Data
public class AuthGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String authGroup;

    public AuthGroup(String username, String authGroup) {
        this.username = username;
        this.authGroup = authGroup;
    }

    public AuthGroup() {
    }
}
