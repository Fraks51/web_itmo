package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmo.wp.domain.Comment;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.security.Guest;
import ru.itmo.wp.service.CommentService;
import ru.itmo.wp.service.PostService;
import ru.itmo.wp.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostPage extends Page {
    private PostService postService;
    private CommentService commentService;
    private UserService userService;

    PostPage(PostService postService, CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }

    @Guest
    @GetMapping("/post/{id}")
    public String getPost(@PathVariable String id, Model model, HttpSession httpSession) {
        long longID = 1;
        try {
            longID = Long.parseLong(id);
        } catch (Exception e) {
            // no Operation
        }
        Post post = postService.findById(longID);
        if (post != null) post.reverseComments();
        model.addAttribute("thisPost", post);
        model.addAttribute("comment", new Comment());
        return "PostPage";
    }

    @PostMapping("/post/{id}")
    public String writeComment(@PathVariable long id,
                               @Valid @ModelAttribute("comment") Comment comment,
                               BindingResult bindingResult,
                               HttpSession httpSession,
                               Model model)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("thisPost", postService.findById(id));
            return "PostPage";
        }
        comment.setPost(postService.findById(id));
        comment.setUser(postService.findById(id).getUser());
        putMessage(httpSession, "Comment was written");
        commentService.write(comment);
        return "redirect:/post/" + Long.toString(id);
    }
}
