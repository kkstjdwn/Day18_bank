package com.sungju.account;

import java.util.Scanner;

import javax.swing.text.View;

import com.sungju.bankService.AccountService;
import com.sungju.member.MemberDTO;
import com.sungju.statement.StatementController;

public class AccountController {
	Scanner sc;

	public AccountController() {
		sc = new Scanner(System.in);
	}

	public void start(MemberDTO dto) {
		AccountDAO dao = new AccountDAO();
		AccountService service = new AccountService();
		StatementController controller = new StatementController();

		boolean check = true;

		while (check) {
			System.out.println("1.계좌개설");
			System.out.println("2.계좌조회");
			System.out.println("3.계좌삭제");
			System.out.println("4.은행업무");
			System.out.println("5.이전단계로");
			int select = sc.nextInt();
			switch (select) {

			case 1:
				dao.makeAccount(service.insertAcc(dto));

				break;
			case 2:
				service.view(dao.searchAcc(dto));
				break;
			case 3:
				dao.deleteAccount(service.delView(service.selectAC(dao.searchAcc(dto))));
				break;
			case 4:
				controller.start(service.selectAC(dao.searchAcc(dto)));
				break;
			case 5:
				check = !check;
				System.out.println("전단계로 이동합니다");
				break;

			default:
				System.out.println("다시 입력하세요");
				break;
			}

		}

	}

}
