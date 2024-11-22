package com.victor.vbill.application.login.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录服务的输出
 *
 * @date 2024/11/22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginOutputVO {
    private Boolean ok;
    private String token;
}
