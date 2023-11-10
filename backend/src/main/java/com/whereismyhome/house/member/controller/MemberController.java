package com.whereismyhome.house.member.controller;

import com.whereismyhome.house.member.dto.MemberDto;
import com.whereismyhome.house.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String login(){
		return "로그인 페이지 입니다.";
    }

    @PostMapping("/login")
	public MemberDto login(@RequestBody MemberDto memberDto) throws Exception {
		String userId = memberDto.getUserId();
		String userPassword = memberDto.getUserPassword();
		log.info("userId={}, userPassword={}", userId, userPassword);
		return memberService.loginMember(userId, userPassword);
	}

	@GetMapping("/register")
	protected String registerMember() throws Exception {
		return "멤버 등록 폼 입니다.";
	}

	@PostMapping("/register")
	public void registerMember(@RequestBody MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
	}

	@GetMapping("/detail/{id}")
	public MemberDto memberDetail(@PathVariable String id) throws Exception {
		return memberService.getMember(id);
	}

}
