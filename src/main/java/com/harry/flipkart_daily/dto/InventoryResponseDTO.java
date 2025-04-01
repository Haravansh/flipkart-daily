package com.harry.flipkart_daily.dto;

public class InventoryResponseDTO {
    private String brand;
    private String category;
    private int quantity;

    public InventoryResponseDTO(String brand, String category, int quantity) {
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return brand + ", " + category + ", " + quantity;
    }

}

