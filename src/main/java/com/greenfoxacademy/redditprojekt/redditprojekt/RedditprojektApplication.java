package com.greenfoxacademy.redditprojekt.redditprojekt;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.Post;
import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditprojektApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(RedditprojektApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    postRepository.save(new Post("Interesting facts","semmi"));
    postRepository.save(new Post("Super fast cars","semmi2"));
    postRepository.save(new Post("AI is here","semmi3"));
    }
}

