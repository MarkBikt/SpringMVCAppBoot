package ru.mark.springwebapp.service;

import ru.mark.springwebapp.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User newUser);
    void delete(int id);
}
