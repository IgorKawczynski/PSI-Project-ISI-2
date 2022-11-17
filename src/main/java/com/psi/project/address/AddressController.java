package com.psi.project.address;

import com.psi.project.address.dtos.AddressRequestDTO;
import com.psi.project.users.dtos.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody AddressRequestDTO addressRequestDTO) {
         addressService.addAddress(addressRequestDTO);
    }

}
