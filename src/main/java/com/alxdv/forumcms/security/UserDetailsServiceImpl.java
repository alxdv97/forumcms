package com.alxdv.forumcms.security;

import com.alxdv.forumcms.dao.UserDao;
import com.alxdv.forumcms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
    public class UserDetailsServiceImpl implements UserDetailsService
{
    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        final User user = userDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " doesn't exist"));

        return SecurityUser.fromUser(user);
    }
}
