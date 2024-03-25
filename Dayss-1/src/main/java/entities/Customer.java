package entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 150)
    private String name;

    @Column(unique = true, length = 150)
    private String email;

    @Column(length = 10)
    private String password;

    private Boolean status;

}
