package com.hatoms.spring.service;

import com.hatoms.spring.model.Group;
import com.hatoms.spring.model.User;
import com.hatoms.spring.repository.GroupRepository;
import com.hatoms.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    // Создание новой группы
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    // Добавление пользователя в группу
    public Group addUserToGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        group.getUsers().add(user); // Добавляем пользователя в группу
        user.getGroups().add(group); // Добавляем группу пользователю

        groupRepository.save(group);
        userRepository.save(user);

        return group;
    }

    // Получение всех групп
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
