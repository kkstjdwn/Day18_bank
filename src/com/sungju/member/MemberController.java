package com.sungju.member;

import java.util.Scanner;

import com.sungju.bankService.MemberService;
import com.sungju.bankView.BankView;


public class MemberController {
	private Scanner sc;
	private MemberDAO dao;
	private MemberService service;
	private BankView view;


	public MemberController() {
		sc = new Scanner(System.in);
		dao = new MemberDAO();
		service = new MemberService();
		view = new BankView();

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
				String msg = "회원가입 실패";
				if (choice == 1) {
					msg = "회원가입 성공";
				}
				view.view(msg);
				break;
			case 2:
				dto = dao.signin(service.singin());
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
