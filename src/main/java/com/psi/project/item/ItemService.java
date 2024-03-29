package com.psi.project.item;


import com.psi.project.item.dtos.ItemRequestDTO;
import com.psi.project.item.dtos.ItemResponseDTO;
import com.psi.project.item.dtos.ItemUpdateDTO;
import com.psi.project.item.valueobjects.DescriptionValidator;
import com.psi.project.item.valueobjects.PriceValidator;
import com.psi.project.item.valueobjects.StatusValidator;
import com.psi.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 *
 *  Web Serwis przedmiotów sprzedaży
 *  @author Igor Kawczyński
 *
 */
@Service
public class ItemService {

    private final static Integer PAGESIZE = 5;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserRepository userRepository;
    @Autowired
    public ItemService(
            ItemRepository itemRepository,
            ItemMapper itemMapper,
            UserRepository userRepository
    ) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userRepository = userRepository;
    }

    public List<ItemResponseDTO> getItems(Integer page, String name, boolean availability) {
        if ( name == null) name = "";
        name = name.concat("%");
        Pageable sortedByItemName = PageRequest.of(page, PAGESIZE, Sort.Direction.ASC, "item_name");

        Page<ItemEntity> items;
        if(availability) items = itemRepository.findAllByItemNameBeginningWithAndAvailable(name,sortedByItemName);
        else items = itemRepository.findAllByItemNameBeginningWithAndUnavailable(name, sortedByItemName);

        return items.stream().map(itemMapper::fromItemEntityToItemResponseDTO).collect(Collectors.toList());
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
        Long sellerId = itemRequestDTO.sellerId();
        item.setUserId(userRepository.findUser(sellerId));
        itemRepository.save(item);
    }

    public String updateItemById(Long id, ItemUpdateDTO itemUpdateDTO) {
        var item =
                itemRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Item with id: " + id + " does not exist!"));
        if (item.getStatus() != StatusValidator.AVAILABLE)
            throw  new IllegalArgumentException("Item must be available");
        item.setDescription(new DescriptionValidator(itemUpdateDTO.description()));
        item.setPrice(new PriceValidator(itemUpdateDTO.price()));
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
