package com.psi.project.users.dtos;

import lombok.Builder;

public record UserRequestDTO(String email, String password, String username, String pesel, String type) {

    @Builder
    public UserRequestDTO {}
}
