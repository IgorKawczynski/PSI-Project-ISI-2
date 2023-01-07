package com.psi.project.trade;

import com.psi.project.item.ItemRepository;
import com.psi.project.trade.dtos.TradeRequestDTO;
import com.psi.project.trade.dtos.TradeResponseDTO;
import com.psi.project.trade.valueobjects.ValueValidator;
import com.psi.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TradeMapper {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;

    @Autowired
    public TradeMapper(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public TradeResponseDTO fromTradeEntityToTradeResponseDTO(TradeEntity tradeEntity) {
        return TradeResponseDTO.builder()
                .value(tradeEntity.getValue().toDouble())
                .itemEntity(tradeEntity.getItemEntity())
                .build();
    }

    public List<TradeResponseDTO> fromTradeEntityListToTradeResponseList(List<TradeEntity> tradeEntityList) {
        return tradeEntityList.stream()
                .map(this::fromTradeEntityToTradeResponseDTO)
                .collect(Collectors.toList());
    }

    public TradeRequestDTO fromTradeEntityToTradeRequestDTO(TradeEntity tradeEntity) {
        return TradeRequestDTO.builder()
                .value(tradeEntity.getValue().toDouble())
                .itemEntity(tradeEntity.getItemEntity())
                .userEntity(tradeEntity.getUserId())
                .build();
    }

    public List<TradeRequestDTO> fromTradeEntityListToTradeRequestList(List<TradeEntity> tradeEntityList) {
        return tradeEntityList.stream()
                .map(this::fromTradeEntityToTradeRequestDTO)
                .collect(Collectors.toList());
    }

    public TradeEntity fromTradeRequestDTOToTradeEntity(TradeRequestDTO tradeRequestDTO) {
        return TradeEntity.builder()
                .value(new ValueValidator(tradeRequestDTO.value()))
                .itemEntity(itemRepository.findItemEntityById(tradeRequestDTO.itemEntity().getId()))
//                .userId(userRepository.findUserEntityById(tradeRequestDTO.userEntity().getId()))
// TODO: Poprawić to: WYMAGANY TYP UserEntity a jest optional <?>
                .build();
    }
}
