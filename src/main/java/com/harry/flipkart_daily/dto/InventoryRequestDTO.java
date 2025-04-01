package com.harry.flipkart_daily.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequestDTO {
    private String category;
    private String brand;
    private double price; // Add price field
    private int quantity;

    // Constructor
    public InventoryRequestDTO(String category, String brand, double price, int quantity) {
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() { // Getter for price
        return price;
    }

    public void setPrice(double price) { // Setter for price
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    @Override
//    public String toString() {
//        return "InventoryRequestDTO{" +
//                "category='" + category + '\'' +
//                ", brand='" + brand + '\'' +
//                ", price=" + price +
//                ", quantity=" + quantity +
//                '}';
//    }
}
