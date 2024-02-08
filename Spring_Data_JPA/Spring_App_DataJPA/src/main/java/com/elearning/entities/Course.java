package com.elearning.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(
        name = "course"
)
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(
            generator = "course_sequence"
    )
    @GenericGenerator(
            name = "course_sequence",
            strategy = "com.elearning.generator.CourseIdGenerator"
    )
    @Column(name = "course_id")
    private String id;

    @Column(
            name = "course_title",
            nullable = false,
            unique = true
    )
    private String title;

    @Column(
            name = "description"
    )
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_course" ,
            joinColumns ={
                    @JoinColumn(
                            name = "course_id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "author_id"
                    )
            }
    )
    private List<Author> authors;

    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.EAGER
    )
    private List<Section> sections;
}
