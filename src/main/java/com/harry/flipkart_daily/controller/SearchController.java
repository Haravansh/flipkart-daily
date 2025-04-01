package com.harry.flipkart_daily.controller;

import com.harry.flipkart_daily.dto.InventoryResponseDTO;
import com.harry.flipkart_daily.dto.SearchItemsDTO;
import com.harry.flipkart_daily.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class SearchController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/search")
    public List<InventoryResponseDTO> searchItems(@RequestBody SearchItemsDTO searchItemsDTO) {
        return itemService.searchItems(searchItemsDTO);
    }

}
