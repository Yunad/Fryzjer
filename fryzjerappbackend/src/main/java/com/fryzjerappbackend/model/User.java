package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", updatable = false, nullable = false)
    private Long userId; // bez settera (konstruktora), tym zarzadza JPA (wlasnie dzieki anotacja)
    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name")
    private String name;
    @NotNull
    @NotEmpty(message = "Lastname cannot be empty")
    @Column(name = "lastName")
    private String lastName;
    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;
    @NotNull
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email")
    private String email;
    @Column(name = "roleId")
    private Long roleId;

    @OneToMany(mappedBy = "user")
    Set<UserServicesRelation> userServices;

    @OneToMany(mappedBy = "user")
    Set<UserAppointment> userAppointments;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public User() {
    } // jpa

    public User(@NotNull @NotEmpty(message = "Name cannot be empty") String name, @NotNull @NotEmpty(message = "Lastname cannot be empty") String lastName, @NotNull @NotEmpty(message = "Password cannot be empty") String password, @NotNull @NotEmpty(message = "Email cannot be empty") String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
