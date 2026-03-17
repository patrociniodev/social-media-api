package br.com.isaacpatrocinio.social_media_api.repositories;

import br.com.isaacpatrocinio.social_media_api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String title);
}
