package com.hatoms.spring.controller;


import com.hatoms.spring.DTO.UserDTO;
import com.hatoms.spring.DTO.UserLoginDTO;
import com.hatoms.spring.Mapper.UserMapper;
import com.hatoms.spring.model.User;
import com.hatoms.spring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;




    @PostMapping("/register")
    public Long registerUser(@RequestBody UserDTO userDTO) {
        return userService.saveNewUser(userMapper.userDTOToUser(userDTO));
    }
    @Operation(summary = "Вход в аккаунт")
    @PostMapping("/login")
    public Long loginUser(@RequestBody UserLoginDTO userloginDTO) {
        return userService.login(userloginDTO);
    }
}
