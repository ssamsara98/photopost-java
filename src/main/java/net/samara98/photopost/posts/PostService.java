package net.samara98.photopost.posts;

import net.samara98.photopost.entities.Post;
import net.samara98.photopost.entities.PostPhoto;
import net.samara98.photopost.entities.PostToPhoto;
import net.samara98.photopost.posts.dto.CreatePostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostPhotoRepository postPhotoRepository;

    @Autowired
    private PostToPhotoRepository postToPhotoRepository;

    public List<Post> getPostList() {
        return this.postRepository.getPostListQuery();
    }

    public Optional<Post> getPost(Long postId) {
        return this.postRepository.getPostQuery(postId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Post> createPost(CreatePostDto body) {
        List<PostPhoto> postPhotos = body.getUrls().stream().map(url -> this.postPhotoRepository.save(new PostPhoto(url))).collect(Collectors.toList());
        Post post = this.postRepository.save(new Post(body.getCaption()));

        AtomicInteger idx = new AtomicInteger(0);
        postPhotos.stream().forEach((postPhoto) -> {
            PostToPhoto postToPhoto = new PostToPhoto(post, postPhoto, Integer.valueOf(idx.get()));
            this.postToPhotoRepository.save(postToPhoto);
            idx.getAndIncrement();
        });

        return this.postRepository.findById(post.getId());
    }

    public void deletePost(Long postId) {
        this.postRepository.deletePostQuery(postId);
    }
}
