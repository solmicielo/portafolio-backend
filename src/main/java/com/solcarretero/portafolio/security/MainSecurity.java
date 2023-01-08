
package com.solcarretero.portafolio.security;

import com.solcarretero.portafolio.security.jwt.JwtEntryPoint;
import com.solcarretero.portafolio.security.jwt.JwtTokenFilter;
import com.solcarretero.portafolio.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity implements WebMvcConfigurer{

@Autowired
UserDetailsServiceImpl userDetailsImplements;

@Autowired
JwtEntryPoint jwtEntryPoint;

@Bean
public JwtTokenFilter jwtTokenFilter() {
return new JwtTokenFilter();
}

@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
return authenticationConfiguration.getAuthenticationManager();
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http.cors().and().csrf().disable()
.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
.and()
.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
.and()
.authorizeHttpRequests()
.antMatchers("**").permitAll()
.anyRequest().authenticated();

http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

return http.build();
}

@Override
public void addCorsMappings(CorsRegistry registry) {

registry.addMapping("auth/login").allowedOrigins("http://localhost:4200/").allowedMethods("*").exposedHeaders("*");

}
 
}


