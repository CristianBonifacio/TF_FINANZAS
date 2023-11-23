package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Column (name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Column (name = "password", nullable = false, length = 50)
    private String password;
    @Column (name = "dni", nullable = false, length = 50)
    private String dni;
    @Column (name = "confirmPassword", nullable = false, length = 50)
    private String confirmPassword;
}
