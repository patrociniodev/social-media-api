package br.com.isaacpatrocinio.social_media_api.services;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import br.com.isaacpatrocinio.social_media_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository db;

    public UserService(UserRepository userRepository) {
        this.db = userRepository;
    }

    public List<User> findAll() {
        return db.findAll();
    }
}
