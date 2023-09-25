package com.project.dinedynamo.APIController;

import com.project.dinedynamo.Entities.Items;
import com.project.dinedynamo.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemsControllerAPI {

    @Autowired
    ItemsService itemsservice;

    @PostMapping("/addItems")
    public Items addItems(@RequestBody Items items) {
        return itemsservice.addItems(items);
    }

    @GetMapping("/getByCategory")
    public List<Items> getItemsByCategory(@RequestParam String category) {
        return itemsservice.getItemsByCategory(category);
    }

    @GetMapping("/getAll")
    public List<Items> getAll() {
        return itemsservice.getAllItems();
    }

    @GetMapping("/getByPrice")
    public List<Items> getItemsByPrice(@RequestParam int price) {
        return itemsservice.getItemsByPrice(price);
    }

}
