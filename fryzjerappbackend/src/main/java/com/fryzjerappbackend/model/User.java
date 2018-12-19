package com.fryzjerappbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "clients")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long users_id; // bez settera (konstruktora), tym zarzadza JPA (wlasnie dzieki adnotacja)
    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull
    @NotEmpty(message = "Lastname cannot be empty")
    private String lastName;
    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotNull
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @OneToOne(mappedBy = "user")
    private Worker workers;


    User() {
    } // jpa

    public User(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return users_id;
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
                "id=" + users_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
