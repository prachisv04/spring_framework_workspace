package com.elearning.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

//@Component
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@SuperBuilder
@Table(name = "author")
public class Author extends BaseEntity{

    @Id
    @GeneratedValue(
            generator = "author_sequence"
    )
    @GenericGenerator(
            name="author_sequence",
            strategy = "com.elearning.generator.AuthorIdGenerator"
    )
    @Column(
            name = "author_id"
    )
    private String id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name"
    )
    private String lastName;

    @Column(
            name = "email",
            unique = true
    )
    private String email;

    @Column(
            name = "age"
    )
    @Check(
            name = "valid_age_check",
            constraints = "age >=18 and age <=80"
    )
    private int age;

    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.EAGER
    )
    private List<Course> courses;

}
