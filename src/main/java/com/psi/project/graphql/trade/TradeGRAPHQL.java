package com.psi.project.graphql.trade;


import com.psi.project.graphql.item.ItemGRAPHQL;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TRADE_GRAPHQL")
public class TradeGRAPHQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer value;
    private Integer buyerId;
    private Integer sellerId;

    public TradeGRAPHQL(Integer id, Integer value, Integer buyerId, Integer sellerId) {
        this.id = id;
        this.value = value;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
    }

    private static final List<TradeGRAPHQL> trades = Arrays.asList(
            new TradeGRAPHQL(1,  54, 3, 2),
            new TradeGRAPHQL(2,  212, 1, 2),
            new TradeGRAPHQL(3,  5133, 2, 3),
            new TradeGRAPHQL(4,  4097, 5, 4),
            new TradeGRAPHQL(5,  2256, 5, 1)
    );

    public static TradeGRAPHQL getById(Integer id) {
        return trades
                .stream()
                .filter(trade -> trade.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<TradeGRAPHQL> getAllTrades() {
        return trades;
    }

    public static TradeGRAPHQL updateById(Integer id, Integer value) {
        var trade = trades
                .stream()
                .filter(tradeX -> tradeX.getId().equals(id))
                .findFirst()
                .orElse(null);
        trade.setValue(value);
        return trade;
    }

    public static TradeGRAPHQL getByValue(Integer value) {
        return trades
                .stream()
                .filter(trade -> trade.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

    public static TradeGRAPHQL getByBuyer(Integer buyerId) {
        return trades
                .stream()
                .filter(trade -> trade.getBuyerId().equals(buyerId))
                .findFirst()
                .orElse(null);
    }

    public static TradeGRAPHQL getBySeller(Integer sellerId) {
        return trades
                .stream()
                .filter(trade -> trade.getSellerId().equals(sellerId))
                .findFirst()
                .orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }
}
