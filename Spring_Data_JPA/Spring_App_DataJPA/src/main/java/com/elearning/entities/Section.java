package com.elearning.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "section"
)
public class Section {

    @Id
    @GeneratedValue(
            generator = "section_sequence"
    )
    @GenericGenerator(
            strategy = "com.elearning.generator.SectionIdGenerator",
            name = "section_sequence"
    )
    @Column(
            name = "section_id"
    )
    private String id;

    @Column(
            name = "Name",
            nullable = false,
            unique = true
    )
    private String name;

    @Column(
            name = "Serial_number"
    )
    private int sectionOrder;

    @ManyToOne
    @JoinColumn(
            name = "course_id"
    )
    private Course course;

    @OneToMany(
            mappedBy = "section"
    )
    private List<Lecture> lectures;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
