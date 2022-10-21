package ru.mark.springwebapp.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name not null")
    @Size(min = 1, max = 30, message = "Name between 1 or 30")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Surname not null")
    @Size(min = 1, max = 30, message = "Surname between 1 or 30")
    @Column(name = "surname")
    private String surname;

    public User() {

    }
    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
