package com.psi.project.graphql.address;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS_GRAPHQL")
public class AddressGRAPHQL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String city;
    private String street;

    public AddressGRAPHQL(Integer id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    private static final List<AddressGRAPHQL> addresses = Arrays.asList(
            new AddressGRAPHQL(1, "Olsztin", "Pomysłowa 54"),
            new AddressGRAPHQL(2, "Bemowo", "Daleka 13"),
            new AddressGRAPHQL(3, "Prawieolsztyn", "Bliska 118"),
            new AddressGRAPHQL(4, "Bliskolsztyn", "Janowicza 07"),
            new AddressGRAPHQL(5, "Dalekolsztyn", "Niemądra 23")
    );

    public static AddressGRAPHQL getById(Integer id) {
        return addresses
                .stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<AddressGRAPHQL> getAllAddresses() {
        return addresses;
    }

    public static AddressGRAPHQL updateById(Integer id, String city, String street) {
        var address = addresses
                .stream()
                .filter(addressX -> addressX.getId().equals(id))
                .findFirst()
                .orElse(null);
        address.setCity(city);
        address.setStreet(street);
        return address;
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

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

}
