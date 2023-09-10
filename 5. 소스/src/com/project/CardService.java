package com.project;


import java.util.Scanner;

public class CardService {
	
	public static void cardMain() {
		Data.creditlist.clear();  //refresh
		Data.loadCredit();
		Data.debitlist.clear();
		Data.loadDebit();
		Scanner scan = new Scanner(System.in);
		
		UI.cardMain(); //카드 정보/조회 화면 호출
		System.out.print("숫자를 입력해주세요.: ");
		String input = scan.nextLine();
		if(input.equals("1")) {
			UI.subMenu("카드 목록");
			DebitService.debitList();
		}
		else if(input.equals("2")) {
			UI.subMenu("카드 목록");
			CreditService.creditList();

		}else if(input.equals("3")) {
			UI.subMenu("카드 추천");
			cardRecommend();
		}else if(input.equals("4")) {
			CustomerService.customerMain();
		}else {
			System.out.println("올바른 숫자를 입력해주세요");
		}
	}
	public static void cardRecommend() {
		Data.creditlist.clear();
		Data.debitlist.clear();
		Data.loadCredit();
		Data.loadDebit();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("추천받을 카드 종류 입력"
				+ "\r1.체크카드"
				+ "\r2.신용카드\r");
		System.out.print("추천받을 카드 선택(숫자): ");
		String input = scan.nextLine();

		if(input.equals("1")) {
			System.out.println("추천받을 나이대를 입력해주세요.(숫자만, ex: 25살의 경우 20입력): ");
			int input2 = scan.nextInt();
		
			DebitService.recommend(input2);
		}
		else if(input.equals("2")) {
			
			System.out.println("추천받을 나이대를 입력해주세요.(숫자만, ex: 25살의 경우 20입력): ");
			int input2 = scan.nextInt();
			
			CreditService.recommend(input2);
		}
		
	

	}
	
	
	

}
