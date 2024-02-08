package com.elearning.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(
        name = "lecture"
)
public class Lecture {
    @Id
    @GeneratedValue(
            generator = "lecture_sequence"
    )
    @GenericGenerator(
          name = "lecture_sequence",
          strategy = "com.elearning.generator.LectureIdGenerator"
    )
    @Column(
            name = "lecture_id"
    )
    private String id;

    @Column(
            name = "lecture_name",
            nullable = false,
            unique = true
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "section_id"
    )
    private Section section;


}
