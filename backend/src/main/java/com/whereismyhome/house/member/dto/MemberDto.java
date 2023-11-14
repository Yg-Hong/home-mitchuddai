package com.whereismyhome.house.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String userId;
    private String userName;
    private String userPassword;
    private String emailId;
    private String emailDomain;
    private String joinDate;

    @Builder
    public MemberDto(String userId, String userName, String userPassword, String emailId, String emailDomain, String joinDate) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.emailId = emailId;
        this.emailDomain = emailDomain;
        this.joinDate = joinDate;
    }
}
