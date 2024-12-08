package com.victor.vbill.adapter.driving.restful.login;

import com.victor.vbill.application.login.vo.LoginInputVO;
import com.victor.vbill.application.login.vo.LoginOutputVO;
import com.victor.vbill.application.login.vo.RegisterInputVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/login")
public interface LoginResource {
    @PostMapping("/")
    LoginOutputVO login(
            @RequestBody
            LoginInputVO inputVO
    );

    @PostMapping("/register")
    Boolean register(
            @RequestBody
            RegisterInputVO inputVO
    );
}
