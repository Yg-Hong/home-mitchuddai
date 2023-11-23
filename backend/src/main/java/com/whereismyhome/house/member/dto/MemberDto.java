package com.whereismyhome.house.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String userId;
    private String name;
    private String password;
    private String email;
    private String address;
    private String createdAt;


    @Builder
    public MemberDto(String userId, String name, String password, String address, String email, String createdAt) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
    }
}
