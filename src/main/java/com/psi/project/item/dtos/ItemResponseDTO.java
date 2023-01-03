package com.psi.project.item.dtos;

import lombok.Builder;

public record ItemResponseDTO(String itemName,
                              String description,
                              Double price,
                              String category,
                              String status) {

    @Builder
    public ItemResponseDTO {}
}
