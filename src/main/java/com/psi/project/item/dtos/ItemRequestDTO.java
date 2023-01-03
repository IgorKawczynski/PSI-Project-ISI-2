package com.psi.project.item.dtos;

import lombok.Builder;

public record ItemRequestDTO(String itemName,
                             String description,
                             Double price,
                             String category,
                             String status,
                             Long sellerId) {

    @Builder
    public ItemRequestDTO {}
}
