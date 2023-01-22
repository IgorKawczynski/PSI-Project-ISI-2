package com.psi.project.graphql.item;

import com.psi.project.graphql.address.AddressGRAPHQL;
import com.psi.project.graphql.user.UserGRAPHQL;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ItemGRAPHQLController {

    @QueryMapping
    public ItemGRAPHQL itemById(@Argument Integer id) {
        return ItemGRAPHQL.getById(id);
    }

    @QueryMapping
    public List<ItemGRAPHQL> allItems() {
        return ItemGRAPHQL.getAllItems();
    }

    @MutationMapping
    public ItemGRAPHQL updateItemById(@Argument Integer id, @Argument String name, @Argument Integer cost) {
        return ItemGRAPHQL.updateById(id, name, cost);
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

    @SchemaMapping
    public UserGRAPHQL userGRAPHQL(ItemGRAPHQL item) {
        return UserGRAPHQL.getById(item.getUserId());
    }

}

