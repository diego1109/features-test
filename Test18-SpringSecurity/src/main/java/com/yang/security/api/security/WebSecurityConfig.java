package com.yang.security.api.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  /**
   * 主要作用：授权每个url的请求权限。
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/hello").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin().permitAll().defaultSuccessUrl("/hello")
        .and()
        .logout().permitAll();

  }


  /**
   * 主要作用：用来做用户认证的，使用基于内存的用户存储。
   *
   * @param auth
   * @throws Exception
   */
    @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
    auth
        .inMemoryAuthentication()
        .withUser("admin").password("123").roles("USER")
        .and()
        .passwordEncoder(new CustomPasswordEncoder());
  }
}
