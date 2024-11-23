package com.victor.vbill.application.login.impl;

import com.victor.vbill.application.login.LoginService;
import com.victor.vbill.application.login.utils.JwtUtils;
import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import com.victor.vbill.domain.login.User;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * 登录服务实现
 *
 * @date 2024/11/22
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public LoginOutputVO login(LoginInputVO loginInputVO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginInputVO.getUsername(), loginInputVO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (authenticate == null) {
            throw new RuntimeException("Authentication failed");
        }

        User user = (User) authenticate.getPrincipal();
        String token = JwtUtils.generateToken(user.getUsername());

        return LoginOutputVO.builder()
                .ok(authenticate.isAuthenticated())
                .token(token)
                .build();
    }
}
