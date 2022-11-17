package com.psi.project.users.dtos;

import lombok.Builder;

public record UserRequestDTO(String email, String username, String password, String pesel, String type) {
    @Builder
    public UserRequestDTO {}
}
