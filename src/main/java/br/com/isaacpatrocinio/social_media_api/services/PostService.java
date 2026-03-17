package br.com.isaacpatrocinio.social_media_api.services;

import br.com.isaacpatrocinio.social_media_api.domain.Post;
import br.com.isaacpatrocinio.social_media_api.repositories.PostRepository;
import br.com.isaacpatrocinio.social_media_api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository db;

    public PostService(PostRepository postRepository) {
        db = postRepository;
    }

    public List<Post> findAll() {
        return db.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = db.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public List<Post> findByTitle(String title) {
        return db.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return db.fullSearch(text, minDate, maxDate);
    }
}
