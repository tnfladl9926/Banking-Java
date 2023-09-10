package com.project;

import java.util.Scanner;

public class LoanManager {
	
	public static void loanManagerMain() {
		
		boolean loop = true;
		
		
		Scanner scan = new Scanner(System.in);
			
		while (loop) {
			UI.subMenu("대출 상품 관리");
			
			System.out.println("1. 대출 상품 목록 조회");
			System.out.println("2. 대출 상품 추가");
			System.out.println("0. 이전으로\n");
		
			System.out.print("입력 : ");
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				LoanManagerService.loanList();
			} else if (sel.equals("2")) {
				LoanManagerService.loanAdd();
			} else if (sel.equals("0")){
				ManagerService.goodsmanagement();
			} else {
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
				loanManagerMain();
			}
		}
		
	}
	
	

}
