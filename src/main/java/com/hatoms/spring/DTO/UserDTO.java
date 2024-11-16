package com.hatoms.spring.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {

    private String name;
    private String email;
    private String password;

}
