package br.com.isaacpatrocinio.social_media_api.services;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import br.com.isaacpatrocinio.social_media_api.domain.dto.UserDTO;
import br.com.isaacpatrocinio.social_media_api.repositories.UserRepository;
import br.com.isaacpatrocinio.social_media_api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository db;

    public UserService(UserRepository userRepository) {
        this.db = userRepository;
    }

    public List<User> findAll() {
        return db.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = db.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public User insert(User obj) {
        return db.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
