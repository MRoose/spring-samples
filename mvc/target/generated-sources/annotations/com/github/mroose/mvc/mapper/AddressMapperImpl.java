package com.github.mroose.mvc.mapper;

import com.github.mroose.mvc.dto.AddressRequestDTO;
import com.github.mroose.mvc.dto.AddressResponseDTO;
import com.github.mroose.mvc.entity.AddressEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T00:01:07+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity dtoToEntity(AddressRequestDTO addressRequestDTO) {
        if ( addressRequestDTO == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCity( addressRequestDTO.getCity() );
        addressEntity.setStreet( addressRequestDTO.getStreet() );
        addressEntity.setHouse( addressRequestDTO.getHouse() );
        addressEntity.setFlat( addressRequestDTO.getFlat() );

        return addressEntity;
    }

    @Override
    public AddressResponseDTO entityToDto(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();

        addressResponseDTO.setId( addressEntity.getId() );
        addressResponseDTO.setCity( addressEntity.getCity() );
        addressResponseDTO.setStreet( addressEntity.getStreet() );
        addressResponseDTO.setHouse( addressEntity.getHouse() );
        addressResponseDTO.setFlat( addressEntity.getFlat() );

        return addressResponseDTO;
    }

    @Override
    public List<AddressResponseDTO> entityListToDtoList(List<AddressEntity> addressEntityList) {
        if ( addressEntityList == null ) {
            return null;
        }

        List<AddressResponseDTO> list = new ArrayList<AddressResponseDTO>( addressEntityList.size() );
        for ( AddressEntity addressEntity : addressEntityList ) {
            list.add( entityToDto( addressEntity ) );
        }

        return list;
    }
}
