package com.psi.project.users;

import com.psi.project.users.dtos.UserRequestDTO;
import com.psi.project.users.dtos.UserResponseDTO;
import com.psi.project.users.valueobjects.EmailValidator;
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
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> getUsers() {
        var users =
                userRepository
                        .findAll(PageRequest.of(2, PAGESIZE));
        return userMapper.fromUserEntityListToUserResponseList(users.get().collect(Collectors.toList()));
    }

    public UserResponseDTO getUserByEmail(String email){
        var user =
                userRepository
                .findUserByEmail(new EmailValidator(email))
                .orElseThrow(() -> new NoSuchElementException("USER with email: " + email + " does not exist!!"));
        return userMapper.fromUserEntityToUserResponseDTO((UserEntity)user);
    }

    public void addUser(UserRequestDTO userRequestDTO) {
        var user = userMapper.fromUserRequestDTOToUserEntity(userRequestDTO);
        userRepository.save(user);
    }

    public String updateUserEmailById(Long id, EmailValidator email) {
        var user =
                userRepository
                .findUserEntityById(id)
                .orElseThrow(() -> new NoSuchElementException("USER with id : " + id + " does not exist !!"));
        UserEntity userToUpdate = (UserEntity) user;
        userToUpdate.setEmail(email);
        userRepository.save(userToUpdate);
        return "User with id: " + id + " updated successfully!";
    }

    public String deleteUser(Long id) {
        var user =
                userRepository
                .findUserEntityById(id)
                .orElseThrow(() -> new NoSuchElementException("USER with id : " + id + " does not exist !!"));
        userRepository.delete((UserEntity) user);
        return "User with id: " + id + " deleted successfully!";
    }

}
