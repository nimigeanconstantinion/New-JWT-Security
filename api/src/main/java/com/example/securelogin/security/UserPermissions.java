package com.example.securelogin.security;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserPermissions {
    PERSON_READ("person:read"),
    PERSON_WRITE("person:write");
    private final String permission;
    public String getPermission(){
        return permission;
    }
}
