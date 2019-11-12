package com.tuto.vle.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.tuto.vle.filter.AddResponseHeaderFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/configuration/ui", "/swagger-ui.html", "/v2/api-docs",
        "/webjars/**", "/swagger-resources/**", "/configuration/security", "/auth/register",
        "/auth/login");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers("/auth/**").permitAll().and().httpBasic()
        .and().authorizeRequests().anyRequest().authenticated().and()
        .addFilterBefore(new AddResponseHeaderFilter(), BasicAuthenticationFilter.class);
  }

  @Autowired
  DataSource dataSource;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
        .authoritiesByUsernameQuery(
            "select api_token_id, api_role from api_keys where api_token_id=?")
        .usersByUsernameQuery(
            "select api_token_id, api_token, 1 as enabled  from api_keys where api_token_id=?");
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
