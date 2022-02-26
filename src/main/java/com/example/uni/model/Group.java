package com.example.uni.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
@SequenceGenerator(sequenceName = "groups_id_seq", name = "group_seq",allocationSize = 1)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "group_seq")
    Long id;
    String title;
    @Column(name = "group_no")
    Integer groupNo;

//    @OneToMany
//    List<Student> student;
}
