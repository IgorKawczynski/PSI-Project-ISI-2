package com.psi.project.user;

import com.psi.project.user.dtos.UserRequestDTO;
import com.psi.project.user.dtos.UserResponseDTO;
import com.psi.project.user.valueobjects.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Kontroler typu REST użytkownika
 * @author Igor Kawczyński
 *
 */
@RestController
@RequestMapping( "/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<UserResponseDTO> getUsers(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        return userService.getUsers(page);
    }
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public UserResponseDTO getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }
    @GetMapping("/where")
    @ResponseStatus(HttpStatus.FOUND)
    public List<UserResponseDTO> findUsersByType(@RequestParam("type") String type) {
        return userService.findUsersByType(type);
    }
    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.addUser(userRequestDTO);
    }
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String changeUserEmail(@PathVariable("id") Long id, @RequestBody String email) {
        return userService.updateUserEmailById(id, new EmailValidator(email));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteUserById(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
