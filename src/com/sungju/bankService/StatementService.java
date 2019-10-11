package com.sungju.bankService;

import java.util.ArrayList;
import java.util.Scanner;

import com.sungju.account.AccountDTO;
import com.sungju.statement.StatementDTO;

public class StatementService {
	Scanner sc;

	public StatementService() {
		sc = new Scanner(System.in);
	}

	public StatementDTO inputIC(AccountDTO acdto) {
		StatementDTO dto = new StatementDTO();
		dto.setAcnumber(acdto.getAcnumber());
		System.out.println("입금할 금액을 입력하세요");
		dto.setDeposit(sc.nextLong());
		dto.setBalance(acdto.getBalance() + dto.getDeposit());
		acdto.setBalance(dto.getBalance());

		return dto;
	}
	public StatementDTO inputWD(AccountDTO acdto) {
		StatementDTO dto = new StatementDTO();
		dto.setAcnumber(acdto.getAcnumber());
		System.out.println("출금할 금액을 입력하세요");
		dto.setWithdraw(sc.nextLong());
		dto.setBalance(acdto.getBalance() - dto.getWithdraw());
		if (dto.getBalance() < 0) {
			System.out.println("잔액이 부족합니다");
			dto = null;
		}else {			
			acdto.setBalance(dto.getBalance());
		}
		return dto;
	}

	public void view(ArrayList<StatementDTO> ar) {
		if (ar.size() != 0) {
			System.out.println("거래번호\t계좌번호\t\t거래날짜\t\t입금내역\t출금내역\t잔액");
			for (StatementDTO dto : ar) {
				System.out.println(dto.getStateNumber() + "\t" + dto.getAcnumber() + "\t" + dto.getAcdate() + "\t"
						+ dto.getDeposit() + "\t" + dto.getWithdraw() + "\t" + dto.getBalance());

			}
		}else {
			System.out.println("거래내역이 없습니다");
		}

	}

}
