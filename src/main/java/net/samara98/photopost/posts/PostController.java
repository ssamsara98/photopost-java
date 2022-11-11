package net.samara98.photopost.posts;

import net.samara98.photopost.entities.Post;
import net.samara98.photopost.posts.dto.CreatePostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "posts")
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getPostList() {
        return this.postService.getPostList();
    }

    @GetMapping("/{postId}")
    public Optional<Post> getPost(@PathVariable("postId") Long postId) {
//        this.logger.info(postId.toString());
        return this.postService.getPost(postId);
    }

    @PostMapping()
    public Optional<Post> createPost(@RequestBody CreatePostDto body) {
        return this.postService.createPost(body);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        this.postService.deletePost(postId);
    }
}
