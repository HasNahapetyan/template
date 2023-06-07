package com.example.example.security;

import com.example.example.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;


public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;
    public CurrentUser(User user /*mer unecac entity usern e*/) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()/*useri role-n e*/));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
