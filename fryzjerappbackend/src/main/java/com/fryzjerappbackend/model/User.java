package com.fryzjerappbackend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class User {

    @Id
    @GeneratedValue
    private long users_id; // bez settera (konstruktora), tym zarzadza JPA (wlasnie dzieki adnotacja)
    private String name;
    private String lastName;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY
            , cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="users_reservations",
    joinColumns = {@JoinColumn(name = "reservations_id")},
    inverseJoinColumns = {@JoinColumn(name = "users_id")})
    private Set<Reservation> reservations = new HashSet<>();

    User() {
    } // jpa

    public User(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public long getId() {
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
