package com.fryzjerappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private long clients_id; // bez settera (konstruktora), tym zarzadza JPA (wlasnie dzieki adnotacja)
    private String name;
    private String lastName;
    private String password;
    private String email;
    @OneToOne(mappedBy = "client")
    private Worker workers;

    Client() {
    } // jpa

    public Client(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return clients_id;
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
        return "Client{" +
                "id=" + clients_id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
