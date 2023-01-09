package com.psi.project.opinion.dtos;

import lombok.Builder;

public record OpinionRequestDTO(Integer rate,
                                String description,
                                Long tradeId,
                                Long userId) {

    @Builder
    public OpinionRequestDTO {}
}
