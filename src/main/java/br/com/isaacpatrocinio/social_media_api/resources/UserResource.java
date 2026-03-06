package br.com.isaacpatrocinio.social_media_api.resources;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User(1, "João", "joao@gmail.com");
        User user2 = new User(2, "Maria", "maria@hotmail.com");
        User user3 = new User(3, "Fernanda", "fernanda@hotmail.com");

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3));

        return ResponseEntity.ok().body(users);
    }
}
