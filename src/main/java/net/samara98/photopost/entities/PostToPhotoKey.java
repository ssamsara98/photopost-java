package net.samara98.photopost.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostToPhotoKey implements Serializable {

    @Column(name = "post_id")
    Long postId;

    @Column(name = "photo_id")
    Long photoId;

    // standard constructors, getters, and setters

    public PostToPhotoKey() {
    }

    public PostToPhotoKey(Long postId, Long photoId) {
        this.postId = postId;
        this.photoId = photoId;
    }

    // hashcode and equals implementation

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostToPhotoKey that = (PostToPhotoKey) o;
        return Objects.equals(postId, that.postId) && Objects.equals(photoId, that.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, photoId);
    }

    @Override
    public String toString() {
        return "PostToPhotoKey{" +
                "postId=" + postId +
                ", photoId=" + photoId +
                '}';
    }
}
