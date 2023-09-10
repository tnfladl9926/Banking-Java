package com.project;

import java.util.Scanner;

public class SavManagerMain {
	
	public static void main(String[] args) {
		
//		Data.savLoad();
//		Data.loadLogin();
//		Data.loadManager();
		
		savManagerMain();
		
		Data.savsave();
		
	}
	
	
	
	
	
	public static void savManagerMain() {
		
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("적금");
		
		System.out.println("1. 적금 상품 목록");
		System.out.println("2. 적금 상품 수정");
		System.out.println("0. 이전으로");
		
		System.out.print("원하는 서비스를 입력하세요: ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			savList();
		} else if (sel.equals("2")) {
			savModi();
		} else if (sel.equals("0")){
			ManagerService.goodsmanagement();
		}
	}
	
	
	
	

	private static void savList() {
		
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("1. 적금조회");
		
		System.out.println("[상품번호]\t\t[상품명]\n");
		
		for (Savings s : Data.List) {
			System.out.printf("%s\t\t%s\n", s.getSavNO(), s.getSavName());
		}
		
		
		System.out.println("1. 적금 상세정보 보기");
		System.out.println("0. 이전으로 돌아가기");
		System.out.print("입력: ");
		String sel4 = scan.nextLine();
		
		
		if (sel4.equals("1")) {
			seeDetailSav();
		} else if (sel4.equals("0")) {
			savManagerMain();
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			savList();
		}
				
	}


	
	

	private static void seeDetailSav() {	//적금 상세 조회
		
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("1. 상세정보 보기");
		
		
		System.out.print("상세정보를 원하시는 상품의 번호: ");
		String sel2 = scan.nextLine();
		
		System.out.println("[상품명]\t\t\t[신청자격]\t\t\t[이율]\t\t[최대 월납입액]\t\t[최대 계약기간(월)]");
		
		for (Savings s : Data.List) {
			if (s.getSavNO().equals(sel2))
			System.out.printf("%s\t\t%s\t\t\t%s\t\t%s\t\t\t%s\n", s.getSavName()
																, s.getSavQuali()
																, s.getSavInterest()
																, s.getSavMaxPay()
																, s.getSavPer());
		}
		
		System.out.println("1. 다른 적금 상세정보 보기");
		System.out.println("0. 이전으로 돌아가기");
		System.out.print("입력: ");
		String sel = scan.nextLine();
		
		
		if (sel.equals("1")) {
			seeDetailSav();
		} else if (sel.equals("0")) {
			savManagerMain();
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			savList();
		}
	}

	
	
	
	
	private static void savModi() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 제거");
		System.out.println("0. 이전으로 돌아가기");
		System.out.print("선택: ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			savAdd();
		} else if (sel.equals("2")) {
			savRemove();
		} else if (sel.equals("0")) {
			savManagerMain();
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			savModi();
		}
		
		back(scan);

	}
	
	
	
	
	
	private static void savRemove() {
		
		SavUI.savSub("2. 상품 제거");
		
		System.out.println("[상품번호]\t\t[상품명]\n");
		
		for (Savings s : Data.List) {
			System.out.printf("%s\t\t%s\n", s.getSavNO(), s.getSavName());
		}
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 적금의 상품번호 입력: ");
		String sel = scan.nextLine();
		
		for (Savings s : Data.List) {
			
			if (s.getSavNO().equals(sel)) {
				
				Data.List.remove(s);
				break;
				
				}
			}
		
		Data.savsave();
		
		System.out.println("상품 삭제가 완료되었습니다.");
		
		back(scan);
		
		}
		
	
	private static void savAdd() {
		
		SavUI.savSub("1. 상품 추가");
		
		Scanner scan = new Scanner(System.in);
		
		String no = Data.List.stream()
							 .mapToInt(s -> Integer.parseInt(s.getSavNO()))
							 .max().getAsInt()
							 + 1 + "";
		
		
		System.out.print("이벤트여부(이벤트 상품이면 '1' 입력): ");
		String eventOX = scan.nextLine();
		
		System.out.print("상품이름: ");
		String savName = scan.nextLine();
		
		System.out.print("신청자격: ");
		String savQuali = scan.nextLine();
		
		System.out.print("이율(%): ");
		String savInterest = scan.nextLine();
		
		System.out.print("최대 월 납입액(원): ");
		String savMaxPay = scan.nextLine();
		
		System.out.print("계약 기간(개월): ");
		String savPer = scan.nextLine();
		
		Savings s  = new Savings(eventOX, no, savName, savQuali, savInterest, savMaxPay, savPer);
		
		Data.List.add(s);
		
		Data.savsave();
		
		System.out.println("상품 추가가 완료되었습니다.");
		
		back(scan);
		
		}
		
	
	


	private static void back(Scanner scan) {
		System.out.println("이전으로 돌아가려면 0을 입력하세요: ");
		String back = scan.nextLine();
		
		if (back.equals("0")) {
			savManagerMain();
		}
	}

}
