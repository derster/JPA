package com.derster.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Author extends BaseEntity{
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;
    @ManyToMany(
            mappedBy = "authors"
    )
    private List<Course> courses;

}
