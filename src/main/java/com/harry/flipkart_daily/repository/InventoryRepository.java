package com.harry.flipkart_daily.repository;

import com.harry.flipkart_daily.model.Inventory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InventoryRepository {
    private static final List<Inventory> inventoryList = new ArrayList<>();

    public void save(Inventory inventory) {
        inventoryList.add(inventory);
    }

    public List<Inventory> findAll() {
        return inventoryList;
    }
}
