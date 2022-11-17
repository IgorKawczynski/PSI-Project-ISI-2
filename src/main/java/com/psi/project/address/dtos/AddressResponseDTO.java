package com.psi.project.address.dtos;

import lombok.Builder;

public record AddressResponseDTO(String zipCode, String city, String street) {

    @Builder
    public AddressResponseDTO {}
}