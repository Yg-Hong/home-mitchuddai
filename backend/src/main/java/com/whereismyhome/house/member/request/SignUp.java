package com.whereismyhome.house.member.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUp {

    private String email;
    private String password;
    private String name;

}
