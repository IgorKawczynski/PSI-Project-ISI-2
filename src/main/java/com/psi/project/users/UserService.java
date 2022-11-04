package com.psi.project.users;

import com.psi.project.users.dtos.UserResponseDTO;
import com.psi.project.users.valueobjects.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * Web Serwis użytkownika
 *
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDTO> getUsers() {
        var users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return userMapper.fromUserEntityListToUserResponseList(users);
    }

    public UserResponseDTO getUserByEmail(String email){
        var user = userRepository.findUserByEmail(new EmailValidator(email))
                .orElseThrow(() -> new NoSuchElementException("UserEntity with email: " + email + " does not exist!"));
        return (UserResponseDTO) user;
    }

    public String updateUserEmail(Long id, EmailValidator email) {
        var user = userRepository.findUserEntityById(id);
        user.setEmail(email);
        userRepository.save(user);
        return "User with id: " + id + " updated successfully!";
    }

    public String deleteUser(Long id) {
        var user = userRepository.findUserEntityById(id);
        userRepository.delete(user);
        return "User with id: " + id + " deleted successfully!";
    }

}
