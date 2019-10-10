package com.sungju.bankService;

import java.util.Scanner;

import com.sungju.member.MemberDTO;

public class MemberService {

	Scanner sc;

	public MemberService() {
		sc = new Scanner(System.in);
	}

	public MemberDTO makememeber() {

		MemberDTO dto = new MemberDTO();
		System.out.println("ID를 입력하세요");
		dto.setId(sc.next());
		System.out.println("PW를 입력하세요");
		dto.setPw(sc.next());
		System.out.println("성함을 입력하세요");
		dto.setName(sc.next());
		System.out.println("연락처를 입력하세요");
		dto.setHp(sc.next());
		System.out.println("E-MAIL을 입력하세요");
		dto.setEmail(sc.next());

		return dto;

	}
	
	public MemberDTO singin() {
		
		MemberDTO dto = new MemberDTO();
		System.out.println("ID를 입력하세요");
		dto.setId(sc.next());
		System.out.println("pw를 입력하세요");
		dto.setPw(sc.next());
		
		return dto;
		
	}

}
