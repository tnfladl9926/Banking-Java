package com.project;

import java.util.Scanner;

public class CarLoanService {

	public static void carLoan() {
		
		UI.subMenu("자동차 대출 추천");
		
		System.out.println("[가입 방법]");
		System.out.println("1. 전체\t 2. 인터넷뱅킹\t3. 스타뱅킹\t4. 리브Next\t5. 영업점\t6. 스마트대출\n");
		
		Scanner scan = new Scanner(System.in);
		
		int count = 1;
		boolean loop = true;
		
		while (loop) {
			
			System.out.print("가입 방법 번호입력 : ");
			String typeSel = scan.nextLine();
			
			if (typeSel.equals("1")) {
				UI.recComment();
				for (Loan l : Data.loanlist) {
					
					if(l.getLoantype().equals("자동차대출")) {
						
						System.out.printf("%d. %s",count, l.getLoanname());
						count++;
						System.out.println();
					}
					
				}
				break;
				
			} else if (typeSel.equals("2")) {
				UI.recComment();
				for (Loan l : Data.loanlist) {
				
					if(l.getLoantype().equals("자동차대출") && l.getLoanjointype().equals("인터넷뱅킹")) {
					
						System.out.printf("%d. %s",count, l.getLoanname());
						count++;
						System.out.println();
					}
				}
				break;
				
			} else if (typeSel.equals("3")) {
				UI.recComment();
				for (Loan l : Data.loanlist) {
					
					if(l.getLoantype().equals("자동차대출") && l.getLoanjointype().equals("스타뱅킹")) {
					
						System.out.printf("%d. %s",count, l.getLoanname());
						count++;
						System.out.println();
					}
				}
				break;
				
			} else if (typeSel.equals("4")) {
				UI.recComment();
				for (Loan l : Data.loanlist) {
					
					if(l.getLoantype().equals("자동차대출") && l.getLoanjointype().equals("리브Next")) {
					
						System.out.printf("%d. %s",count, l.getLoanname());
						count++;
						System.out.println();
					}
				}
				break;
				
			} else if (typeSel.equals("5")) {
				UI.recComment();
				for (Loan l : Data.loanlist) {
					
					if(l.getLoantype().equals("자동차대출") && l.getLoanjointype().equals("영업점")) {
					
						System.out.printf("%d. %s",count, l.getLoanname());
						count++;
						System.out.println();
					}
				}
				break;
				
			} else if (typeSel.equals("6")) {
				UI.recComment();
				for (Loan l : Data.loanlist) {
					
					if(l.getLoantype().equals("자동차대출") && l.getLoanjointype().equals("스마트대출")) {
					
						System.out.printf("%d. %s",count, l.getLoanname());
						count++;
						System.out.println();
					}
				}
				break;
			} else {
				System.out.println("가입 방법 번호를 잘못 입력했습니다. 다시 선택해주세요.\n");
			}
		}
		
		System.out.println("==============================");
		System.out.println();
		
		while(true) {
			
			System.out.println("0. 이전으로");
			System.out.println("1. 자동차대출 다시 추천받기");
			System.out.println();
			System.out.print("입력 : ");
			String sel = scan.nextLine();
			
			if (sel.equals("0")) {
				LoanService.loanRecommend();
				
			} else if (sel.equals("1")){
				carLoan();
				
			} else {
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
				System.out.println("==============================");
				System.out.println();
			}
		}
	}//carLoan

	
	
}//CarLoanService class







