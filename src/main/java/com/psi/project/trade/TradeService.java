package com.psi.project.trade;

import com.psi.project.trade.dtos.TradeRequestDTO;
import com.psi.project.trade.dtos.TradeResponseDTO;
import com.psi.project.trade.valueobjects.ValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    private final TradeMapper tradeMapper;

    @Autowired
    public TradeService(TradeRepository tradeRepository, TradeMapper tradeMapper) {
        this.tradeRepository = tradeRepository;
        this.tradeMapper = tradeMapper;
    }

    public List<TradeResponseDTO> getTrades() {
        var trades = tradeRepository.findAll(Sort.by(Sort.Direction.ASC, "value"));
        return tradeMapper.fromTradeEntityListToTradeResponseList(trades);
    }

    public TradeResponseDTO getTradeById(Long id) {
        var trade =
                tradeRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + "does not exist!"));
        return tradeMapper.fromTradeEntityToTradeResponseDTO(trade);
    }

    public void addTrade(TradeRequestDTO tradeRequestDTO) {
        var trade = tradeMapper.fromTradeRequestDTOToTradeEntity(tradeRequestDTO);
        tradeRepository.save(trade);
    }

    public String updateTradeById(Long id, Double value) {
        var trade = tradeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + " does not exist!"));
        trade.setValue(new ValueValidator(value));
        tradeRepository.save(trade);
        return "Trade with id: " + id + " updated successfully!";
    }

    public String deleteTrade(Long id) {
        var trade = tradeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Trade with id: " + id + " does not exist!"));
        tradeRepository.delete(trade);
        return "Trade with id: " + id + " deleted successfully!";
    }

}
