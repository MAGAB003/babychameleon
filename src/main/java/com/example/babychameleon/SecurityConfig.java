package com.example.babychameleon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

 @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/", "/aboutservice", "/subscriptiondetails", "/subscriptions", "/checkout", "/init", "/index", "../resources/static/css/*.css", "/h2", "/h2/**", "/addnewcustomer").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll();
            http.csrf().disable();
            http.headers().frameOptions().disable();

        }
     @Override
     public void configure(WebSecurity web) throws Exception {
         web
                 .ignoring()
                 .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
     }

     @Bean
        public UserDetailsService userDetailsService() {
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles
                    ("USER").build());
            manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("123").roles("USER","ADMIN").build());
            return manager;
        }
     @Autowired
     private SecurityUserDetailsService userDetailsService;
     // configure the authentication provider - the one we declare in the next method
     @Override
     protected void configure(AuthenticationManagerBuilder auth)
             throws Exception {
         auth.authenticationProvider(authenticationProvider());
     }
     // sets the object userDetailsService as the UserDetailsService in Spring Security, and sets the encoder (the same one that the InitController uses)
     @Bean
     public DaoAuthenticationProvider authenticationProvider() {
         DaoAuthenticationProvider authProvider
                 = new DaoAuthenticationProvider();
         authProvider.setUserDetailsService(userDetailsService);
         authProvider.setPasswordEncoder(encoder());
         return authProvider;
     }
     // makes it possible to get the encoder autowired in InitController (to be able to encode the password when saving the user
     @Bean
     public PasswordEncoder encoder() {
         return new BCryptPasswordEncoder(11);
     }
 }
