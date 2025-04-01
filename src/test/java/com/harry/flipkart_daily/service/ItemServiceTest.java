package com.harry.flipkart_daily.service;

import static org.junit.jupiter.api.Assertions.*;

import com.harry.flipkart_daily.dto.InventoryResponseDTO;
import com.harry.flipkart_daily.dto.ItemRequestDTO;
import com.harry.flipkart_daily.dto.SearchItemsDTO;
import com.harry.flipkart_daily.model.Inventory;
import com.harry.flipkart_daily.model.Item;
import com.harry.flipkart_daily.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testAddItem() {
        ItemRequestDTO itemDTO = new ItemRequestDTO("Milk", "Amul", 50);
        itemService.addItem(itemDTO);
        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }

    @Test
    void testSearchItems() {
        List<Inventory> inventoryList = Arrays.asList(
                new Inventory(new Item("Milk", "Amul", 50), 10),
                new Inventory(new Item("Milk", "Nestle", 60), 5),
                new Inventory(new Item("Curd", "Amul", 70), 8)
        );

        when(inventoryRepository.findAll()).thenReturn(inventoryList);

        SearchItemsDTO searchDTO = new SearchItemsDTO();
        searchDTO.setCategories(List.of("Milk"));
        searchDTO.setPriceFrom(50.0);
        searchDTO.setPriceTo(60.0);

        List<InventoryResponseDTO> result = itemService.searchItems(searchDTO);

        assertEquals(2, result.size());
        assertEquals("Nestle", result.get(0).getBrand());
        assertEquals("Amul", result.get(1).getBrand());
    }

    @Test
    void testSearchItems_SortedByPriceDesc() {
        List<Inventory> inventoryList = Arrays.asList(
                new Inventory(new Item("Milk", "Amul", 50), 10),
                new Inventory(new Item("Milk", "Nestle", 70), 5)
        );

        when(inventoryRepository.findAll()).thenReturn(inventoryList);

        SearchItemsDTO searchDTO = new SearchItemsDTO();
        searchDTO.setCategories(List.of("Milk"));
        searchDTO.setOrderBy("price_desc");

        List<InventoryResponseDTO> result = itemService.searchItems(searchDTO);

        assertEquals(2, result.size());
        assertEquals("Nestle", result.get(0).getBrand());
        assertEquals("Amul", result.get(1).getBrand());
    }

}