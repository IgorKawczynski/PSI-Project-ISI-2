package com.psi.project.graphql.address;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AddressGRAPHQLController {

    @QueryMapping
    public AddressGRAPHQL addressById(@Argument String id) {
        return AddressGRAPHQL.getById(id);
    }

    @QueryMapping
    public AddressGRAPHQL addressByCity(@Argument String city) {
        return AddressGRAPHQL.getByCity(city);
    }

    @QueryMapping
    public AddressGRAPHQL addressByStreet(@Argument String street) {
        return AddressGRAPHQL.getByStreet(street);
    }
}

