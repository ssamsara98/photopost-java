package net.samara98.photopost.posts;

import net.samara98.photopost.entities.PostToPhoto;
import net.samara98.photopost.entities.PostToPhotoKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostToPhotoRepository extends JpaRepository<PostToPhoto, PostToPhotoKey> {
}
