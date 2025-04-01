package com.harry.flipkart_daily.service;

import com.harry.flipkart_daily.dto.InventoryRequestDTO;
import com.harry.flipkart_daily.model.Inventory;
import com.harry.flipkart_daily.model.Item;
import com.harry.flipkart_daily.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    //  Add inventory to an existing item (fixing price issue)
    public void addInventory(InventoryRequestDTO inventoryRequest) {
        Item item = new Item(inventoryRequest.getCategory(), inventoryRequest.getBrand(), inventoryRequest.getPrice());

        List<Inventory> allInventories = inventoryRepository.findAll();
        for (Inventory inventory : allInventories) {
            if (inventory.getItem().equals(item)) {
                // Update quantity if item exists
                inventory.setQuantity(inventory.getQuantity() + inventoryRequest.getQuantity());
                return; // Exit early since we updated an existing item
            }
        }

        // Add a new entry only if it doesn't already exist
        inventoryRepository.save(new Inventory(item, inventoryRequest.getQuantity()));
    }

    // Display all inventory items
    public void displayInventory() {
        //inventoryRepository.findAll().forEach(System.out::println);
        List<Inventory> inventoryList = inventoryRepository.findAll();
        inventoryList.forEach(inventory -> {
            Item item = inventory.getItem();  // Accessing Item from Inventory
            System.out.println( item.getBrand() + " -> " + item.getCategory() +
                     " -> " + inventory.getQuantity());
        });
    }
}
