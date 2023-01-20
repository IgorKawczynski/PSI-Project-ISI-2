package com.psi.project.address;

import com.psi.project.address.dtos.AddressRequestDTO;
import com.psi.project.address.dtos.AddressResponseDTO;
import com.psi.project.address.valueobjects.CityValidator;
import com.psi.project.address.valueobjects.StreetValidator;
import com.psi.project.address.valueobjects.ZipCodeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final static Integer PAGESIZE = 5;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }
    public List<AddressResponseDTO> getAddresses(Integer page) {
        Pageable sortedByCityAndStreet = PageRequest.of(
                page, PAGESIZE, Sort.by(Sort.Direction.ASC, "city")
                        .and(Sort.by(Sort.Direction.ASC, "street"))
        );
        var addresses = addressRepository.findAll(sortedByCityAndStreet);
        return addressMapper.fromAddressEntityListToAddressResponseDTOList(addresses.get().collect(Collectors.toList()));
    }

    public AddressResponseDTO getAddressesById(Long id) {
        var address = addressRepository.findAddressEntityById(id);
        return addressMapper.fromAddressEntityToAddressResponseDTO(address);
    }

    public void addAddress(AddressRequestDTO addressRequestDTO) {
        var address = addressMapper.fromAddressRequestDTOToAddressEntity(addressRequestDTO);
        addressRepository.save(address);
    }

    public String updateAddressById(Long id, AddressRequestDTO newAddress){
        try {
            var address = addressRepository.findAddressEntityById(id);
            address.setCity(new CityValidator(newAddress.city()));
            address.setStreet(new StreetValidator(newAddress.street()));
            address.setZipCode(new ZipCodeValidator(newAddress.zipCode()));
            addressRepository.save(address);
        }
        catch (NoSuchElementException exception){
            return "Address with id : " + id + " does not exist!";
        }
        return "Address changed successfully";
    }

    public String deleteAddressById(Long id) {
        try {
            var address = addressRepository.findAddressEntityById(id);
            addressRepository.delete(address);
        }
        catch (NoSuchElementException exception) {
            return "Address with id : " + id + " does not exist!";
        }
        return "Address deleted successfully";
    }

}
