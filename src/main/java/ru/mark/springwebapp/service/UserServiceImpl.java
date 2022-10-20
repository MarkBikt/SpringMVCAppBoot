package ru.mark.springwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mark.springwebapp.models.User;
import ru.mark.springwebapp.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User newUser) {
        newUser.setId(id);
        userRepository.save(newUser);
    }

    @Override
    @Transactional
    public void delete(int id) { userRepository.deleteById(id); }
}
