package com.psi.project.users.dtos;

import lombok.Builder;

public record UserResponseDTO(String email, String username, String pesel, String type) {

    @Builder
    public UserResponseDTO {}
}
