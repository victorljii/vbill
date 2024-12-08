package com.victor.vbill.application.login;

import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import org.springframework.stereotype.Service;

/**
 * 登录服务接口
 */
public interface LoginService {
    LoginOutputVO login(LoginInputVO loginInputVO);
}
