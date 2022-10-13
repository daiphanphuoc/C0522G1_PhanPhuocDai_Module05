package com.example.model.dto;

import com.example.dto_interface.IUserDto;

public class UserDto {
    private String username;
    private String password;

    public UserDto() {
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto(IUserDto userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
