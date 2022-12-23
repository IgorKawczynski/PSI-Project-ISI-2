package com.psi.project.user.dtos;

import lombok.Builder;

public record UserRequestDTO(String email,
                             String firstName,
                             String lastName,
                             String password,
                             String pesel,
                             String type,
                             Long addressId) {

    @Builder
    public UserRequestDTO {}
}
