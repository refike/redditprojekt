package com.greenfoxacademy.redditprojekt.redditprojekt.Controllers;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.Post;
import com.greenfoxacademy.redditprojekt.redditprojekt.Services.PostService;
import com.greenfoxacademy.redditprojekt.redditprojekt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService =  userService;
    }

    @GetMapping({"", "/"})
    public String list(Model model, @RequestParam(name = "content", required = false) Long id) {
        if (id != null)
            // model.addAttribute("user",postService.findCurrentUser());

            model.addAttribute("content", postService.findByID(id));
            model.addAttribute("posts", postService.findAllOrderByScore());
            return "redditpost";
    }

    @GetMapping("/submit")
    public String addPost(Model model) {

        model.addAttribute("submitPost", new Post());
        return "submitPost";
    }

    @PostMapping("/submit")
    public String submitPost(@ModelAttribute(name = "submitPost") Post post) {
        post.setUser(userService.getCurrentUser());
        System.out.println(userService.getCurrentUser().getName());
        postService.save(post);
        return "redirect:/post";
    }

    @GetMapping("/{id}/upvote")
    public String upVote(@PathVariable Long id) {
        postService.upVote(id);
        return "redirect:/post";
    }

    @GetMapping("/{id}/downvote")
    public String downVote(@PathVariable Long id) {
        postService.downVote(id);
        return "redirect:/post";
    }

}
