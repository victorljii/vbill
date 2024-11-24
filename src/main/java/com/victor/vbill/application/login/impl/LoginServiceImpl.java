package com.victor.vbill.application.login.impl;

import com.victor.vbill.application.login.LoginService;
import com.victor.vbill.application.login.utils.JwtUtils;
import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import com.victor.vbill.domain.login.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * 登录服务实现
 *
 * @date 2024/11/22
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public LoginOutputVO login(LoginInputVO loginInputVO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginInputVO.getUsername(), loginInputVO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (authenticate == null) {
            throw new RuntimeException("Authentication failed");
        }

        String token = JwtUtils.generateToken(loginInputVO.getUsername());

        return LoginOutputVO.builder()
                .ok(true)
                .token(token)
                .build();
    }
}
