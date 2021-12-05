package com.example.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class EazyBankConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                        .antMatchers("/myBalance").authenticated()
                        .antMatchers("/myLoans").authenticated()
                        .antMatchers("/myCards").authenticated()
                        .antMatchers("/myAccount").authenticated()
                        .antMatchers("/notices").permitAll()
                         .antMatchers("/contact").permitAll()
                        .and().formLogin();
        http.httpBasic();

//        /* Code to deny all incoming requests */
//        http.authorizeRequests().anyRequest().denyAll()
//                .and().formLogin();
//        http.httpBasic();

//        /* Code to permit all incoming requests */
//        http.authorizeRequests().anyRequest().permitAll()
//                .and().formLogin();
//        http.httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("1234").authorities("admin").and()
//                .withUser("user").password("1234").authorities("read").and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("admin").password("1234").authorities("admin").build();
        UserDetails user1 = User.withUsername("user").password("1234").authorities("read").build();
        userDetailsService.createUser(user);
        userDetailsService.createUser(user1);
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
