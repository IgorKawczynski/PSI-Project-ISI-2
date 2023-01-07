package com.psi.project.trade.dtos;

import com.psi.project.item.ItemEntity;
import com.psi.project.user.UserEntity;
import lombok.Builder;

public record TradeRequestDTO(Double value, UserEntity userEntity, ItemEntity itemEntity) {

    @Builder
    public TradeRequestDTO{}
}
