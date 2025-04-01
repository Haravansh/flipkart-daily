package com.harry.flipkart_daily.controller;

import com.harry.flipkart_daily.dto.ItemRequestDTO;
import com.harry.flipkart_daily.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public void addItem(@RequestBody ItemRequestDTO itemRequestDTO) {
        itemService.addItem(itemRequestDTO);
    }
}
