package com.project;

import java.util.Scanner;

public class SavingService {
	
	public static void main(String[] args) {
		
//	Data.loadLogin();
	
	savMain();	//적금 메인 호출
	
	Data.savsave();
	
	}
	
	
	
	
	
	public static void savMain() {
		
		SavUI.savMain();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 서비스를 입력하세요: ");
		String sel = scan.nextLine();		//적금 조회 추천 계산기 중 선택
		
		if (sel.equals("1")) {
			savList();		//적금 조회

		}else if (sel.equals("2")) {
			savReco();		//적금 추천
			
		}else if (sel.equals("3")) {
			savcal();		//적금 계산기
			
		}else if (sel.equals("0")){
			CustomerService.customerMain();
			
		}else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			savMain();
		}
		
	} //savMain()
	
	
	
	
	
	
	public static void savList() {	//적금 조회
		
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("1. 적금조회");
		
		System.out.println("[상품번호]\t\t[상품명]\n");
		
		for (Savings s : Data.List) {
			System.out.printf("%s\t\t%s\n", s.getSavNO(), s.getSavName());
		}
		
		
		System.out.println("1. 적금 상세정보 보기");
		System.out.println("0. 이전으로 돌아가기");
		System.out.print("입력: ");
		String sel = scan.nextLine();
		
		
		if (sel.equals("1")) {
			seeDetailSav();
		} else if (sel.equals("0")) {
			savMain();
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			savList();
		}
		
	} //savList()
		
	
	
		

	private static void seeDetailSav() {	//적금 상세 조회
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.printf("\t1. 상세정보 보기\n");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		
		
		System.out.print("상세정보를 원하시는 상품의 번호: ");
		String sel2 = scan.nextLine();
		
		System.out.println("[상품명]\t\t\t[신청자격]\t\t\t[이율]\t\t[최대 월납입액]\t\t[최대 계약기간]");
		
		for (Savings s : Data.List) {
			if (s.getSavNO().equals(sel2))
			System.out.printf("%s\t\t%s\t\t\t%s\t\t%s\t\t%s\n", s.getSavName()
																, s.getSavQuali()
																, s.getSavInterest() + "%"
																, s.getSavMaxPay() + "(원)"
																, s.getSavPer() + "(개월)");
		}
		
		
		
		System.out.println("1. 다른 적금의 상세정보 확인하기");
		System.out.println("0. 이전으로 돌아가기");
		
		System.out.print("입력: ");
		String back = scan.nextLine();
		
		if (back.equals("1")) {
			seeDetailSav();
		} else if (back.equals("0")) {
			savMain();
		} else {
			savMain();
		}
		
	}//seeDetailSav()

	
	
	
	
	//0    1      2        3      4            5          6                  7            8   9   10   11    12   13  14   15
	//85,정판루,780916158400,1,010-3153-1376,e2wwhktmb,673553-31-145994,085l7vujekwt6dsbg0, 0 , 0,  1 ,  1 ,    8,  4,  1,  15
	//			주민번호	   군					아이디			계좌					비번	 기혼  기초 직장  가입여부 적금 대출 신용 체크
	
	public static void savReco() {	//적금 추천
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("2. 적금 추천");
		
		//만약 회원 정보의 직업과 적금 상품의 가입대상이 같다면 출력, 만약 기혼이면 기혼 대상 적금 출력, 기초생활수급자면 기초생활 대상 적금 출력 만약 이미 들고 있는 적금이라면 밑에 이미 가입되어 있는 상품입니다.
		
		//추천상품
		
		for (Login m : Data.customerInfo) {
			
			System.out.printf("%s 고객님에게 다음의 적금을 추천합니다.\n", m.getName());
			System.out.println();
	
			for (Savings s : Data.List) {
				
				if (m.getJob().equals("1") && s.getSavQuali().equals("직장인")) {
					System.out.println(s.getSavName());
				}
				
				if (m.getPoor().equals("1") && s.getSavQuali().equals("차상위계층")) {
					System.out.println(s.getSavName());
					
				}
				
				if (m.getMarried().equals("1") && s.getSavQuali().equals("기혼")) {
					System.out.println(s.getSavName());
				}
			}
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("****************** EVENT *******************");
		//이벤트 상품여부 알려주기
		System.out.println();
		for (Login m : Data.customerInfo) {
			for (Savings s : Data.List) {
				
				if (s.getEventOX().equals("1") && m.getJob().equals("1") && s.getSavQuali().equals("직장인")) {
					System.out.printf("현재 %s인 고객님들을 위한 적금 이벤트가 진행중 입니다.\n", s.getSavQuali());
					System.out.println(s.getSavName()+'\n');
				}
				
				
				if (s.getEventOX().equals("1") && m.getPoor().equals("1") && s.getSavQuali().equals("차상위계층")) {
					System.out.printf("현재 %s인 고객님들을 위한 적금 이벤트가 진행중 입니다.\n", s.getSavQuali());
					System.out.println(s.getSavName()+'\n' );
					
				}
				
				if (s.getEventOX().equals("1") && m.getMarried().equals("1") && s.getSavQuali().equals("기혼")) {
					System.out.printf("현재 %s인 고객님들을 위한 적금 이벤트가 진행중 입니다.\n", s.getSavQuali());
					System.out.println(s.getSavName()+'\n');
				}
			}
			
			System.out.println("********************************************");
			back(scan);
			
		}
	}//savReco()
	
	
	

	
	public static void savcal() {
		
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("3. 적금 계산기");
		
		System.out.println("1. 매월 일정 금액을 저축할 때");
		System.out.println("2. 목표 금액을 모을 때");
		System.out.println("0. 메인메뉴로 돌아가기");
		
		System.out.print("선택: ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {		//1. 매월 일정 금액을 저축할 때 계산
			monthlyPay();		
			
		}else if (sel.equals("2")) {	//2. 목표 금액을 모을 때 계산
			goalPay();			
			
		}else if (sel.equals("0")){		//
			savMain();
			
		}else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			savcal();
		}
	
	} //savcal()

	
	
	
	
	private static void goalPay() {	//2. 목표 금액을 모을 때
		
		System.out.println("------------목표 금액을 모을 때------------");
		
		Scanner scan = new Scanner(System.in);
		double monPay = 0;
		
		System.out.print("목표 금액: ");
		int goal = scan.nextInt();
		
		System.out.print("적금 기간: ");
		int month = scan.nextInt();
		
		System.out.print("금리(주의! 3%의 경우 0.03으로 입력): ");
		double rate = scan.nextDouble();
		scan.nextLine();
		
		monPay = goal / (month + (rate/12) * (month *(month+1)/2));
		
		System.out.printf("%d원을 목표로 %d개월 간 %.2f로 저축한다면 월 %.2f원을 저축해야 합니다.\n", goal, month, rate, monPay);
		
		back(scan);
		
	} //goalPay()

	
	
	
	
	private static void monthlyPay() {	//1. 매월 일정 금액을 저축할 때
		
		System.out.println("------------매월 일정 금액을 저축할 때------------");
		
		Scanner scan = new Scanner(System.in);
		double total = 0;
		
		System.out.print("월 저축액 :");
		int monPay = scan.nextInt();
		
		System.out.print("적금 기간(개월): ");
		int month = scan.nextInt();
		
		System.out.print("금리(주의! 3%의 경우 0.03으로 입력): ");
		double rate = scan.nextDouble();
		scan.nextLine();
		
		total = monPay * month + monPay * (rate /12) * (month * (month+1)/2);
		
		System.out.printf("%d원씩 %d개월 간 %.2f의 이자율의 적금상품에 저축하면 총 %.1f원을 모으실 수 있습니다.\n", monPay, month, rate, total);
		
		back(scan);
		
	} //monthlyPay()

	
	
	
	
	private static void back(Scanner scan) {	//뒤로가기 메소드
		System.out.print("메인메뉴로 돌아가려면 0을 입력하세요: ");
		String back = scan.nextLine();
		
		if (back.equals("0")) {
			savMain();
		}
	} //back()
	
	
	
	
	
} //class SavingService
