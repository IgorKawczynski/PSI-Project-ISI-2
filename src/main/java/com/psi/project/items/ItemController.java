package com.psi.project.items;

import com.psi.project.items.dtos.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Kontroler typu REST przedmiotów sprzedaży
 *
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDTO> getItems() {
        return itemService.getItems();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public ItemDTO getItemById(@RequestParam("id") Long id) {
        return itemService.getItemById(id);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String updateItemById(@PathVariable Long id,
                                 @RequestBody String description,
                                 @RequestBody Double price)
    {
        return itemService.updateItemById(id, description, price);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteItemById(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
