package com.victor.vbill.application.login.impl;

import com.victor.vbill.adapter.driven.persistence.login.UserDao;
import com.victor.vbill.domain.login.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 实现 UserDetailsService
 *
 * @date 2024/11/21
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("load user by username {}", username);
        User user = userDao.findFirstByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return user;
    }
}
