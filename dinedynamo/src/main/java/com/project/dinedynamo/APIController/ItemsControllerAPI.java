package com.project.dinedynamo.APIController;

import com.project.dinedynamo.Entities.Items;
import com.project.dinedynamo.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsControllerAPI {

    @Autowired
    ItemsService itemsservice;

    @PostMapping("/addItems")
    public Items addItems(@RequestBody Items items) {
        return itemsservice.addItems(items);
    }

    @GetMapping("/ItemsByCategory")
    public String getItemsByCategory(Model model, @RequestParam("") String category) {

        List<Items> items = itemsservice.getItemsByCategory("Lunch");

        model.addAttribute("catitems", items);

        return "catitems";
    }


    @GetMapping("/menu")
    public String getAll(Model model){
        List<Items> items = itemsservice.getAllItems();
        model.addAttribute("items", items);
        return "menu";
    }

    @GetMapping("/getByPrice")
    public List<Items> getItemsByPrice(@RequestParam int price) {
        return itemsservice.getItemsByPrice(price);
    }





}



