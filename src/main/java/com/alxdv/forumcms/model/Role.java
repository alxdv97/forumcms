package com.alxdv.forumcms.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role
{
    USER(Set.of(Permission.FORUM_READ)),
    ADMIN(Set.of(Permission.FORUM_READ, Permission.FORUM_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions)
    {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions()
    {
        return permissions;
    }

    // create mapping between Permission and SimpleGrantedAuthority
    public Set<SimpleGrantedAuthority> getAuthorities()
    {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
