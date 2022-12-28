package com.psi.project.graphql.address;

import java.util.Arrays;
import java.util.List;

public class AddressGRAPHQL {

    private final String id;
    private final String city;
    private final String street;

    public AddressGRAPHQL(String id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    private static final List<AddressGRAPHQL> addresses = Arrays.asList(
            new AddressGRAPHQL("1 Address", "Olsztin", "Pomysłowa 54"),
            new AddressGRAPHQL("2 Address", "Bemowo", "Daleka 13"),
            new AddressGRAPHQL("3 Address", "Prawieolsztyn", "Bliska 118"),
            new AddressGRAPHQL("4 Address", "Bliskolsztyn", "Janowicza 07"),
            new AddressGRAPHQL("5 Address", "Dalekolsztyn", "Niemądra 23")
    );

    public static AddressGRAPHQL getById(String id) {
        return addresses
                .stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static AddressGRAPHQL getByCity(String city) {
        return addresses
                .stream()
                .filter(address -> address.getCity().equals(city))
                .findFirst()
                .orElse(null);
    }

    public static AddressGRAPHQL getByStreet(String street) {
        return addresses
                .stream()
                .filter(address -> address.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

}
