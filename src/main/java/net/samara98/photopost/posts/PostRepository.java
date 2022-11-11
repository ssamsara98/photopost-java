package net.samara98.photopost.posts;

import net.samara98.photopost.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            value = "SELECT * FROM Post p",
            nativeQuery = true
    )
    List<Post> getPostListQuery();

    @Query(
            value = "SELECT * FROM Post p " +
                    "WHERE p.id = :postId",
            nativeQuery = true
    )
    Optional<Post> getPostQuery(@Param("postId") Long postId);

//    @Modifying(clearAutomatically = true)
//    @Query(
//            value = "INSERT INTO Post(caption) VALUES (:caption)",
//            nativeQuery = true
//    )
//    void createPostQuery(@Param("caption") String caption);

    @Query(
            value = "DELETE FROM Post p WHERE p.id = :postId",
            nativeQuery = true
    )
    Optional<Post> deletePostQuery(@Param("postId") Long postId);
}
