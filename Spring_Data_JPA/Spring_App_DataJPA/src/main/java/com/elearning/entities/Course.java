package com.elearning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "course"
)
public class Course {

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

    @ManyToMany
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
            mappedBy = "course"
    )
    private List<Section> sections;
}
