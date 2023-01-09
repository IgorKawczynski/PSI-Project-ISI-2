package com.psi.project.opinion.dtos;

import lombok.Builder;

public record OpinionResponseDTO(Integer rate, String description) {

    @Builder
    public OpinionResponseDTO {}
}
