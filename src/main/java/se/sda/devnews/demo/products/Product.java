package se.sda.devnews.demo.products;


import se.sda.devnews.demo.categories.Category;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String date;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, String date, Category category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
