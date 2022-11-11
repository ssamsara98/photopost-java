package net.samara98.photopost.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity
public class PostToPhoto {
    @EmbeddedId
    private PostToPhotoKey id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Integer displayOrder;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    Post post;

    @ManyToOne
    @MapsId("photoId")
    @JoinColumn(name = "photo_id")
    PostPhoto photo;

    public PostToPhoto() {
    }

    public PostToPhoto(Post post, PostPhoto photo, Integer displayOrder) {
        this.post = post;
        this.photo = photo;
        this.displayOrder = displayOrder;
        this.id = new PostToPhotoKey(post.getId(), photo.getId());
    }


    public PostToPhotoKey getId() {
        return id;
    }

    public void setId(PostToPhotoKey id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public PostPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(PostPhoto photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "PostToPhoto{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", displayOrder=" + displayOrder +
                '}';
    }
}
