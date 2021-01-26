package com.alxdv.forumcms.controller;

import com.alxdv.forumcms.model.Forum;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/cms")
public class CmsController
{
    @GetMapping
    @PreAuthorize("hasAuthority('forum:read')")
    public Forum getForum()
    {
        Forum tmpForum = new Forum();

        tmpForum.setLogo("/logo/path");
        tmpForum.setName("Your Forum");
        tmpForum.setDomain("your/forum");
        tmpForum.setSections(Stream.of(
                "section1",
                "section2",
                "section3"
        ).collect(Collectors.toList()));

        return tmpForum;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('forum:write')")
    public Forum createForum(@RequestBody Forum forum)
    {
        Forum savedForum = forum;

        return savedForum;
    }
}
