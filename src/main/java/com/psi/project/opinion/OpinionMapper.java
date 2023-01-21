package com.psi.project.opinion;

import com.psi.project.opinion.dtos.OpinionRequestDTO;
import com.psi.project.opinion.dtos.OpinionResponseDTO;
import com.psi.project.opinion.valueobjects.DescriptionValidator;
import com.psi.project.opinion.valueobjects.RateValidator;
import com.psi.project.trade.TradeRepository;
import com.psi.project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OpinionMapper {

    private final TradeRepository tradeRepository;

    private final UserRepository userRepository;

    @Autowired
    public OpinionMapper(TradeRepository tradeRepository, UserRepository userRepository) {
        this.tradeRepository = tradeRepository;
        this.userRepository = userRepository;
    }

    public OpinionResponseDTO fromOpinionEntityToOpinionResponseDTO(OpinionEntity opinionEntity) {
        return OpinionResponseDTO.builder()
                .rate(opinionEntity.getRate().toInteger())
                .description(opinionEntity.getDescription().toString())
                .build();
    }

    public List<OpinionResponseDTO> fromOpinionEntityListToOpinionResponseList(List<OpinionEntity> opinionEntityList) {
        return opinionEntityList.stream()
                .map(this::fromOpinionEntityToOpinionResponseDTO)
                .collect(Collectors.toList());
    }

    public OpinionRequestDTO fromOpinionEntityToOpinionRequestDTO(OpinionEntity opinionEntity){
        return OpinionRequestDTO.builder()
                .rate(opinionEntity.getRate().toInteger())
                .description(opinionEntity.getDescription().toString())
                .userId(opinionEntity.getUserId().getId())
                .tradeId(opinionEntity.getTradeEntity().getId())
                .build();
    }

    public List<OpinionRequestDTO> fromOpinionEntityListToOpinionRequestList(List<OpinionEntity> opinionEntityList) {
        return opinionEntityList.stream()
                .map(this::fromOpinionEntityToOpinionRequestDTO)
                .collect(Collectors.toList());
    }

    public OpinionEntity fromOpinionRequestDTOToOpinionEntity(OpinionRequestDTO opinionRequestDTO) {
        return OpinionEntity.builder()
                .rate(new RateValidator(opinionRequestDTO.rate()))
                .description(new DescriptionValidator(opinionRequestDTO.description()))
                .tradeEntity(tradeRepository.findTradeEntityById(opinionRequestDTO.tradeId()))
                .userId(userRepository.findUser(opinionRequestDTO.userId()))
                .buyerId(tradeRepository.findTradeEntityById(opinionRequestDTO.tradeId()).getUserId().getId())
                .build();
    }
}
