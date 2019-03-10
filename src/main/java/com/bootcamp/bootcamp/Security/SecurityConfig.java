package com.bootcamp.bootcamp.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //kazde żądanie
                    //.antMatchers("/").permitAll() //sprawdza jaki dostęp. / to strona główna
                    //.anyRequest().authenticated() //inne - wymaga logowania
                    .antMatchers("/admin/*", "/admin").authenticated()
                    .anyRequest().permitAll()
                .and() //pozwala mo pójśc dalej, pisać dodatkowe.
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                .and()
                .formLogin();
    } }
