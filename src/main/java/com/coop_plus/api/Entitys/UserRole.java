package com.coop_plus.api.Entitys;

public enum UserRole {
    ADMIN("admin"),
    EMPLOYEE("employee"),
    USER("client");

    private String role;
    UserRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
}
