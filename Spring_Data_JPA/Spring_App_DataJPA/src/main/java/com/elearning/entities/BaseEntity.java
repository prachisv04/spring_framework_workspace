package com.elearning.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    @Column(
            name = "created_at",
            updatable = false
    )
    private LocalDateTime createdAt;

    @Column(
            name = "created_by",
            updatable = false
    )
    private String createdBy;

    @Column(
            name = "last_modified_at",
            insertable = false
    )
    private LocalDateTime lastModifiedAt;

    @Column(
            name = "last_modified_by",
            insertable = false
    )
    private String lastModifiedBy;
}
