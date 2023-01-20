package com.psi.project.item.dtos;

import lombok.Builder;

public record ItemUpdateDTO(String description,
                            Double price) {

    @Builder
    public ItemUpdateDTO {}
}
