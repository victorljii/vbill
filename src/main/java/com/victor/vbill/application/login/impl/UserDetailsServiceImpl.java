package com.victor.vbill.application.login.impl;

import com.victor.vbill.adapter.driven.persistence.login.UserDao;
import com.victor.vbill.domain.login.User;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 实现 UserDetailsService
 *
 * @date 2024/11/21
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findFirstByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return user;
    }
}
