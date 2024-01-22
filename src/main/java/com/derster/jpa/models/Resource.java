package com.derster.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "resource_type")
public class Resource{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int size;
    private String url;
    @OneToOne
    @JoinColumn(
            name = "lecture_id"
    )
    private Lecture lecture;

}
