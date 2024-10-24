package model.entities;

import model.exceptions.ProductException;

public class Product {

    private String name;
    private Double price;
    private Integer quantity;

    public Product() {
    }

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Name: ");
        sb.append(getName());
        sb.append(", Price: ");
        sb.append(getPrice().toString());
        sb.append(", Quantity: ");
        sb.append(getQuantity());

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) throws ProductException {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new ProductException("Price must be a non negativa number");
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void addQuantity(Integer quantity) throws ProductException {
        if (quantity >= 0) {
            this.quantity += quantity;
        } else {
            throw new ProductException("Quantity must be a non negative number");
        }
    }

    public void removeQuantity(Integer quantity) throws ProductException {
        if (quantity >= 0) {
            this.quantity -= quantity;
        } else {
            throw new ProductException("Quantity must be a non negative number");
        }
    }

    public Double calcTotalValue() {
        return getPrice() * getQuantity();
    }

}
