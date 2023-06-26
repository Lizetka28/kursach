package com.example.kursach.config;

import com.example.kursach.servise.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {//настройка конфигурации безопасности HTTP запросов
        http
                .authorizeRequests()
                .antMatchers("/", "/registration")//пути, для которых не нужна аутентификация
                .permitAll()
                .antMatchers("/factories")//пути, доступные пользователям и админам
                .hasAnyRole("USER","ADMIN")
                .antMatchers("/factory-create")//пути, доступные только админам
                .hasRole("ADMIN")
                .antMatchers("/factory-update")
                .hasRole("ADMIN")
                .anyRequest().authenticated()//все остальные запросы должны быть аутентифицированы
                .and()
                .formLogin()//настройка формы входа в систему
                .loginPage("/login")//указывает адрес страницы входа
                .permitAll()
                .defaultSuccessUrl("/factories")//переводит на страницу после входа в систему
                .and()
                .logout()//настройка выхода
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {// настройка аутентификации
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());//шифрование пароля
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}