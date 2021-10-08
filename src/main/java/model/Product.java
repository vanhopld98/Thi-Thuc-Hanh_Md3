package model;

public class Product {
    private int id;
    private String name;
    private int prince;
    private int quantity;
    private String color;
    private String description;
    private int categoryId;
    private String categoryName;

    public Product(int id, String name, int prince, int quantity, String color, String description, int categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.prince = prince;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Product(int id, String name, int prince, int quantity, String color, String description, int categoryId) {
        this.id = id;
        this.name = name;
        this.prince = prince;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Product(String name, int prince, int quantity, String color, String description, int categoryId) {
        this.name = name;
        this.prince = prince;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public Product(int id, String name, int prince, int quantity, String color, String description, String categoryName) {
        this.id = id;
        this.name = name;
        this.prince = prince;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrince() {
        return prince;
    }

    public void setPrince(int prince) {
        this.prince = prince;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
