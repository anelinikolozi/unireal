package com.example.uni.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "students")
@SequenceGenerator(sequenceName = "students_id_seq" ,name ="stud_seq",allocationSize = 1)
public class Student {
    @Id
    @GeneratedValue(generator = "stud_seq",strategy = GenerationType.AUTO)
    Long id;
    @Column(name ="first_name")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column(name = "personal_number")
    String personalNo;
    String email;
    @Column(name = "birth_date")
    LocalDate birthDate;
    @Column(name="group_id" )
    Long groupId;
//    @ManyToOne
//    Group group;
}
