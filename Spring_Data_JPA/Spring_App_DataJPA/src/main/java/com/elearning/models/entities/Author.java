package com.elearning.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name="base_sequence",
            sequenceName = "base_sequence",
            allocationSize = 1,
            initialValue = 101
    )
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

}
