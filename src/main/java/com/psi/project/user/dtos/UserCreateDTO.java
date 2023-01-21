package com.psi.project.user.dtos;

import com.psi.project.address.AddressEntity;
import com.psi.project.address.dtos.AddressRequestDTO;
import lombok.Builder;

public record UserCreateDTO(String email,
                            String firstName,
                            String lastName,
                            String password,
                            String pesel,
                            AddressRequestDTO addressRequestDTO) {

    @Builder
    public  UserCreateDTO {}
}