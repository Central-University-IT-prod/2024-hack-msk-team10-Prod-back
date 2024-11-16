package com.hatoms.spring.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class GroupDTO {

    private Long id;
    private String groupName;
    private LocalDateTime createdAt;
    private Set<UserDTO> users; // Список пользователей, принадлежащих группе

}
