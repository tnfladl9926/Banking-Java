package com.project;

import java.util.Scanner;

public class LoanService {


	//고객 > 메인화면 > 대출조회/추천(고객메뉴 대출파트 메인화면) 
	public static void loanMain() {
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		UI.loanMain();
		System.out.println();
		System.out.print("숫자를 입력해주세요: ");
		String input = scan.nextLine();
		System.out.println();
		if(input.equals("1")) {
			loanList();
			
		}else if (input.equals("2")) {
			loanRecommend();
			
		}else if (input.equals("3")){
			loanCalculator();

		}else if (input.equals("0")) {
			CustomerService.customerMain();
			
		}else {
			System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
			System.out.println("=============================");
			System.out.println();
		}
	}
	
	//고객 > 메인화면 > 대출조회/추천 > 대출 조회 > 대출 상품 목록
	public static void loanList() {
		Scanner scan = new Scanner(System.in);
		
		UI.subMenu("대출 상품 목록");
	      
	      for(Loan m : Data.loanlist) {
	         System.out.printf("%s. %s\n"
	                     ,m.getLoanno()
	                     ,m.getLoanname());
	      }
		
		System.out.println("-----------------------------");
		System.out.println("0. 이전화면");
		System.out.print("0 또는 상세목록을 보고싶은 상품의 번호 입력 : ");
		
		String num = scan.nextLine();
		System.out.println();
		
		if(num.equals("0")) {
			loanMain();
		}else {
			detailSearch(num);
		}
		
		System.out.println();
		
			
	}
	 
	
	//고객 > 메인화면 > 대출조회/추천 > 대출 조회 > 대출 상품 목록 >대출 상세검색
	private static void detailSearch(String input) {
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		int count = 0;
		
		System.out.println("-----------상세보기----------");
		
		for(Loan m : Data.loanlist) {
			
			if(m.getLoanno().equals(input)) {
				
				System.out.printf("[%s. %s]\r\n\n",m.getLoanno(),m.getLoanname());
				System.out.printf("<대출종류>\t\t: %s\r<신청자격>\t\t: %s\r<가입방법>\t\t: %s\r<금리>\t\t: %s(%%)\r<최장기간>\t\t: %s\r<최고대출금액>\t: %,d원\r<상환방법>\t\t: %s\r"
									,m.getLoantype()
									,m.getLoanperson()
									,m.getLoanjointype()
									,m.getLoanrate()
									,m.getLoanmaxperiod()
									,Integer.parseInt(m.getLoanmaxamount())
									,m.getLoanrepaytype());
				count++;
				
			}
		}
		
		if (count == 0) {
			System.out.println();
			System.out.println("번호에 맞는 대출 상품이 없습니다.");
			System.out.println();
		}
		
		System.out.println("-----------------------------");
		System.out.println();
		
		while(loop) {
			System.out.print("이전으로 돌아가시려면 0을 눌러주세요. : ");
			String num = scan.nextLine();
			
			if(num.equals("0")) {
				loanList();
			} else {
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
				System.out.println("==============================");
				System.out.println();
			}
		}
	
	}

	//고객 > 메인화면 > 대출조회/추천 > 대출 추천
	public static void loanRecommend() {
		
		UI.subMenu("대출 추천");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 신용 대출");
		System.out.println("2. 전월세/반환보증 대출");
		System.out.println("3. 자동차 대출");
		System.out.println();
		System.out.println("0. 이전으로");
		System.out.println();
		
		System.out.print("추천받고 싶은 대출 종류 입력(숫자): ");
		String input = scan.nextLine();
		System.out.println();
		
		if(input.equals("1")) {
			CreditLoanService.creditLoan();
		}else if(input.equals("2")) {
			JeonseLoanService.jeonseLoan();
		}else if(input.equals("3")) {
			CarLoanService.carLoan();
		}else if (input.equals("0")) {
			loanMain();
		}else {
			System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
			System.out.println("==============================");
			System.out.println();
			loanRecommend();
		}
	}
	
	//고객 > 메인 화면 > 대출 조회/ 추천 > 대출 계산기
		private static void loanCalculator() {
			//원금만기일시상환 기준
			
			UI.subMenu("대출 계산기");
			
			System.out.println();
			
			boolean loop = true;
			Scanner scan = new Scanner(System.in);
			
			try {
				
				System.out.print("대출 금액(원) 입력 : ");
				long amount = scan.nextLong();
				
				System.out.print("기간(년) 입력 : ");
				long period = scan.nextLong();
				
				System.out.print("이자(%) 입력 : ");
				double interestRate = scan.nextDouble();
				
				interestRate = interestRate / 100.0;
				
				double interest = amount * interestRate * period;
				interest = Math.round(interest);
				
				long monthlyinterest = (long)interest / (period * 12);
				monthlyinterest = Math.round(monthlyinterest);
				
				long monthlyamount = Math.round(amount / (period * 12.0));
				
				
				System.out.println("==============================");
				System.out.println("[결과]");
				System.out.printf("대출 금액 : %,d 원\n", amount);
				System.out.printf("총 이자 : %,d 원\n", (long)interest);
				System.out.printf("총 비용 : %,d 원\n", amount +(long)interest);
				System.out.println();
				System.out.printf("월 평균 상환원금 : %,d 원\n", monthlyamount);
				System.out.printf("월 이자액 상환원금 : %,d 원\n", monthlyinterest);
				System.out.printf("월 평균 납입금 : %,d 원\n", monthlyamount + monthlyinterest);
				System.out.println("==============================");
				
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
			}
				
			System.out.println();
			
			scan.nextLine();	//공회전
			
			while (loop) {
				
				System.out.println("0. 이전으로");
				System.out.println("1. 다시 계산하기");
				System.out.println();
				System.out.print("입력 : ");
				String sel = scan.nextLine();
				
				if (sel.equals("0")) {
					loanMain();
				} else if (sel.equals("1")){
					loanCalculator();
				} else {
					System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
					System.out.println("==============================");
					System.out.println();
				}
			}
		}//loanCalculator
		
		
	
}

