package com.elearning.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(
        name = "resource"
)
public class Resource {

    @Id
    @GeneratedValue(
            generator = "resourceId_generator"
    )
    @GenericGenerator(
            name = "resourceId_generator",
            strategy = "com.elearning.generator.ResourceIdGenerator"
    )
    @Column(name = "resource_id")
    private String id;

    @Column(
            name = "resource_name",
            nullable = false
    )
    private String name;

    @Column(
            name = "file_size"
    )
    private int size;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
