package com.psi.project.user;

import com.psi.project.address.AddressEntity;
import com.psi.project.address.AddressRepository;
import com.psi.project.user.dtos.UserCreateDTO;
import com.psi.project.user.dtos.UserRequestDTO;
import com.psi.project.user.dtos.UserResponseDTO;
import com.psi.project.user.valueobjects.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final AddressRepository addressRepository;

    @Autowired
    public UserMapper(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public UserResponseDTO fromUserEntityToUserResponseDTO(UserEntity userEntity){
        return UserResponseDTO.builder()
                .email(userEntity.getEmail().toString())
                .firstName(userEntity.getFirstName().toString())
                .lastName(userEntity.getLastName().toString())
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
                .firstName(userEntity.getFirstName().toString())
                .lastName(userEntity.getLastName().toString())
                .pesel(userEntity.getPesel().toString())
                .type(userEntity.getType().toString())
                .addressId(userEntity.getAddressEntity().getId())
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
                .firstName(new NameValidator(userRequestDTO.firstName()))
                .lastName(new NameValidator(userRequestDTO.lastName()))
                .password(new PasswordValidator(userRequestDTO.password()))
                .pesel(new PeselValidator(userRequestDTO.pesel()))
                .type(TypeValidator.valueOf(userRequestDTO.type()))
                .addressEntity(addressRepository.findAddressEntityById(userRequestDTO.addressId()))
                .build();
    }

    public UserEntity fromUserCreateDTOToUserEntity(UserCreateDTO userCreateDTO) {
        return UserEntity.builder()
                .email(new EmailValidator(userCreateDTO.email()))
                .firstName(new NameValidator(userCreateDTO.firstName()))
                .lastName(new NameValidator(userCreateDTO.lastName()))
                .password(new PasswordValidator(userCreateDTO.password()))
                .pesel(new PeselValidator(userCreateDTO.pesel()))
                .type(TypeValidator.CLIENT)
                .addressEntity(createNewAddress())
                .build();
    }

    private AddressEntity createNewAddress() {
        var address = new AddressEntity();
        return addressRepository.save(address);
    }

}
