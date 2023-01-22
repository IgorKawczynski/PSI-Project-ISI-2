package com.psi.project.graphql.address;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressGRAPHQLService {

    @Autowired
    private AddressGRAPHQLRepository addressGRAPHQLRepository;

    public List<AddressGRAPHQL> getAllAddresses() {
        return addressGRAPHQLRepository.findAll();
    }

    public AddressGRAPHQL getAddressById(Integer id) {
        return addressGRAPHQLRepository.findAddressGRAPHQLById(id);
    }

    public AddressGRAPHQL addAddress(AddressGRAPHQL address) {
        return addressGRAPHQLRepository.save(address);
    }

    public AddressGRAPHQL updateAddressById(Integer id, String city, String street) {
        var address = addressGRAPHQLRepository.findAddressGRAPHQLById(id);
            address.setCity(city);
            address.setStreet(street);
            return address;
    }

    public Integer deleteAddressById(Integer id) {
        addressGRAPHQLRepository.deleteById(id);
        return id;
    }
}
