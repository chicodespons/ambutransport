package com.chicodespons.ambutransport.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @SequenceGenerator(name="user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<UserRole> userRoles;

    public User(String firstName, String lastName, String email, List<UserRole> userRoles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRoles = userRoles;
    }

    public User() {
    }
}
