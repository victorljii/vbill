package com.victor.vbill.adapter.driving.restful.login.impl;

import com.victor.vbill.adapter.driving.restful.login.LoginResource;
import com.victor.vbill.application.login.LoginService;
import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import com.victor.vbill.application.login.vo.RegisterInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResourceImpl implements LoginResource {
    private final LoginService loginService;

    @Autowired
    public LoginResourceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public LoginOutputVO login(LoginInputVO inputVO) {
        return loginService.login(inputVO);
    }

    @Override
    public Boolean register(RegisterInputVO inputVO) {

    }
}
