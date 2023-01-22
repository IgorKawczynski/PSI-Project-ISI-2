package com.psi.project.graphql.item;

import com.psi.project.graphql.user.UserGRAPHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemGRAPHQLController {

    @Autowired
    private ItemGRAPHQLService itemGRAPHQLService;

    /**
    Metody Korzystające tylko z modelu (nie połączone z bazą danych)
     */
    @QueryMapping
    public List<ItemGRAPHQL> allItems() {
        return ItemGRAPHQL.getAllItems();
    }

    @QueryMapping
    public ItemGRAPHQL itemById(@Argument Integer id) {
        return ItemGRAPHQL.getById(id);
    }

    @QueryMapping
    public ItemGRAPHQL itemByName(@Argument String name) {
        return ItemGRAPHQL.getByName(name);
    }

    @QueryMapping
    public ItemGRAPHQL itemByCost(@Argument Integer cost) {
        return ItemGRAPHQL.getByCost(cost);
    }

    @QueryMapping
    public ItemGRAPHQL itemByUser(@Argument Integer userId) {
        return ItemGRAPHQL.getByUser(userId);
    }

    /**
     Metody Korzystające z serwisu - połączone z bazą danych
     */
    @QueryMapping
    public List<ItemGRAPHQL> getAllItems() {
        return itemGRAPHQLService.getAllItems();
    }

    @QueryMapping
    public ItemGRAPHQL getItemById(@Argument Integer id) {
        return itemGRAPHQLService.getItemById(id);
    }

    @MutationMapping
    public ItemGRAPHQL addItem(@Argument ItemGRAPHQL item) {
        return itemGRAPHQLService.addItem(item);
    }

    @MutationMapping
    public ItemGRAPHQL updateItemById(@Argument Integer id, @Argument String name, @Argument Integer cost) {
        return itemGRAPHQLService.updateItemById(id, name, cost);
    }

    @MutationMapping
    public Integer deleteItemById(@Argument Integer id) {
        return itemGRAPHQLService.deleteItemById(id);
    }

    @SchemaMapping
    public UserGRAPHQL userGRAPHQL(ItemGRAPHQL item) {
        return UserGRAPHQL.getById(item.getUserId());
    }

}

