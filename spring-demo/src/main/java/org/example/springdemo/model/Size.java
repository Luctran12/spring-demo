package org.example.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int width;

    @ManyToOne
    @JoinColumn(name="product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;

    // Constructors, Getters, and Setters
    public Size() {}

    public Size(int width, Product product) {
        this.width = width;
        this.product = product;
    }


}
