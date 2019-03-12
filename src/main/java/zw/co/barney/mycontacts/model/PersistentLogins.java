package zw.co.barney.mycontacts.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 3/12/2019 10:29 PM
 */
@Entity
@Data
public class PersistentLogins {
    @Column(nullable = false)
    private String username;
    @Id
    @Column(nullable = false)
    private String series;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime lastUsed;
}
