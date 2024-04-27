package ru.gb.hw07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // переопределение фильтра аутентификации, какие ресурсы доступны в зависимости от роли пользователя
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/private-data").hasAnyRole("ADMIN")
                        .requestMatchers("/public-data").hasAnyRole("USER")
                        .requestMatchers("/css/**", "/favicon.ico", "/", "/index", "/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/"));

        return http.build();
    }

    // переопределение колировщика паролей, BCrypt & SCrypt
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // сохранение в памяти нескольких клиентов с их ролями, в зависимости от которых будут доступны ресурсы
    @Bean
    UserDetailsManager inMemoryUserDetailsManager() {
        var user1 = User.withUsername("user").password("{noop}password").roles("USER").build();
        var user2 = User.withUsername("admin").password("{noop}password").roles("USER", "ADMIN").build();
        var user3 = User.withUsername("boris").password("{noop}123").roles("USER", "ADMIN").build();
        var user4 = User.withUsername("u").password("{noop}1").roles("USER").build();
        return new InMemoryUserDetailsManager(user1, user2, user3, user4);
    }
}
