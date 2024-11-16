package com.hatoms.spring.controller;

import com.hatoms.spring.model.Group;
import com.hatoms.spring.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    // Создание группы
    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    // Добавление пользователя в группу
    @PostMapping("/{groupId}/addUser/{userId}")
    public Group addUserToGroup(@PathVariable Long groupId,
                                @PathVariable Long userId) {
        return groupService.addUserToGroup(groupId, userId);
    }

    // Получение всех групп
    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}
