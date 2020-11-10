package se.sda.devnews.demo.products;

public class Product {

    private Long id;
    private String name;
    private String date;

    public Product(Long id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;

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
}
