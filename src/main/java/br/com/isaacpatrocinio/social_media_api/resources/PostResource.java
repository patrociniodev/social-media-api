package br.com.isaacpatrocinio.social_media_api.resources;

import br.com.isaacpatrocinio.social_media_api.domain.Post;
import br.com.isaacpatrocinio.social_media_api.resources.util.URL;
import br.com.isaacpatrocinio.social_media_api.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
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

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String url
    ) {
        String decodedText = URL.decodeParam(url);
        List<Post> postList = postService.findByTitle(decodedText);
        return ResponseEntity.ok().body(postList);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String urlText,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        String decodedText = URL.decodeParam(urlText);
        Date convertedMinDate = URL.convertDate(minDate, new Date(0L));
        Date convertedMaxDate = URL.convertDate(maxDate, new Date());
        List<Post> postList = postService.fullSearch(decodedText, convertedMinDate, convertedMaxDate);

        return ResponseEntity.ok().body(postList);
    }
}
