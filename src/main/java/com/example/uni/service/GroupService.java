package com.example.uni.service;

import com.example.uni.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<Group> getAllGroups();

    Group getGroup(Long id);

    Group addGroup(Group group);

    void deleteGroup(Long id);

    List<Group> searchGroups(Group group);
}
