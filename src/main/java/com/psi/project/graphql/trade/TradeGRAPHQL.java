package com.psi.project.graphql.trade;


import java.util.Arrays;
import java.util.List;

public class TradeGRAPHQL {

    private final String id;

    private final Integer value;
    private final String buyerId;
    private final String sellerId;

    public TradeGRAPHQL(String id, Integer value, String buyerId, String sellerId) {
        this.id = id;
        this.value = value;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
    }

    private static final List<TradeGRAPHQL> trades = Arrays.asList(
            new TradeGRAPHQL("1 Trade",  54, "3 user", "2 user"),
            new TradeGRAPHQL("2 Trade",  212, "1 user", "2 user"),
            new TradeGRAPHQL("3 Trade",  5133, "2 user", "3 user"),
            new TradeGRAPHQL("4 Trade",  4097, "5 user", "4 user"),
            new TradeGRAPHQL("5 Trade",  2256, "5 user", "1 user")
    );

    public static TradeGRAPHQL getById(String id) {
        return trades
                .stream()
                .filter(trade -> trade.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static TradeGRAPHQL getByValue(Integer value) {
        return trades
                .stream()
                .filter(trade -> trade.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

    public static TradeGRAPHQL getByBuyer(String buyerId) {
        return trades
                .stream()
                .filter(trade -> trade.getBuyerId().equals(buyerId))
                .findFirst()
                .orElse(null);
    }

    public static TradeGRAPHQL getBySeller(String sellerId) {
        return trades
                .stream()
                .filter(trade -> trade.getSellerId().equals(sellerId))
                .findFirst()
                .orElse(null);
    }

    public String getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }
}
