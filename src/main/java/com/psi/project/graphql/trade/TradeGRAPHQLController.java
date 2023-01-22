package com.psi.project.graphql.trade;

import com.psi.project.graphql.item.ItemGRAPHQL;
import com.psi.project.graphql.user.UserGRAPHQL;
import io.swagger.models.auth.In;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TradeGRAPHQLController {

    @QueryMapping
    public TradeGRAPHQL tradeById(@Argument Integer id) {
        return TradeGRAPHQL.getById(id);
    }

    @QueryMapping
    public List<TradeGRAPHQL> allTrades() {
        return TradeGRAPHQL.getAllTrades();
    }

    @MutationMapping
    public TradeGRAPHQL updateTradeById(@Argument Integer id, @Argument Integer value) {
        return TradeGRAPHQL.updateById(id, value);
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

    @SchemaMapping
    public UserGRAPHQL buyer(TradeGRAPHQL trade) {
        return UserGRAPHQL.getById(trade.getBuyerId());
    }

    @SchemaMapping
    public UserGRAPHQL seller(TradeGRAPHQL trade) {
        return UserGRAPHQL.getById(trade.getSellerId());
    }

}
