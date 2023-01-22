package com.psi.project.trade.dtos;

import com.psi.project.item.ItemEntity;
import lombok.Builder;

public record TradeResponseDTO(Double value, Long item) {

    @Builder
    public TradeResponseDTO {}
}
