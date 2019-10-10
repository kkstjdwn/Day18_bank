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
		dto.setBalance(sc.nextInt());
		
		
		return dto;
	}
	
	public void view(ArrayList<AccountDTO> ar) {
		if (ar.size() !=0) {
			for (AccountDTO dto : ar) {
				System.out.println("사용자 id  : "+dto.getId());
				System.out.println("계좌명          : "+dto.getAcname());
				System.out.println("계좌번호       : "+dto.getAcnumber());
				System.out.println("잔액             : "+dto.getBalance());
				System.out.println("======================");
			}
			
		}else {
			System.out.println("개설된 계좌가 없습니다.");
		}
		
		
		
		
	}
	

}
