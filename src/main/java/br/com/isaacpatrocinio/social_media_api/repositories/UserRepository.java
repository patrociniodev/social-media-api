package br.com.isaacpatrocinio.social_media_api.repositories;

import br.com.isaacpatrocinio.social_media_api.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
