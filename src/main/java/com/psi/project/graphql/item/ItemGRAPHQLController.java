package com.psi.project.graphql.item;

import com.psi.project.graphql.user.UserGRAPHQL;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ItemGRAPHQLController {

    @QueryMapping
    public ItemGRAPHQL itemById(@Argument String id) {
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
    public ItemGRAPHQL itemByUser(@Argument String userId) {
        return ItemGRAPHQL.getByUser(userId);
    }

    @SchemaMapping
    public UserGRAPHQL userGRAPHQL(ItemGRAPHQL item) {
        return UserGRAPHQL.getById(item.getUserId());
    }

}

