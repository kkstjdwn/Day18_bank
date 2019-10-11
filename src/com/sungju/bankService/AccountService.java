package com.sungju.bankService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.sungju.account.AccountDTO;
import com.sungju.member.MemberDTO;

public class AccountService {

	Scanner sc;

	public AccountService() {

		sc = new Scanner(System.in);
	}

	public AccountDTO insertAcc(MemberDTO memDto) {
		AccountDTO dto = new AccountDTO();

		dto.setId(memDto.getId());
		System.out.println("새로운 계좌 이름을 입력하세요");
		dto.setAcname(sc.next());
		dto.setAcnumber(String.valueOf(Calendar.getInstance().getTimeInMillis()));
		System.out.println("최초 잔액을 입력하세요");
		dto.setBalance(sc.nextLong());

		return dto;
	}

	public void view(ArrayList<AccountDTO> ar) {
		if (ar.size() != 0) {
			System.out.println("id\t계좌명\t계좌번호\t\t잔액");
			for (AccountDTO dto : ar) {

				System.out.println(
						dto.getId() + "\t" + dto.getAcname() + "\t" + dto.getAcnumber() + "\t" + dto.getBalance());
			}
			System.out.println();

		} else {
			System.out.println("개설된 계좌가 없습니다.");
		}

	}

	public String delView(AccountDTO dto) {
		
		if (dto != null) {
			System.out.println("삭제할 계좌명을 입력하세요");
			String acname = sc.next();

			if (dto.getAcname().equals(acname) && dto.getBalance() != 0) {

				System.out.println("잔액이 있는 계좌는 삭제 할 수 없습니다.");
				acname = null;

			}
		}

		return dto.getAcname();
	}

	public AccountDTO selectAC(ArrayList<AccountDTO> ar) {
		AccountDTO dto = null;
		if (ar.size() != 0) {
			System.out.println("계좌명\t잔액");
			for (AccountDTO acdto : ar) {
				System.out.println(acdto.getAcname() + "\t" + acdto.getBalance());
			}
		}
		System.out.println("거래할 계좌명을 입력하세요");
		String acname = sc.next();
		for (AccountDTO accountDTO : ar) {
			if (accountDTO.getAcname().equals(acname)) {
				dto = new AccountDTO();
				dto = accountDTO;
			}
		}

		return dto;
	}

}
