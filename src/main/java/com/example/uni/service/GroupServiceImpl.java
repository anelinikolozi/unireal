package com.example.uni.service;

import com.example.uni.model.Group;
import com.example.uni.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    GroupRepository groupRepository;
    @Autowired
    GroupServiceImpl(GroupRepository groupRepository){
        this.groupRepository=groupRepository;

    }
    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroup(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {

        groupRepository.delete(getGroup(id));
    }

    @Override
    public List<Group> searchGroups(Group group) {
        return groupRepository.findAll(((root, query, cb) -> {
            Predicate predicate=cb.conjunction();
            if(group.getTitle()!=null){
                predicate=cb.and(predicate,cb.like(root.get("title"),"%".concat(group.getTitle().concat("%"))));
            }
            if(group.getGroupNo()!=null){
                predicate=cb.and(predicate,cb.equal(root.get("groupNo"),group.getGroupNo()));
            }

            return predicate;



        }));
    }
}
