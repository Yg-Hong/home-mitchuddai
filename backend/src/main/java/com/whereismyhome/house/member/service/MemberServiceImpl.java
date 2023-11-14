package com.whereismyhome.house.member.service;

import java.net.http.HttpRequest;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.whereismyhome.house.member.dao.MemberDao;
import com.whereismyhome.house.member.dao.MemberDaoImpl;
import com.whereismyhome.house.member.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao = MemberDaoImpl.getInstance();

    private static MemberService instance = new MemberServiceImpl();

    private MemberServiceImpl() {}

    public static MemberService getInstance() {
        return instance;
    }

    @Override
    public MemberDto getMember(String userId) throws Exception {
        return memberDao.getMember(userId);
    }

    @Override
    public void registerMember(MemberDto memberDto) throws Exception {
        LocalDateTime createAt = LocalDateTime.now();
        memberDto.setJoinDate(createAt.toString());

        memberDao.registerMember(memberDto);
    }

    @Override
    public List<MemberDto> getMembers() throws Exception {
        return memberDao.getMembers();
    }

    @Override
    public MemberDto loginMember(String userId, String userPassword) throws Exception {
        MemberDto memberDto = memberDao.loginMember(userId, userPassword);

        if(memberDto != null) {
            return memberDto;
        }
        throw new IllegalStateException();
    }


}
