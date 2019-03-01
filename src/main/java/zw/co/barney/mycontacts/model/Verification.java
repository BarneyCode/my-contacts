package zw.co.barney.mycontacts.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/24/2019 7:50 PM
 */
@Data
@RequiredArgsConstructor
public class Verification {

    @Id
    private long id;
    private String token;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToOne
    private User user;

    public Verification(User user) {
        this.user = user;
        token = UUID.randomUUID().toString();
    }
}
