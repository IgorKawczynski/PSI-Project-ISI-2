package com.psi.project.trade.dtos;

import lombok.Builder;

public record TradeCreateDTO(Long userId, Long itemId) {

    @Builder
    public TradeCreateDTO {}
}
