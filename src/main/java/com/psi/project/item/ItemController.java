package com.psi.project.item;

import com.psi.project.item.dtos.ItemRequestDTO;
import com.psi.project.item.dtos.ItemResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Kontroler typu REST przedmiotów sprzedaży
 * @author Igor Kawczyński
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponseDTO> getItems() {
        return itemService.getItems();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public ItemResponseDTO getItemById(@RequestParam("id") Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemRequestDTO itemRequestDTO) {
        itemService.addItem(itemRequestDTO);
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
