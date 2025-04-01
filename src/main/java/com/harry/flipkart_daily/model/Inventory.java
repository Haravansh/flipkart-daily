package com.harry.flipkart_daily.model;

import lombok.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory {

    private Item item;
    private int quantity;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
