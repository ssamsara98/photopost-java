package net.samara98.photopost;

import net.samara98.photopost.entities.Post;
import net.samara98.photopost.entities.PostPhoto;
import net.samara98.photopost.entities.PostToPhoto;
import net.samara98.photopost.posts.PostPhotoRepository;
import net.samara98.photopost.posts.PostRepository;
import net.samara98.photopost.posts.PostToPhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhotopostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotopostApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PostRepository postRepository, PostPhotoRepository photoRepository, PostToPhotoRepository postToPhotoRepository) {
        return args -> {
            Post post = postRepository.save(new Post("Hello, World!"));

            PostPhoto photo1 = photoRepository.save(new PostPhoto("https://instagram.fcgk33-1.fna.fbcdn.net/v/t51.2885-15/54247464_113492002968594_3240990253819192791_n.jpg?stp=dst-jpg_e35_s480x480&_nc_ht=instagram.fcgk33-1.fna.fbcdn.net&_nc_cat=106&_nc_ohc=dVOiELq0NbQAX8FYQuw&edm=ALQROFkBAAAA&ccb=7-5&ig_cache_key=MjAxMTcxNjUzODc1OTA2Mjg3NA%3D%3D.2-ccb7-5&oh=00_AfDIQp-EipRaTI1D9isSZLFtwFPU6DHfjSHDGkVjmzCWnA&oe=63718E0E&_nc_sid=30a2ef"));
            PostPhoto photo2 = photoRepository.save(new PostPhoto("https://instagram.fcgk33-1.fna.fbcdn.net/v/t51.2885-15/52713957_121230602363856_2548422794036520953_n.jpg?stp=dst-jpg_e35_s480x480&_nc_ht=instagram.fcgk33-1.fna.fbcdn.net&_nc_cat=100&_nc_ohc=F1rjiWGypucAX_w3eYq&edm=ALQROFkBAAAA&ccb=7-5&ig_cache_key=MjAwNjQ3MzQwODczNjQwNzg5NQ%3D%3D.2-ccb7-5&oh=00_AfC6RxzE7SXI1jlPiR2-QuL92js3I8ZQIsKVnEGr35iU6w&oe=6371AB97&_nc_sid=30a2ef"));
            PostPhoto photo3 = photoRepository.save(new PostPhoto("https://instagram.fcgk33-1.fna.fbcdn.net/v/t51.2885-15/53169508_346248795995929_2719057985107081589_n.jpg?stp=dst-jpg_e35_p480x480&_nc_ht=instagram.fcgk33-1.fna.fbcdn.net&_nc_cat=101&_nc_ohc=fZV9K-33WwIAX-S9bj7&edm=ALQROFkBAAAA&ccb=7-5&ig_cache_key=MjAwMzY5ODY3NzAwODMyMTc5MA%3D%3D.2-ccb7-5&oh=00_AfCGXmrJuQLDeGHwJapBWNnyboZQaLNdZSvsmYlW0K6Xmw&oe=6372FB08&_nc_sid=30a2ef"));

            postToPhotoRepository.save(new PostToPhoto(post, photo1, 0));
            postToPhotoRepository.save(new PostToPhoto(post, photo2, 1));
            postToPhotoRepository.save(new PostToPhoto(post, photo3, 2));
        };
    }
}
