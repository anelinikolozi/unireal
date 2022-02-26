package com.example.uni.controller;

import com.example.uni.model.Group;
import com.example.uni.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    GroupService groupService;
    @Autowired
    GroupController(GroupService groupService){
        this.groupService=groupService;
    }
    @GetMapping
    List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }
    @GetMapping("{id}")
    Group getGroup(@PathVariable Long id){
        return groupService.getGroup(id);
    }
    @PostMapping("search")
    List<Group> searchGroups(@RequestBody Group group){
        return groupService.searchGroups(group);
    }
    @PostMapping
    Group addGroup(@RequestBody Group group){
        return groupService.addGroup(group);
    }
    @DeleteMapping("{id}")
    void deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(id);
    }
}
