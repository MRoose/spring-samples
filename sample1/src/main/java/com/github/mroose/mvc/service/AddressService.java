package com.github.mroose.mvc.service;

import com.github.mroose.mvc.dto.AddressRequestDTO;
import com.github.mroose.mvc.dto.AddressResponseDTO;
import com.github.mroose.mvc.entity.AddressEntity;
import com.github.mroose.mvc.mapper.AddressMapper;
import com.github.mroose.mvc.repository.AddressRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<AddressResponseDTO> getAddresses() {
        List<AddressEntity> addressEntityList = addressRepository.findAll();
        List<AddressResponseDTO> addressResponseDTOList = addressMapper.entityListToDtoList(addressEntityList);
        return addressResponseDTOList;
    }

    public AddressResponseDTO getAddress(Integer id) {
        Optional<AddressEntity> addressEntity = addressRepository.findById(id);

        if (addressEntity.isEmpty()) {
            throw new IllegalArgumentException("Address with id not exist!");
        }

        AddressResponseDTO addressResponseDTO = addressMapper.entityToDto(addressEntity.get());
        return addressResponseDTO;
    }

    public void saveAddress(AddressRequestDTO addressRequestDTO) {
        AddressEntity addressEntity = addressMapper.dtoToEntity(addressRequestDTO);
        addressRepository.save(addressEntity);
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}