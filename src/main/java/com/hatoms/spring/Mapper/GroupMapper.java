package com.hatoms.spring.Mapper;

import com.hatoms.spring.DTO.GroupDTO;
import com.hatoms.spring.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring") // Указываем Spring, чтобы Spring мог инжектить этот маппер
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    // Маппинг из сущности Group в GroupDTO // Список пользователей из Group в Set<UserDTO>
    GroupDTO groupToGroupDTO(Group group);

    // Маппинг из списка сущностей Group в список GroupDTO
    List<GroupDTO> groupListToGroupDTOList(List<Group> groups);

    // Маппинг из GroupDTO в Group (если нужно)
    Group groupDTOToGroup(GroupDTO groupDTO);
}

