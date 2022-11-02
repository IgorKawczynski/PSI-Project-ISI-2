package com.psi.project.user.dtos;

import lombok.Builder;

public record UserRequestDTO(String email, String password, String name, String pesel, String type) {

    @Builder
    public UserRequestDTO {}
}
