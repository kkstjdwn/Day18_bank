package com.sungju.member;


import java.util.Scanner;
import com.sungju.account.AccountController;
import com.sungju.bankService.MemberService;



public class MemberController {
	private Scanner sc;
	private MemberDAO dao;
	private MemberService service;

	private AccountController controller;


	public MemberController() {
		sc = new Scanner(System.in);
		dao = new MemberDAO();
		service = new MemberService();

		this.controller = new AccountController();

	}

	public void start() {

		boolean check = true;
		MemberDTO dto = new MemberDTO();
		while (check) {
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.로그아웃");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				choice = dao.signup(service.makememeber());
				break;
			case 2:
				dto = dao.signin(service.singin());
				if(dto !=null) {controller.start(dto);}
				
				break;
			case 3:
				check = !check;
				sc.close();
				System.out.println("로그아웃 되었습니다");
				break;

			default:
				System.out.println("다시 입력하세요");
				break;
			}
		}

	}

}
