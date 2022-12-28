package com.psi.project.graphql.trade;

import com.psi.project.graphql.user.UserGRAPHQL;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TradeGRAPHQLController {

    @QueryMapping
    public TradeGRAPHQL tradeById(@Argument String id) {
        return TradeGRAPHQL.getById(id);
    }

    @QueryMapping
    public TradeGRAPHQL tradeByValue(@Argument Integer value) {
        return TradeGRAPHQL.getByValue(value);
    }

    @QueryMapping
    public TradeGRAPHQL tradeByBuyer(@Argument String buyerId) {
        return TradeGRAPHQL.getByBuyer(buyerId);
    }

    @QueryMapping
    public TradeGRAPHQL tradeBySeller(@Argument String sellerId) {
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
