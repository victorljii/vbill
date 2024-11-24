package com.victor.vbill.application.login.config;

import com.victor.vbill.application.login.impl.Sha256PasswordEncoder;
import com.victor.vbill.application.login.impl.VbillAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * spring security 配置类
 *
 * @date 2024/11/21
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    /**
     * 配置密码明文加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Sha256PasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new VbillAuthenticationProvider();
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
        httpSecurity
                // 禁用 csrf 防护
                .csrf(CsrfConfigurer::disable)
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(customizer -> {
                    customizer
                            // 放行登陆和注册接口
                            .requestMatchers("/user/login/", "/user/login/register").permitAll()
                            // 其他接口需要校验
                            .anyRequest().authenticated();
                })
                // 禁用缓存
                .headers(customizer -> customizer.cacheControl(HeadersConfigurer.CacheControlConfig::disable))
                .authenticationProvider(authenticationProvider());

        return httpSecurity.build();
    }
}
