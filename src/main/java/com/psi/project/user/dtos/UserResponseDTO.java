package com.psi.project.user.dtos;

import lombok.Builder;

public record UserResponseDTO(String email,
                              String firstName,
                              String lastName,
                              String pesel,
                              String type) {
    @Builder
    public UserResponseDTO {}
}
