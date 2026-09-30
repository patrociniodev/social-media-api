package br.com.isaacpatrocinio.social_media_api.domain.dto;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;
    
    public UserDTO(User object) {
        this.id = object.getId();
        this.name = object.getName();
        this.email = object.getEmail();
    }
}
