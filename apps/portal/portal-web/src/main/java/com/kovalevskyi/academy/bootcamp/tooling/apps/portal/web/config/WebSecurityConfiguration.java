package com.kovalevskyi.academy.bootcamp.tooling.apps.portal.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) {
    web.ignoring()
        .antMatchers("/")
        .antMatchers("/css/**", "/img/**", "/js/**", "/favicon.ico", "/**.png", "/**.svg", "/robots.txt", "/site.webmanifest");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        // .loginPage("/login")
        // .permitAll()
        .and()
        .logout()
        // .and() .exceptionHandling().accessDeniedPage("/accessDenied");
        .permitAll();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin").password("adminpass").roles("ADMIN")
    ;
  }
}
