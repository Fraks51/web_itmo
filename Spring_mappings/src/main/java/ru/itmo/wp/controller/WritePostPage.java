package ru.itmo.wp.controller;

import com.sun.xml.bind.v2.runtime.unmarshaller.TagName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.domain.Role;
import ru.itmo.wp.domain.Tag;
import ru.itmo.wp.form.PostCredentials;
import ru.itmo.wp.security.AnyRole;
import ru.itmo.wp.service.TagService;
import ru.itmo.wp.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WritePostPage extends Page {
    private final UserService userService;
    private final TagService tagService;

    public WritePostPage(UserService userService, TagService tagService) {
        this.userService = userService;
        this.tagService = tagService;
    }

    private List<String> toList(String tags) {
        return Arrays.stream(tags.split(" ")).filter(str -> str != " ").collect(Collectors.toList());
    }

    @AnyRole({Role.Name.WRITER, Role.Name.ADMIN})
    @GetMapping("/writePost")
    public String writePostGet(Model model) {
        model.addAttribute("postForm", new PostCredentials());
        return "WritePostPage";
    }

    @AnyRole({Role.Name.WRITER, Role.Name.ADMIN})
    @PostMapping("/writePost")
    public String writePostPost(@Valid @ModelAttribute("postForm") PostCredentials postCre,
                                BindingResult bindingResult,
                                HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "WritePostPage";
        }
        Post post = new Post();
        post.setTitle(postCre.getTitle());
        post.setText(postCre.getText());
        Set<Tag> tags = new HashSet<>();
        Set<String> tagNames = new TreeSet<>();
        if (postCre.getTags() != null) {
            for (String tagName : toList(postCre.getTags())) {
                tagNames.add(tagName);
            }
        }

        for (String tagName : tagNames) {
            Tag tag = tagService.findByName(tagName);
            tagNames.add(tagName);
            if (tag == null) {
                tag = new Tag(tagName);
                tagService.save(tag);
            }
            tags.add(tag);
        }
        post.setTags(tags);
        userService.writePost(getUser(httpSession), post);
        putMessage(httpSession, "You published new post");

        return "redirect:/posts";
    }
}
