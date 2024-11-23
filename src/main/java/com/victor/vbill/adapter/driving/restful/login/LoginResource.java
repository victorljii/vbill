package com.victor.vbill.adapter.driving.restful.login;

import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/login")
public interface LoginResource {
    @PostMapping("/")
    LoginOutputVO updateBuildInfo(
            @RequestAttribute
            LoginInputVO buildVO
    );
}
