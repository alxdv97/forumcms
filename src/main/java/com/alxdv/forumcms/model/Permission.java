package com.alxdv.forumcms.model;

public enum Permission
{
    FORUM_READ("forum:read"),
    FORUM_WRITE("forum:write");

    private final String permission;

    Permission(String permission)
    {
        this.permission = permission;
    }

    public String getPermission()
    {
        return permission;
    }
}
