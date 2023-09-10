package com.project;

import java.util.Scanner;

public class ManagerService {

//관리자 로그인
	public static void managerlogin() {
		
		UI.subMenu("관리자 로그인");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("관리자 아이디 입력: ");
		String mId = scan.nextLine();
		System.out.print("관리자 코드 입력: ");
		String mCode = scan.nextLine();
		
	
		
		for(Manager m : Data.managerlist) {
			if (mId.equals(m.getManagerId()) && mCode.equals(m.getManagerCode())) {
				managerMain();
			}
			
		}
			
		
		System.out.println("관리자 아이디 또는 코드가 틀렸습니다.");
		System.out.println("메인메뉴로 돌아가시겠습니까?");
		System.out.println("1. 네\t\t2. 아니요");
		String sel = scan.nextLine();
		if (sel.equals("1")) {
			UI.goMain();
		} else if (sel.equals("2")) {
			managerlogin();
		}
		
	}

	//관리자-메인화면
	private static void managerMain() {
	
		UI.subMenu("관리자-메인화면");
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 상품관리");
		System.out.println();
		System.out.println();
		System.out.println();		
		System.out.println("0. 로그아웃");
		
		System.out.print("선택: ");
		String sel = scan.nextLine();
		
		while (loop) {
			if (sel.equals("1")) {
				goodsmanagement();
			} else if (sel.equals("0")) {
				UI.goMain();
			} else {
				System.out.println("숫자를 다시 입력해주세요.");
			}
		}
		
		
	}

	

	
	
	//관리자-상품관리
	public static void goodsmanagement() {
		
		UI.subMenu("관리자-상품관리");
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 적금");
		System.out.println("2. 대출");
		System.out.println("3. 카드");
		System.out.println("0. 이전으로");
		
		System.out.print("선택: ");
		String sel = scan.nextLine();
		
		while (loop) {
			if (sel.equals("1")) {
				SavManagerMain.savManagerMain();
			} else if (sel.equals("2")) {
				LoanManager.loanManagerMain();
			} else if (sel.equals("3")) {
				ManagerCardService.mCardMain();;
			} else if (sel.equals("0")) {
				managerMain();
			} else {
				System.out.println("숫자를 다시 입력해주세요.");
			}
		}
		
		
	}
	
}
