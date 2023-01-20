package com.psi.project.item;

import com.psi.project.item.dtos.ItemRequestDTO;
import com.psi.project.item.dtos.ItemResponseDTO;
import com.psi.project.item.dtos.ItemUpdateDTO;
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
    @ResponseStatus(HttpStatus.FOUND)
    public List<ItemResponseDTO> getItems(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                          @RequestParam(value = "name", required = false) String name) {
        return itemService.getItems(page, name);
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

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateItemById(@PathVariable Long id, @RequestBody ItemUpdateDTO itemUpdateDTO)
    {
        return itemService.updateItemById(id, itemUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteItemById(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
