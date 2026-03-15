package br.com.isaacpatrocinio.social_media_api.config;

import br.com.isaacpatrocinio.social_media_api.domain.Post;
import br.com.isaacpatrocinio.social_media_api.domain.User;
import br.com.isaacpatrocinio.social_media_api.repositories.PostRepository;
import br.com.isaacpatrocinio.social_media_api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "joão", "joão@gmail.com");
        User user2 = new User(null, "maria", "maria@gmail.com");
        User user3 = new User(null, "cristiano", "cr7@global.com");
        List<User> users = Arrays.asList(user1, user2, user3);
        userRepository.saveAll(users);

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", user1);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", user1);
        List<Post> posts = Arrays.asList(post1, post2);
        postRepository.saveAll(posts);
    }
}
