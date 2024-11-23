package com.victor.vbill.adapter.driving.restful.login.impl;

import com.victor.vbill.adapter.driving.restful.login.LoginResource;
import com.victor.vbill.application.login.LoginService;
import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import jakarta.annotation.Resource;

public class LoginResourceImpl implements LoginResource {
    @Resource
    LoginService loginService;

    @Override
    public LoginOutputVO updateBuildInfo(LoginInputVO buildVO) {
        return loginService.login(buildVO);
    }
}
