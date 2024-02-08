package com.elearning.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(
        name = "section"
)
public class Section extends BaseEntity{

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

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "course_id"
    )
    private Course course;

    @OneToMany(
            mappedBy = "section",
            fetch = FetchType.EAGER
    )
    private List<Lecture> lectures;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
