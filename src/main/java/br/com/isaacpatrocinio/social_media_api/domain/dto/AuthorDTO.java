package br.com.isaacpatrocinio.social_media_api.domain.dto;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }
}
