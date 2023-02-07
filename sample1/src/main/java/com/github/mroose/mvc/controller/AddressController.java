package com.github.mroose.mvc.controller;

import com.github.mroose.mvc.dto.AddressRequestDTO;
import com.github.mroose.mvc.dto.AddressResponseDTO;
import com.github.mroose.mvc.service.AddressService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/api/v1/addresses")
    public List<AddressResponseDTO> getAddresses() {
        return addressService.getAddresses();
    }

    @PostMapping("/api/v1/address")
    public void saveAddress(AddressRequestDTO addressRequestDTO) {
        addressService.saveAddress(addressRequestDTO);
    }

    @GetMapping("/api/v1/address/{id}")
    public AddressResponseDTO getAddress(@PathVariable Integer id) {
        return addressService.getAddress(id);
    }

    @DeleteMapping("/api/v1/address/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}