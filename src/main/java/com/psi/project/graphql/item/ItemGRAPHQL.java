package com.psi.project.graphql.item;


import com.psi.project.graphql.address.AddressGRAPHQL;
import io.swagger.models.auth.In;
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
@Table(name = "ITEM_GRAPHQL")
public class ItemGRAPHQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer cost;
    private Integer userId;

    public ItemGRAPHQL(Integer id, String name, Integer cost, Integer userId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.userId = userId;
    }

    private static final List<ItemGRAPHQL> items = Arrays.asList(
            new ItemGRAPHQL(1, "TaniaRzecz", 54, 3),
            new ItemGRAPHQL(2, "Intel Core i9 128K", 1024, 4),
            new ItemGRAPHQL(3, "5GB RAM", 512, 1),
            new ItemGRAPHQL(4, "Ciupaga", 256, 2),
            new ItemGRAPHQL(5, "DrogaRzecz", 4096, 5)
    );

    public static ItemGRAPHQL getById(Integer id) {
        return items
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<ItemGRAPHQL> getAllItems() {
        return items;
    }

    public static ItemGRAPHQL updateById(Integer id, String name, Integer cost) {
        var item = items
                .stream()
                .filter(itemX -> itemX.getId().equals(id))
                .findFirst()
                .orElse(null);
        item.setName(name);
        item.setCost(cost);
        return item;
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

    public static ItemGRAPHQL getByUser(Integer userId) {
        return items
                .stream()
                .filter(item -> item.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getUserId() {
        return userId;
    }

}
