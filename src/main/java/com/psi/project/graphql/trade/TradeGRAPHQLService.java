package com.psi.project.graphql.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeGRAPHQLService {

    @Autowired
    private TradeGRAPHQLRepository tradeGRAPHQLRepository;

    public List<TradeGRAPHQL> getAllTrades() {
        return tradeGRAPHQLRepository.findAll();
    }

    public TradeGRAPHQL getTradeById(Integer id) {
        return tradeGRAPHQLRepository.findTradeGRAPHQLById(id);
    }

    public TradeGRAPHQL addTrade(TradeGRAPHQL trade) {
        return tradeGRAPHQLRepository.save(trade);
    }

    public TradeGRAPHQL updateTradeById(Integer id, Integer value, Integer buyerId, Integer sellerId) {
        var trade = tradeGRAPHQLRepository.findTradeGRAPHQLById(id);
        trade.setValue(value);
        trade.setBuyerId(buyerId);
        trade.setSellerId(sellerId);
        return trade;
    }

    public Integer deleteTradeById(Integer id) {
        tradeGRAPHQLRepository.deleteById(id);
        return id;
    }
}
