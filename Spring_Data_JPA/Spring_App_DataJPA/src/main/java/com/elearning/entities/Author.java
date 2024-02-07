package com.elearning.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

//@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name="author_sequence",
            sequenceName = "authorid_sequence",
            allocationSize = 1,
            initialValue = 101
    )
    @Column(name = "author_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

}
