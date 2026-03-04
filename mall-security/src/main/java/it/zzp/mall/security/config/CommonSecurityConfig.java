package it.zzp.mall.security.config;

import it.zzp.mall.security.component.*;
import it.zzp.mall.security.util.JwtTokenUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity通用配置
 * 包括通用Bean、Security通用Bean及动态权限通用Bean
 *
 */
@Configuration
public class CommonSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Deleted:@Bean
    // Deleted:public IgnoreUrlsConfig ignoreUrlsConfig() {
    // Deleted:    return new IgnoreUrlsConfig();
    // Deleted:}

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    // Deleted:@Bean
    // Deleted:public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
    // Deleted:    return new RestfulAccessDeniedHandler();
    // Deleted:}

    // Deleted:@Bean
    // Deleted:public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
    // Deleted:    return new RestAuthenticationEntryPoint();
    // Deleted:}

    // Deleted:@Bean
    // Deleted:public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
    // Deleted:    return new JwtAuthenticationTokenFilter();
    // Deleted:}


    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter(){
        return new DynamicSecurityFilter();
    }
}
