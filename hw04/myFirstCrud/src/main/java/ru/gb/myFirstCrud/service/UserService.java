package ru.gb.myFirstCrud.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.myFirstCrud.model.User;
import ru.gb.myFirstCrud.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }


}
