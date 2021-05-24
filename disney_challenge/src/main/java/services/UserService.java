package services;

import models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserEntity> getUsers() {
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity usuario) {
        return userRepository.save(usuario);
    }
}
