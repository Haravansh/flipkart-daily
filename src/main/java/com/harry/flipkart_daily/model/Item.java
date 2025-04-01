package com.harry.flipkart_daily.model;

import lombok.*;

import java.util.Objects;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Item {
    private String category;
    private String brand;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item(String category, String brand, double price) {
        this.category = category;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return Double.compare(item.price, price) == 0 &&
                Objects.equals(category, item.category) &&
                Objects.equals(brand, item.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, brand, price);
    }

}
