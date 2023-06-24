package com.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//                auth
//                .inMemoryAuthentication()
//                .withUser("broekhuis").password(passwordEncoder().encode("broekhuis")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER","ADMIN");
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.builder()
                        .username("johnGM@molveno.com")
                        .password(passwordEncoder().encode("johnGM"))
                        .roles("GM")
                        .build();
        UserDetails user2 =
                User.builder()
                        .username("michelRM@molveno.com")
                        .password(passwordEncoder().encode("michelRM"))
                        .roles("GM")
                        .build();
        UserDetails user3 =
                User.builder()
                        .username("chefBob@molveno.com")
                        .password(passwordEncoder().encode("chefBob"))
                        .roles("CHEF")
                        .build();
        UserDetails user4 =
                User.builder()
                        .username("chefTom@molveno.com")
                        .password(passwordEncoder().encode("chefTom"))
                        .roles("CHEF")
                        .build();
        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/"
                        , "/h2-console/**"
                        , "/console/**"
                        , "/js/**"
                        , "/img/**"
                        , "/lib/**"
                        , "/scss/**"
                        , "/css/**"
                        ,"/contact*"
                        ,"/reservation*"
                        ,"/about*"
                        ,"/menu*"
                        ,"/forgot*"
                        ,"/checkout"
                        ,"/dashboard*"
                        , "/api/**"
                        ,"/v3/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/webjars/**"
                ).permitAll()
                .requestMatchers( "/reservations*", "/table*").hasAnyRole("GM")
                .requestMatchers("/stock*", "/orders*").hasAnyRole("CHEF", "GM")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .permitAll()
        ;

        return http.build();

    }
}