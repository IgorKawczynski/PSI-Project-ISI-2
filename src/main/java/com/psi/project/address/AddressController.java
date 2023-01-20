package com.psi.project.address;

import com.psi.project.address.dtos.AddressRequestDTO;
import com.psi.project.address.dtos.AddressResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AddressResponseDTO> getAddresses(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        return addressService.getAddresses(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public AddressResponseDTO getAddressById(@PathVariable Long id) {
        return addressService.getAddressesById(id);
    }

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody AddressRequestDTO addressRequestDTO) {
         addressService.addAddress(addressRequestDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String changeAddressById(@PathVariable("id") Long id, @RequestBody AddressRequestDTO newAddress) {
        return addressService.updateAddressById(id, newAddress);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteAddressById(@PathVariable("id") Long id) {
        return addressService.deleteAddressById(id);
    }

}
