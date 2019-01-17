package com.fryzjerappbackend.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AppConf extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LogManager.getLogger(AppConf.class);

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.authorizeRequests().antMatchers("/", "/login", "/logout", "/service/get", "/user/get/role/*", "/user/get/email/*")
                .permitAll()
                .and()
                .csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .logout();

        http.authorizeRequests().antMatchers("/user/get/all").hasRole("USER")
                .anyRequest().authenticated()
                .and().httpBasic().authenticationEntryPoint(authEntryPoint);

        http.csrf().disable().authorizeRequests();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("john123").password(bCryptPasswordEncoder().encode("password")).roles("USER");
    }
}
