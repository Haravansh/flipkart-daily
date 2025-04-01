package com.harry.flipkart_daily.service;

import com.harry.flipkart_daily.dto.InventoryRequestDTO;
import com.harry.flipkart_daily.model.Inventory;
import com.harry.flipkart_daily.model.Item;
import com.harry.flipkart_daily.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {
    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    private Item item;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        item = new Item("Milk", "Amul", 100.0);
        inventory = new Inventory(item, 10);
    }

    @Test
    void testAddInventory_NewItem() {
        InventoryRequestDTO request = new InventoryRequestDTO("Milk", "Amul", 100.0, 10);
        when(inventoryRepository.findAll()).thenReturn(List.of());

        inventoryService.addInventory(request);

        verify(inventoryRepository, times(1)).save(any(Inventory.class));
    }

    @Test
    void testAddInventory_ExistingItem() {
        InventoryRequestDTO request = new InventoryRequestDTO("Milk", "Amul", 100.0, 10);
        when(inventoryRepository.findAll()).thenReturn(List.of(inventory));

        inventoryService.addInventory(request);

        assertEquals(20, inventory.getQuantity()); // Quantity should update
        verify(inventoryRepository, never()).save(any(Inventory.class));
    }

    @Test
    void testDisplayInventory() {
        when(inventoryRepository.findAll()).thenReturn(List.of(inventory));

        inventoryService.displayInventory();

        verify(inventoryRepository, times(1)).findAll();
    }

}