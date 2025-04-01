package com.harry.flipkart_daily.service;

import com.harry.flipkart_daily.dto.InventoryResponseDTO;
import com.harry.flipkart_daily.dto.ItemRequestDTO;
import com.harry.flipkart_daily.dto.SearchItemsDTO;
import com.harry.flipkart_daily.model.Inventory;
import com.harry.flipkart_daily.model.Item;
import com.harry.flipkart_daily.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public void addItem(ItemRequestDTO itemDTO) {
        inventoryRepository.save(new Inventory(new Item(itemDTO.getCategory(), itemDTO.getBrand(), itemDTO.getPrice()), 0));
    }

    public List<InventoryResponseDTO> searchItems(SearchItemsDTO searchDTO) {
        return inventoryRepository.findAll().stream()
                .filter(inv -> inv.getQuantity() > 0)  // Only include items with quantity > 0
                .filter(inv -> (searchDTO.getCategories() == null || searchDTO.getCategories().isEmpty() || searchDTO.getCategories().contains(inv.getItem().getCategory())))
                .filter(inv -> (searchDTO.getBrands() == null || searchDTO.getBrands().isEmpty() || searchDTO.getBrands().contains(inv.getItem().getBrand())))
                .filter(inv -> (searchDTO.getPriceFrom() == null || inv.getItem().getPrice() >= searchDTO.getPriceFrom())) // Filter by price range
                .filter(inv -> (searchDTO.getPriceTo() == null || inv.getItem().getPrice() <= searchDTO.getPriceTo()))   // Filter by price range
                .sorted(getComparator(searchDTO.getOrderBy())) // Sorting by price or any other field
                .map(inv -> new InventoryResponseDTO(
                        inv.getItem().getBrand(),  // Correctly assign category
                        inv.getItem().getCategory(),     // Correctly assign brand
                        inv.getQuantity()             // Only include quantity
                ))
                .collect(Collectors.toList());
    }

    private Comparator<Inventory> getComparator(String orderBy) {
        if ("price_desc".equals(orderBy)) {
            return Comparator.comparingDouble((Inventory inv) -> inv.getItem().getPrice()).reversed();
        }
        if ("price_asc".equals(orderBy)) {
            return Comparator.comparingDouble((Inventory inv) -> inv.getItem().getPrice());
        }
        return Comparator.comparingInt(Inventory::getQuantity); // Default sorting by quantity
    }
}
