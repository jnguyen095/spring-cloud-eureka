package com.nnk.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/secured/**";
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*http.requestMatchers()
                .antMatchers(SECURED_PATTERN).and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
                .anyRequest().access(SECURED_READ_SCOPE);*/
        http
                .authorizeRequests().antMatchers("/oauth/token", "/api/rest/**").permitAll();
        http
                .requestMatchers().antMatchers("/api/logon/**")
                .and().authorizeRequests().antMatchers("/api/logon/**").access("hasAuthority('LOGON')") // neu dung hasRole thi co prefix ROLE_<...>
                .and()
                .requestMatchers().antMatchers("/api/user")
                .and().authorizeRequests().antMatchers("/api/user/**").access("hasAuthority('USER')")
                .and()
                .requestMatchers().antMatchers("/api/admin")
                .and().authorizeRequests().antMatchers("/api/admin/**").access("hasAuthority('ADMIN')");

    }
}
