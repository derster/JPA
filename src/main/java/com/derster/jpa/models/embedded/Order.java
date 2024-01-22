package com.derster.jpa.models.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "_order"
)
public class Order{
    @EmbeddedId
    private OrderId id;
    private String orderInfo;
    private String anotherField;
    @Embedded
    private Address address;
}
