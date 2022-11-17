package com.psi.project.address;

import com.psi.project.address.dtos.AddressRequestDTO;
import com.psi.project.address.dtos.AddressResponseDTO;
import com.psi.project.users.dtos.UserRequestDTO;
import com.psi.project.users.dtos.UserResponseDTO;
import com.psi.project.users.valueobjects.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }
    public List<AddressResponseDTO> getAddresses() {
        var addresses = addressRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
        return addressMapper.fromAddressEntityListToAddressResponseDTOList(addresses);
    }
    public void addAddress(AddressRequestDTO addressRequestDTO) {
        var address = addressMapper.fromAddressRequestDTOToAddressEntity(addressRequestDTO);
        addressRepository.save(address);
    }
}
