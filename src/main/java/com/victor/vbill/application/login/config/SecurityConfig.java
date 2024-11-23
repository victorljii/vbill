package com.victor.vbill.application.login.config;

import com.victor.vbill.application.login.impl.Sha256PasswordEncoder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * spring security 配置类
 *
 * @date 2024/11/21
 */
@Configurable
@EnableWebSecurity
public class SecurityConfig {
    /**
     * 配置密码明文加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Sha256PasswordEncoder();
    }

    /**
     * 认证管理器.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.authorizeHttpRequests((auth) -> {
                    auth.requestMatchers("/user/public/.*").permitAll()
                            .anyRequest().authenticated();
                })
                .build();
    }
}
