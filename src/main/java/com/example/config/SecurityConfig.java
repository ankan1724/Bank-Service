package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/users/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/customer/**").authenticated()
                .antMatchers("/cards/**").authenticated()
                .and()
                .formLogin().and().httpBasic();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
/*
 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user1= User.withUsername("ankan").password("ankan").authorities("admin").build();
        userDetailsManager.createUser(user1);
        auth.userDetailsService(userDetailsManager);
    }*/
/*@Autowire
public  DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService( DataSource dataSource)   {
        return new JdbcUserDetailsManager(dataSource);
    }*/

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }*/

}