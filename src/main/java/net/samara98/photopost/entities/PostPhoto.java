package net.samara98.photopost.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Table
@Entity
public class PostPhoto {
    @Id
    @SequenceGenerator(
            name = "post_photo_sequence",
            sequenceName = "post_photo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "post_photo_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(columnDefinition="TEXT")
    private String url;

    @OneToMany(mappedBy = "photo")
    Set<PostToPhoto> posts;

    public PostPhoto() {
    }

    public PostPhoto(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Set<PostToPhoto> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<PostToPhoto> posts) {
//        this.posts = posts;
//    }
}
