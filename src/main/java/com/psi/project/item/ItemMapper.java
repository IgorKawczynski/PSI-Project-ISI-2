package com.psi.project.item;

import com.psi.project.item.dtos.ItemRequestDTO;
import com.psi.project.item.dtos.ItemResponseDTO;
import com.psi.project.item.valueobjects.*;
import com.psi.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *  Konwerter pomiędzy encją a obiektami typu data-transfer przedmiotów sprzedaży
 *  @author Igor Kawczyński
 *
 */
@Component
public class ItemMapper {

    private final UserRepository userRepository;

    @Autowired
    public ItemMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ItemResponseDTO fromItemEntityToItemResponseDTO(ItemEntity itemEntity){
        return ItemResponseDTO.builder()
                .itemName(itemEntity.getItemName().toString())
                .description(itemEntity.getDescription().toString())
                .price(itemEntity.getPrice().toDouble())
                .category(itemEntity.getCategory().toString())
                .status(itemEntity.getStatus().toString())
                .build();
    }

    public List<ItemResponseDTO> fromItemEntityListToItemResponseList(List<ItemEntity> itemEntityList){
        return itemEntityList.stream()
                .map(this::fromItemEntityToItemResponseDTO)
                .collect(Collectors.toList());
    }

    public ItemRequestDTO fromItemEntityToItemRequestDTO(ItemEntity itemEntity){
        return ItemRequestDTO.builder()
                .itemName(itemEntity.getItemName().toString())
                .description(itemEntity.getDescription().toString())
                .price(itemEntity.getPrice().toDouble())
                .category(itemEntity.getCategory().toString())
                .status(itemEntity.getStatus().toString())
                .sellerId(itemEntity.getUserId().getId())
                .build();
    }

    public List<ItemRequestDTO> fromItemEntityListToItemRequestList(List<ItemEntity> itemEntityList){
        return itemEntityList.stream()
                .map(this::fromItemEntityToItemRequestDTO)
                .collect(Collectors.toList());
    }

    public ItemEntity fromItemRequestDTOToItemEntity(ItemRequestDTO itemRequestDTO){
        return ItemEntity.builder()
                .itemName(new ItemNameValidator(itemRequestDTO.itemName()))
                .description(new DescriptionValidator(itemRequestDTO.description()))
                .price(new PriceValidator(itemRequestDTO.price()))
                .category(CategoryValidator.valueOf(itemRequestDTO.category()))
                .status(StatusValidator.valueOf(itemRequestDTO.status()))
//                .userId(userRepository.findUserEntityById(itemRequestDTO.sellerId()))
//                WYMAGANY TYP UserEntity a jest optional <?>
                .build();
    }
}
