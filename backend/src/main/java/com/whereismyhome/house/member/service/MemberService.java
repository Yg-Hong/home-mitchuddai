package com.whereismyhome.house.member.service;

import java.util.List;

import com.whereismyhome.house.member.dto.MemberDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface MemberService {

    public MemberDto getMember(String userId) throws Exception;

    public void registerMember(MemberDto member) throws Exception;

    public List<MemberDto> getMembers() throws Exception;

    public MemberDto loginMember(String userId, String userPassword) throws Exception;
}
