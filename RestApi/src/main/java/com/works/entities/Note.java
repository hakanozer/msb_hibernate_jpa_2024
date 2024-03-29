package com.works.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;

    @Size(min = 3, max = 100)
    @NotEmpty
    @NotNull
    @Column(unique = true, length = 100)
    private String title;

    @Size(min = 2, max = 300)
    @NotNull
    @NotEmpty
    @Column(length = 300)
    private String detail;

    @Max(7)
    @Min(1)
    @NotNull
    private Integer noteday;

    @NotNull
    private Boolean status;

}
