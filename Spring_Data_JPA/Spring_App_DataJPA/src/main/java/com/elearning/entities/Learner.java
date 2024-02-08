package com.elearning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "learner"
)
public class Learner {

    @Id
    @GeneratedValue(
            generator = "learner_id_sequence"
    )
    @GenericGenerator(
            name = "learner_id_sequence",
            strategy = "com.elearning.generator.LearnerIdGenerator"
    )
    private String Id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "age"
    )
    @Check(
            name = "check_learner_age",
            constraints = "age>=13 and age<=80"
    )
    private int age;

    @Column(
            name = "date_of_birth",
            nullable = false
    )
    private Date DOB;

    @Column(
            name = "address"
    )
    private Address address;

}
