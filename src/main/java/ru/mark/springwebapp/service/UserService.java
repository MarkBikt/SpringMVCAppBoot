package ru.mark.springwebapp.service;

import ru.mark.springwebapp.models.User;

import java.util.List;

public interface UserService {
    public List<User> index();
    public User show(int id);
    public void save(User user);
    public void update(int id, User newUser);
    public void delete(int id);
}
