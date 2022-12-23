package com.psi.project.address;

import com.psi.project.address.dtos.AddressRequestDTO;
import com.psi.project.address.dtos.AddressResponseDTO;
import com.psi.project.address.valueobjects.CityValidator;
import com.psi.project.address.valueobjects.StreetValidator;
import com.psi.project.address.valueobjects.ZipCodeValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressMapper {
    public AddressRequestDTO fromAddressEntityToAddressRequestDTO(AddressEntity addressEntity){
        return AddressRequestDTO.builder()
                .zipCode(addressEntity.getZipCode().toString())
                .city(addressEntity.getCity().toString())
                .street(addressEntity.getStreet().toString())
                .build();

    }
    public List<AddressRequestDTO> fromAddressEntityListToAddressRequestDTOList(List<AddressEntity> addressEntityList){
        return addressEntityList.stream()
                .map(this::fromAddressEntityToAddressRequestDTO)
                .collect(Collectors.toList());
    }
    public AddressResponseDTO fromAddressEntityToAddressResponseDTO(AddressEntity addressEntity){
        return AddressResponseDTO.builder()
                .zipCode(addressEntity.getZipCode().toString())
                .city(addressEntity.getCity().toString())
                .street(addressEntity.getStreet().toString())
                .build();

    }
    public List<AddressResponseDTO> fromAddressEntityListToAddressResponseDTOList(List<AddressEntity> addressEntityList){
        return addressEntityList.stream()
                .map(this::fromAddressEntityToAddressResponseDTO)
                .collect(Collectors.toList());
    }
    public AddressEntity fromAddressRequestDTOToAddressEntity(AddressRequestDTO addressRequestDTO) {
        return AddressEntity.builder()
                .zipCode(new ZipCodeValidator(addressRequestDTO.zipCode()))
                .city(new CityValidator(addressRequestDTO.city()))
                .street(new StreetValidator(addressRequestDTO.street()))
                .build();
    }
}
