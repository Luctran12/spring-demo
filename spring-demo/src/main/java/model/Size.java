package model;

import jakarta.persistence.*;

@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int width;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    // Constructors, Getters, and Setters
    public Size() {}

    public Size(int width, Product product) {
        this.width = width;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
