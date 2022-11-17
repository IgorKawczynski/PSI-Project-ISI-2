package com.psi.project.address;

import com.psi.project.address.dtos.AddressRequestDTO;
import com.psi.project.address.dtos.AddressResponseDTO;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressMapper {
    public AddressRequestDTO fromAddressEntityToAddressRequestDTO(AddressEntity addressEntity){
        return AddressRequestDTO.builder()
                .zipCode(addressEntity.getZipCode())
                .city(addressEntity.getCity())
                .street(addressEntity.getStreet())
                .build();

    }
    public List<AddressRequestDTO> fromAddressEntityListToAddressRequestDTOList(List<AddressEntity> addressEntityList){
        return addressEntityList.stream()
                .map(this::fromAddressEntityToAddressRequestDTO)
                .collect(Collectors.toList());
    }
    public AddressResponseDTO fromAddressEntityToAddressResponseDTO(AddressEntity addressEntity){
        return AddressResponseDTO.builder()
                .zipCode(addressEntity.getZipCode())
                .city(addressEntity.getCity())
                .street(addressEntity.getStreet())
                .build();

    }
    public List<AddressResponseDTO> fromAddressEntityListToAddressResponseDTOList(List<AddressEntity> addressEntityList){
        return addressEntityList.stream()
                .map(this::fromAddressEntityToAddressResponseDTO)
                .collect(Collectors.toList());
    }
    public AddressEntity fromAddressRequestDTOToAddressEntity(AddressRequestDTO addressRequestDTO) {
        return AddressEntity.builder()
                .zipCode(addressRequestDTO.zipCode())
                .city(addressRequestDTO.city())
                .street(addressRequestDTO.street())
                .build();
    }
}
