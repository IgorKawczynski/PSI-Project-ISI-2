package com.psi.project.item;


import com.psi.project.item.dtos.ItemRequestDTO;
import com.psi.project.item.dtos.ItemResponseDTO;
import com.psi.project.item.valueobjects.DescriptionValidator;
import com.psi.project.item.valueobjects.PriceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 *  Web Serwis przedmiotów sprzedaży
 *  @author Igor Kawczyński
 *
 */
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemResponseDTO> getItems() {
        var items = itemRepository.findAll(Sort.by(Sort.Direction.ASC, "itemName"));
        return itemMapper.fromItemEntityListToItemResponseList(items);
    }

    public ItemResponseDTO getItemById(Long id){
        var item =
                itemRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Item with id: " + id + " does not exist!"));
        return itemMapper.fromItemEntityToItemResponseDTO(item);
    }

    public void addItem(ItemRequestDTO itemRequestDTO) {
        var item = itemMapper.fromItemRequestDTOToItemEntity(itemRequestDTO);
        itemRepository.save(item);
    }

    public String updateItemById(Long id, String description, Double price) {
        var item =
                itemRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Item with id: " + id + " does not exist!"));
        item.setDescription(new DescriptionValidator(description));
        item.setPrice(new PriceValidator(price));
        itemRepository.save(item);
        return "Item with id: " + id + " updated successfully!";
    }

    public String deleteItem(Long id) {
        var item =
                itemRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Item with id: " + id + " does not exist!"));
        itemRepository.delete(item);
        return "Item with id: " + id + " deleted successfully!";
    }

}
