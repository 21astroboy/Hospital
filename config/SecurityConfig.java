package com.example.hospital.config;

import com.example.hospital.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authenticationManager(authManager(http))
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login").not().fullyAuthenticated()
                .antMatchers("resources/**").permitAll
                .antMatchers("test/create").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .failureUrl("/login?auth=failed")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return
                http.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(userServiceImpl)
                        .passwordEncoder(passwordEncoder)
                        .and()
                        .build();
    }
}
