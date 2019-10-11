package com.sungju.statement;

import java.util.Scanner;

import com.sungju.account.AccountDAO;
import com.sungju.account.AccountDTO;
import com.sungju.bankService.StatementService;

public class StatementController {
	Scanner sc;
	StatementDAO dao;
	StatementService service;
	AccountDAO accountDAO;
	public StatementController() {
	sc = new Scanner(System.in);
	dao = new StatementDAO();
	service = new StatementService();
	accountDAO = new AccountDAO();
	
	}
	
	public void start(AccountDTO dto) {
		boolean check = true;
		
		while (check) {
			System.out.println("1.입금");
			System.out.println("2.출금");
			System.out.println("3.거래내역조회");
			System.out.println("4.전단계 이동");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				dao.banking(service.inputIC(dto));
				accountDAO.updateBalance(dto);
				break;
			case 2:
				dao.banking(service.inputWD(dto));
				accountDAO.updateBalance(dto);
				break;
			case 3:
				service.view(dao.getStatement(dto));
				break;
			case 4:
			check = !check;
			break;

			default:
				System.out.println("다시 입력하세요");
				break;
			}
		}
		
		
	}

}
