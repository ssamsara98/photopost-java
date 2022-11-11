package net.samara98.photopost.posts.dto;

import java.util.List;

public class CreatePostDto {
    private List<String> urls;

    private String caption;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
