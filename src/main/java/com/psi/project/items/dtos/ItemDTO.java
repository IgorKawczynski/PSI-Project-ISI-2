package com.psi.project.items.dtos;

import lombok.Builder;

public record ItemDTO(String name, String description, Double price) {

    @Builder
    public ItemDTO {}
}
