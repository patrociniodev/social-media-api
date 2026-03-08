package br.com.isaacpatrocinio.social_media_api.resources;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import br.com.isaacpatrocinio.social_media_api.domain.dto.UserDTO;
import br.com.isaacpatrocinio.social_media_api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll()
    {
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = users.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(usersDTO);
    }
}
