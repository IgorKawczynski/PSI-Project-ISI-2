package com.psi.project.graphql.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AddressGRAPHQLController {

    @Autowired
    private AddressGRAPHQLService addressGRAPHQLService;

    /**
     Metody Korzystające tylko z modelu (nie połączone z bazą danych)
     */
    @QueryMapping
    public AddressGRAPHQL addressById(@Argument Integer id) {
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

    @QueryMapping
    public List<AddressGRAPHQL> allAddresses() {
        return AddressGRAPHQL.getAllAddresses();
    }


    /**
     Metody Korzystające z serwisu - połączone z bazą danych
     */
    @QueryMapping
    public List<AddressGRAPHQL> getAllAddresses() {
        return addressGRAPHQLService.getAllAddresses();
    }

    @QueryMapping
    public AddressGRAPHQL getAddressById(@Argument Integer id) {
        return addressGRAPHQLService.getAddressById(id);
    }

    @MutationMapping
    public AddressGRAPHQL addAddress(@Argument AddressGRAPHQL address) {
        return addressGRAPHQLService.addAddress(address);
    }

    @MutationMapping
    public AddressGRAPHQL updateAddressById(@Argument Integer id, @Argument String city, @Argument String street) {
        return addressGRAPHQLService.updateAddressById(id, city, street);
    }

    @MutationMapping
    public Integer deleteAddressById(@Argument Integer id) {
        return addressGRAPHQLService.deleteAddressById(id);
    }


}

