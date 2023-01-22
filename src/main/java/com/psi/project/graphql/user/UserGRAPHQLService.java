package com.psi.project.graphql.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGRAPHQLService {

    @Autowired
    private UserGRAPHQLRepository userGRAPHQLRepository;

    public List<UserGRAPHQL> getAllUsers() {
        return userGRAPHQLRepository.findAll();
    }

    public UserGRAPHQL getUserById(Integer id) {
        return userGRAPHQLRepository.findUserGRAPHQLById(id);
    }

    public UserGRAPHQL addUser(UserGRAPHQL user) {
        return userGRAPHQLRepository.save(user);
    }

    public UserGRAPHQL updateUserById(Integer id, String email, String firstName, String lastName, String pesel) {
        var user = userGRAPHQLRepository.findUserGRAPHQLById(id);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPesel(pesel);
        return user;
    }

    public Integer deleteUserById(Integer id) {
        userGRAPHQLRepository.deleteById(id);
        return id;
    }
}
