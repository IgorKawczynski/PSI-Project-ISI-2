package com.psi.project.user.dtos;

import lombok.Builder;

public record UserCreateDTO(String email,
                            String firstName,
                            String lastName,
                            String password,
                            String pesel) {

    @Builder
    public  UserCreateDTO {}
}