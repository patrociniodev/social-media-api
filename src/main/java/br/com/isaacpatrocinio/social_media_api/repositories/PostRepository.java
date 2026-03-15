package br.com.isaacpatrocinio.social_media_api.repositories;

import br.com.isaacpatrocinio.social_media_api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
