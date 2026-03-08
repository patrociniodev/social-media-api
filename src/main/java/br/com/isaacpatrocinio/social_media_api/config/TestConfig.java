package br.com.isaacpatrocinio.social_media_api.config;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import br.com.isaacpatrocinio.social_media_api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    public TestConfig(UserRepository repos) {
        userRepository = repos;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        users = Arrays.asList(new User("1", "joão","joão@gmail.com"), new User("2", "maria", "maria@gmail.com"), new User("3", "cristiano", "cr7@global.com"));

        userRepository.saveAll(users);
    }
}
