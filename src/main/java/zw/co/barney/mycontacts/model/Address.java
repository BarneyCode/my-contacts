package zw.co.barney.mycontacts.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Project  : my-contacts
 * Developer: katakwab
 * Date     : 2/20/2019 12:09 PM
 */
@Entity
@Data
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long streetNumber;
    private String streetName;
    private String suburb;
    private String city;
    private String country;


    @OneToOne
    private Contact contact;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
