package com.example.kursach.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;//возможные роли

    @Override
    public String getAuthority() {
        return name();
    }//возвращает роль в виде строки
}