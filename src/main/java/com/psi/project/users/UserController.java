package com.psi.project.users;

import com.psi.project.users.dtos.UserRequestDTO;
import com.psi.project.users.dtos.UserResponseDTO;
import com.psi.project.users.valueobjects.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }
    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.addUser(userRequestDTO);
    }
    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String changeUserEmail(@RequestParam("id") Long id, @RequestBody String email) {
        return userService.updateUserEmail(id, new EmailValidator(email));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteUserById(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
