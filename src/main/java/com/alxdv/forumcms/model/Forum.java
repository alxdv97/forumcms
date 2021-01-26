package com.alxdv.forumcms.model;

import lombok.Data;

import java.util.List;

@Data
public class Forum
{
    private Long id;

    private String logo;

    private String name;

    private String domain;

    private List<String> sections; //TODO replace String for Section;
}
