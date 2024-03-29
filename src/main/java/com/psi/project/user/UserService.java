package com.psi.project.user;

import com.psi.project.address.AddressEntity;
import com.psi.project.address.AddressMapper;
import com.psi.project.address.AddressRepository;
import com.psi.project.address.valueobjects.CityValidator;
import com.psi.project.address.valueobjects.StreetValidator;
import com.psi.project.address.valueobjects.ZipCodeValidator;
import com.psi.project.user.dtos.UserCreateDTO;
import com.psi.project.user.dtos.UserResponseDTO;
import com.psi.project.user.valueobjects.EmailValidator;
import com.psi.project.user.valueobjects.TypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 *
 *  Web Serwis użytkownika
 *  @author Igor Kawczyński
 *
 */
@Service
public class UserService {

    private final static Integer PAGESIZE = 5;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    @Autowired
    public UserService(
            UserRepository userRepository,
            UserMapper userMapper,
            AddressMapper addressMapper,
            AddressRepository addressRepository
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public List<UserResponseDTO> getUsers(Integer page) {

        Pageable sortedByUsername = PageRequest.of(
                page, PAGESIZE, Sort.by(Sort.Direction.ASC, "firstName")
                                       .and(Sort.by(Sort.Direction.ASC, "lastName"))
        );

        var users =
                userRepository
                        .findAll(sortedByUsername);

        return userMapper
                .fromUserEntityListToUserResponseList(users.get().collect(Collectors.toList()));
    }

    public UserResponseDTO getUserByEmail(String email){
        var user =
                userRepository
                .findUserByEmail(new EmailValidator(email))
                .orElseThrow(() -> new NoSuchElementException("User with email: " + email + " does not exist!"));
        return userMapper.fromUserEntityToUserResponseDTO((UserEntity)user);
    }

    public List<UserResponseDTO> findUsersByType(String type){
        var users =
                userRepository
                        .findByTypeEquals(TypeValidator.valueOf(type));

        return userMapper.fromUserEntityListToUserResponseList(users);
    }

    public String addUser(UserCreateDTO userCreateDTO) {
        var user = userMapper.fromUserCreateDTOToUserEntity(userCreateDTO);
        var address = addressMapper.fromAddressRequestDTOToAddressEntity(userCreateDTO.addressRequestDTO());
        addressRepository.save(address);
        user.setAddressEntity(address);
        userRepository.save(user);
        return "** Successfully added user with his address **";
    }

    public String updateUserEmailById(Long id, EmailValidator email) {
        var user =
                userRepository
                .findUserEntityById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id : " + id + " does not exist!"));
        UserEntity userToUpdate = (UserEntity) user;
        userToUpdate.setEmail(email);
        userRepository.save(userToUpdate);
        return "User with id: " + id + " updated successfully!";
    }

    public String deleteUser(Long id) {
        var user =
                userRepository
                .findUserEntityById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id : " + id + " does not exist!"));
        userRepository.delete((UserEntity) user);
        return "User with id: " + id + " deleted successfully!";
    }

}
