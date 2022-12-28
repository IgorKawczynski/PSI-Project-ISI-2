package com.psi.project.graphql.item;


import java.util.Arrays;
import java.util.List;

public class ItemGRAPHQL {

    private final String id;
    private final String name;
    private final Integer cost;
    private final String userId;

    public ItemGRAPHQL(String id, String name, Integer cost, String userId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.userId = userId;
    }

    private static final List<ItemGRAPHQL> items = Arrays.asList(
            new ItemGRAPHQL("1 Item", "TaniaRzecz", 54, "3 user"),
            new ItemGRAPHQL("2 Item", "Intel Core i9 128K", 1024, "4 user"),
            new ItemGRAPHQL("3 Item", "5GB RAM", 512, "1 user"),
            new ItemGRAPHQL("4 Item", "Ciupaga", 256, "2 user"),
            new ItemGRAPHQL("5 Item", "DrogaRzecz", 4096, "5 user")
    );

    public static ItemGRAPHQL getById(String id) {
        return items
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static ItemGRAPHQL getByName(String name) {
        return items
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static ItemGRAPHQL getByCost(Integer cost) {
        return items
                .stream()
                .filter(item -> item.getCost().equals(cost))
                .findFirst()
                .orElse(null);
    }

    public static ItemGRAPHQL getByUser(String userId) {
        return items
                .stream()
                .filter(item -> item.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public String getUserId() {
        return userId;
    }

}
