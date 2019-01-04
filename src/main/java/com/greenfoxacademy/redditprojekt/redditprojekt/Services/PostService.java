package com.greenfoxacademy.redditprojekt.redditprojekt.Services;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.Post;
import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.User;
import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.PostRepository;
import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository,UserService userService, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    public User findCurrentUser() {
//        return userService.getCurrentUser();
//    }

    public void save(Post post) {
        post.setUser(userService.getCurrentUser());
        postRepository.save(post);
    }

    public Post findByID(Long id) {
        if (postRepository.findById(id).isPresent()) {
            return postRepository.findById(id).get();
        }
        return null;
    }

    public Iterable<Post> findAllOrderByScore() {
        return postRepository.findAllByOrderByScoreDesc();
    }

    public void upVote(Long id) {
        if (postRepository.findById(id).isPresent()) {
            Post tempPost = postRepository.findById(id).get();
            Long tempVote = tempPost.getScore();
            tempVote++;
            tempPost.setScore(tempVote);
            postRepository.save(tempPost);
        }
    }

    public void downVote(Long id) {
        if (postRepository.findById(id).isPresent()) {
            Post tempPost = postRepository.findById(id).get();
            Long tempVote = tempPost.getScore();
            tempVote--;
            tempPost.setScore(tempVote);
            postRepository.save(tempPost);
        }
    }
}
