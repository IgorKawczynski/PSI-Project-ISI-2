package com.psi.project.items;

import com.psi.project.items.dtos.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Konwerter pomiędzy encją a obiektami typu data-transfer przedmiotów sprzedaży
 *
 */
@Component
public class ItemMapper {

    public ItemDTO fromItemEntityToItemDTO(ItemEntity itemEntity){
        return ItemDTO.builder()
                .name(itemEntity.getName().toString())
                .description(itemEntity.getDescription().toString())
                .price(itemEntity.getPrice().toDouble())
                .build();
    }

    public List<ItemDTO> fromItemEntityListToItemDTOList(List<ItemEntity> itemEntityList){
        return itemEntityList.stream()
                .map(this::fromItemEntityToItemDTO)
                .collect(Collectors.toList());
    }
}
