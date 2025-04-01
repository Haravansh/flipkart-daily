package com.harry.flipkart_daily.driver;

import com.harry.flipkart_daily.dto.InventoryRequestDTO;
import com.harry.flipkart_daily.dto.ItemRequestDTO;
import com.harry.flipkart_daily.dto.SearchItemsDTO;
import com.harry.flipkart_daily.service.InventoryService;
import com.harry.flipkart_daily.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlipkartDailyDriver implements CommandLineRunner {
    @Autowired
    private ItemService itemService;

    @Autowired
    private InventoryService inventoryService;

    @Override
    public void run(String... args) {
        System.out.println("---- Running Flipkart Daily Driver ----");

        // 1. Add Items
        itemService.addItem(new ItemRequestDTO("Milk", "Amul", 100));
        itemService.addItem(new ItemRequestDTO("Curd", "Amul", 50));
        itemService.addItem(new ItemRequestDTO("Milk", "Nestle", 60));
        itemService.addItem(new ItemRequestDTO("Curd", "Nestle", 90));

        // 2. Add Inventory
        inventoryService.addInventory(new InventoryRequestDTO("Milk", "Amul", 100.0, 10));
        inventoryService.addInventory(new InventoryRequestDTO("Milk", "Nestle", 60.0, 5));
        inventoryService.addInventory(new InventoryRequestDTO("Curd", "Nestle", 90.0, 10));
        inventoryService.addInventory(new InventoryRequestDTO("Milk", "Amul", 100.0, 10));
        inventoryService.addInventory(new InventoryRequestDTO("Curd", "Amul", 50.0, 5));


        // 3. Display Inventory
        System.out.println("\nCurrent Inventory:");
        inventoryService.displayInventory();

        // 4. Search by Brand (Nestle)
        System.out.println("\nSearch by Brand (Nestle):");
        List<?> searchResult1 = itemService.searchItems(new SearchItemsDTO(null, List.of("Nestle"), null, null, null));
        searchResult1.forEach(System.out::println);

        // 5. Search by Category (Milk)
        System.out.println("\nSearch by Category (Milk):");
        List<?> searchResult2 = itemService.searchItems(new SearchItemsDTO(List.of("Milk"), null, null, null, null));
        searchResult2.forEach(System.out::println);

        // 6. Search by Category with Sorting (Price Descending)
        System.out.println("\nSearch by Category (Milk) Ordered by Price Descending:");
        List<?> searchResult3 = itemService.searchItems(new SearchItemsDTO(List.of("Milk"), null, null, null, "price_desc"));
        searchResult3.forEach(System.out::println);

        // 7. Search by Price Range (70 to 100)
        System.out.println("\nSearch by Price Range (70 to 100):");
        List<?> searchResult4 = itemService.searchItems(new SearchItemsDTO(null, null, 70.0, 100.0, null));
        searchResult4.forEach(System.out::println);

        // 8. Search by Multiple Filters (Category: Milk, Price: 70 to 100, Price Descending)
        System.out.println("\nSearch by Category (Milk) & Price Range (70 to 100) Ordered by Price Descending:");
        List<?> searchResult5 = itemService.searchItems(new SearchItemsDTO(List.of("Milk"), null, 70.0, 100.0, "price_desc"));
        searchResult5.forEach(System.out::println);
    }
}
