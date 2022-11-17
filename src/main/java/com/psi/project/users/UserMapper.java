package com.psi.project.users;

import com.psi.project.users.dtos.UserRequestDTO;
import com.psi.project.users.dtos.UserResponseDTO;
import com.psi.project.users.valueobjects.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Konwerter pomiędzy encją a obiektami typu data-transfer użytkownika
 * @author Igor Kawczyński
 *
 */
@Component
public class UserMapper {

    public UserResponseDTO fromUserEntityToUserResponseDTO(UserEntity userEntity){
        return UserResponseDTO.builder()
                .email(userEntity.getEmail().toString())
                .username(userEntity.getUsername().toString())
                .pesel(userEntity.getPesel().toString())
                .type(userEntity.getType().toString())
                .build();
    }

    public List<UserResponseDTO> fromUserEntityListToUserResponseList(List<UserEntity> userEntityList){
        return userEntityList.stream()
                .map(this::fromUserEntityToUserResponseDTO)
                .collect(Collectors.toList());
    }


    public UserRequestDTO fromUserEntityToUserRequestDTO(UserEntity userEntity){
        return UserRequestDTO.builder()
                .email(userEntity.getEmail().toString())
                .password(userEntity.getPassword().toString())
                .username(userEntity.getUsername().toString())
                .pesel(userEntity.getPesel().toString())
                .type(userEntity.getType().toString())
                .build();
    }

    public List<UserRequestDTO> fromUserEntityListToUserRequestList(List<UserEntity> userEntityList){
        return userEntityList.stream()
                .map(this::fromUserEntityToUserRequestDTO)
                .collect(Collectors.toList());
    }

    public UserEntity fromUserRequestDTOToUserEntity(UserRequestDTO userRequestDTO) {
        return UserEntity.builder()
                .email(new EmailValidator(userRequestDTO.email()))
                .username(new NameValidator(userRequestDTO.username()))
                .password(new PasswordValidator(userRequestDTO.password()))
                .pesel(new PeselValidator(userRequestDTO.pesel()))
                .type(TypeValidator.valueOf(userRequestDTO.type()))
                .build();
    }
}
