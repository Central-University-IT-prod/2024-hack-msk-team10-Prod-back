package com.hatoms.spring.service;

import com.hatoms.spring.DTO.UserEmail;
import com.hatoms.spring.DTO.UserLoginDTO;
import com.hatoms.spring.model.Group;
import com.hatoms.spring.model.User;
import com.hatoms.spring.repository.GroupRepository;
import com.hatoms.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;


    // Создание нового пользователя
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Получение пользователя по ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Получение пользователя по email

    public Long saveNewUser(User user) {
        var u = userRepository.save(user);
        return u.getId();
    }

    public Long login(UserLoginDTO userloginDTO) {
        var user = userRepository.findByEmail(userloginDTO.getEmail()).orElseThrow(() -> new RuntimeException("User is not found."));
        if (Objects.equals(user.getPassword(), userloginDTO.getPassword())){
            return user.getId();
        } else {
            throw new RuntimeException("Password is not found");
        }
    }

    public Group getAllByEmails(List<String> group) {
        var users = userRepository.findAllByEmailIn(group);
        var group1 = Group.builder().users(users).build();
        return groupRepository.save(group1);


    }
}
