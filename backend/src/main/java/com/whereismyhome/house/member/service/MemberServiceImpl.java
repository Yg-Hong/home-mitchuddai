package com.whereismyhome.house.member.service;

import java.util.List;
import java.util.Optional;

//import com.whereismyhome.house.crypt.PasswordEncoder;
import com.whereismyhome.house.exception.DuplicateEmailException;
import com.whereismyhome.house.exception.InvalidSignIn;
import com.whereismyhome.house.member.entity.Member;
import com.whereismyhome.house.member.repository.MemberRepository;
import com.whereismyhome.house.member.request.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUp signUp) {
        // 중복 이메일 체크
        Optional<Member> userEmail = memberRepository.findByEmail(signUp.getEmail());
        if (userEmail.isPresent()) {
            throw new DuplicateEmailException();
        }

//        String encodedPassword = passwordEncoder.encrypt(signUp.getPassword());

        Member member = new Member(signUp.getName(), signUp.getEmail(), signUp.getPassword());
        memberRepository.save(member);
    }

    @Override
    public Member getMember(String userId) throws Exception {
        return memberRepository.findById(Long.parseLong(userId))
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public List<Member> getMembers() throws Exception {
        return (List<Member>) memberRepository.findAll();
    }

    @Override
    public Member loginMember(String userId, String userPassword) throws Exception {
//        String encodedPassword = passwordEncoder.encrypt(userPassword);
        Member member = memberRepository.findByEmailAndPassword(userId, userPassword)
                .orElseThrow(InvalidSignIn::new);
        return member;
    }

}
