package com.github.mroose.mvc.mapper;

import com.github.mroose.mvc.dto.AddressRequestDTO;
import com.github.mroose.mvc.dto.AddressResponseDTO;
import com.github.mroose.mvc.entity.AddressEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressEntity dtoToEntity(AddressRequestDTO addressRequestDTO);

    AddressResponseDTO entityToDto(AddressEntity addressEntity);

    List<AddressResponseDTO> entityListToDtoList(List<AddressEntity> addressEntityList);
}