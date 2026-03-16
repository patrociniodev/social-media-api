package br.com.isaacpatrocinio.social_media_api.resources;

import br.com.isaacpatrocinio.social_media_api.domain.Post;
import br.com.isaacpatrocinio.social_media_api.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService service) {
        postService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
