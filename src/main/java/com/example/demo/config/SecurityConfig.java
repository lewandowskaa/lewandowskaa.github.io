package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


//Spring security klasa odpowiedzialana za konfiguracje procesów autoryzacji użytkownika.
// wykorzystuje specjalnie zdefiniowany filter,w którym ściśle określamy warunki logowania "CustomFilter"

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired//zdefiniowany w pakiecie org.springframework.bean.factory, który jest częścią Spring framework.
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) {
    }

    @Override//używana do oznaczania implementacji metod z interfejsów
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/console/**").permitAll()
                .and()
                .addFilterBefore(new CustomFilter(), BasicAuthenticationFilter.class);


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}