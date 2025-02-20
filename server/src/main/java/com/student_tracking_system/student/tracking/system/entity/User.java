package com.student_tracking_system.student.tracking.system.entity;

import com.student_tracking_system.student.tracking.system.entity.enums.Gender;
import com.student_tracking_system.student.tracking.system.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "identity_no",length =11,unique = true)
    private String identityNo;

    @Column
    private String name;

    @Column
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "urole")
    private Role role;
}
