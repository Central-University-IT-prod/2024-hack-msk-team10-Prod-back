package com.hatoms.spring.Mapper;

import com.hatoms.spring.DTO.UserDTO;
import com.hatoms.spring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {


    // Маппинг из сущности User в UserDTO
    UserDTO userToUserDTO(User user);

    // Маппинг из UserDTO в User (если нужно)
    User userDTOToUser(UserDTO userDTO);
}
