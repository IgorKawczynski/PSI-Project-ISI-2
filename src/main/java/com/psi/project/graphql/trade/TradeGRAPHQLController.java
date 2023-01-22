package com.psi.project.graphql.trade;

import com.psi.project.graphql.item.ItemGRAPHQL;
import com.psi.project.graphql.user.UserGRAPHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TradeGRAPHQLController {

    @Autowired
    private TradeGRAPHQLService tradeGRAPHQLService;

    /**
     Metody Korzystające tylko z modelu (nie połączone z bazą danych)
     */
    @QueryMapping
    public List<TradeGRAPHQL> allTrades() {
        return TradeGRAPHQL.getAllTrades();
    }

    @QueryMapping
    public TradeGRAPHQL tradeById(@Argument Integer id) {
        return TradeGRAPHQL.getById(id);
    }

    @QueryMapping
    public TradeGRAPHQL tradeByValue(@Argument Integer value) {
        return TradeGRAPHQL.getByValue(value);
    }

    @QueryMapping
    public TradeGRAPHQL tradeByBuyer(@Argument Integer buyerId) {
        return TradeGRAPHQL.getByBuyer(buyerId);
    }

    @QueryMapping
    public TradeGRAPHQL tradeBySeller(@Argument Integer sellerId) {
        return TradeGRAPHQL.getBySeller(sellerId);
    }

    /**
     Metody Korzystające z serwisu - połączone z bazą danych
     */
    @QueryMapping
    public List<TradeGRAPHQL> getAllTrades() {
        return tradeGRAPHQLService.getAllTrades();
    }

    @QueryMapping
    public TradeGRAPHQL getTradeById(@Argument Integer id) {
        return tradeGRAPHQLService.getTradeById(id);
    }

    @MutationMapping
    public TradeGRAPHQL addTrade(@Argument TradeGRAPHQL trade) {
        return tradeGRAPHQLService.addTrade(trade);
    }

    @MutationMapping
    public TradeGRAPHQL updateTradeById(@Argument Integer id, @Argument Integer value, @Argument Integer buyerId, @Argument Integer sellerId) {
        return tradeGRAPHQLService.updateTradeById(id, value, buyerId, sellerId);
    }

    @MutationMapping
    public Integer deleteTradeById(@Argument Integer id) {
        return tradeGRAPHQLService.deleteTradeById(id);
    }

    @SchemaMapping
    public UserGRAPHQL buyer(TradeGRAPHQL trade) {
        return UserGRAPHQL.getById(trade.getBuyerId());
    }

    @SchemaMapping
    public UserGRAPHQL seller(TradeGRAPHQL trade) {
        return UserGRAPHQL.getById(trade.getSellerId());
    }

}
