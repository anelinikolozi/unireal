package com.example.uni.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "teachers")

@SequenceGenerator(sequenceName = "teachers_id_seq" ,name ="teach_seq",allocationSize = 1)
public class Teacher {
    @Id
    @GeneratedValue(generator = "teach_seq",strategy = GenerationType.AUTO)
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
}
