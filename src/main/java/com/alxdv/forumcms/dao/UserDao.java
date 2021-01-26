package com.alxdv.forumcms.dao;

import com.alxdv.forumcms.model.Role;
import com.alxdv.forumcms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long>
{
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByRole(Role role);
}
