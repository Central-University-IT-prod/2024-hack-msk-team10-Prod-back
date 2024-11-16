package com.hatoms.spring.DTO;

import lombok.Data;

@Data
public class GroupMemberDTO {

    private Long groupId;
    private Long userId;
    private String role; // Роль пользователя в группе (например, "admin", "member")

}

