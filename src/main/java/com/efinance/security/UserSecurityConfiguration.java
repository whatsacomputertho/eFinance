package com.efinance.security;

import com.efinance.service.CustomUserDetailsService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter 
{
    @Autowired
    DataSource dataSource;
    
    @Bean
    public UserDetailsService userDetailsService()
    {
        return new CustomUserDetailsService();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        dap.setUserDetailsService(userDetailsService());
        return dap;
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/validate").permitAll()
            .antMatchers("/verify").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/resources/static/style.css").permitAll()
            .and().authorizeRequests()
            .antMatchers("/review-loan/*").hasAuthority("LOANOFFICER")
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").loginProcessingUrl("/validate").usernameParameter("email").passwordParameter("userpass").defaultSuccessUrl("/home")
            .and().logout().logoutSuccessUrl("/").permitAll();
        http.csrf().disable();
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select email,userpass,enabled from user where email = ?").authoritiesByUsernameQuery("select email,usertype from user where email = ?");
    }
}