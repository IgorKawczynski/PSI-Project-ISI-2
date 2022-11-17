package com.psi.project.address.dtos;

import lombok.Builder;

public record AddressRequestDTO(String zipCode, String city, String street) {

    @Builder
    public AddressRequestDTO {}
}

