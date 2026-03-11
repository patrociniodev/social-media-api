package br.com.isaacpatrocinio.social_media_api.domain.dto;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User object) {
        this.id = object.getId();
        this.name = object.getName();
        this.email = object.getEmail();
    }

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
