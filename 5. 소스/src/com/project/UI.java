package com.project;

import java.util.Scanner;

public class UI {

	public static void mainMenu() {
		
		System.out.println("=============================");
		System.out.println("[쌍용은행]");
		System.out.println("(상품 추천 시스템)\n");
		System.out.println("1. 관리자 로그인");
		System.out.println("2. 고객 로그인");
		System.out.println("3. 회원가입");
		System.out.println("4. 프로그램 종료");
		System.out.println("=============================");
		
	}
	
	public static void subMenu(String title) {
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.printf("<%s>\n", title);
		System.out.println("-----------------------------");
		
	}
	
	public static void backSapce() {
	      System.out.println("0.뒤로 가기");
	}
	
	public static void cardMain() {
	      UI.subMenu("카드 조회/추천");
	      String[] a = {"체크카드","신용카드","카드 추천받기","뒤로가기"};
	      UI.userSelect(a);
	      
	}
	
	public static void userSelect(String[] input) {
	      for (int i = 0; i < input.length; i++) {
	         System.out.printf("%d.%s\r",i+1,input[i]);
	      }
	      
	}
	
	public static void mCardMain() {
	      UI.subMenu("카드 상품 관리");
	      String[] a = {"카드 상품 목록","카드 상품 추가"};
	      UI.userSelect(a);
	      
	 }
	
	public static void goMain() { //메인으로 돌아가기
		try {
			Main.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	//고객 > 대출 메인
	public static void loanMain() {

      UI.subMenu("대출 조회/추천");
      System.out.println("1.대출 조회");
      System.out.println("2.대출 추천");
      System.out.println("3.대출 계산기");
      System.out.println();
      System.out.println("0.이전화면");
	}
	
	//고객 > 대출 메인화면으로 돌아가기
	public static void loanBackSpace() {
	      Scanner scan = new Scanner(System.in);
	      System.out.print("번호 입력: ");
	      String input= scan.nextLine();
	      if(input.equals("0")) {
	         LoanService.loanMain();
	      }else {
	      System.out.println("올바른 숫자를 입력해주세요");
	      }
	}
	
	public static void recComment() {
		System.out.println("==============================");
        
        for (Login log : Data.customerInfo) {
           System.out.printf("%s님과 적합한 대출 상품 추천\n\n"
                          ,log.getName());
           break;
        } 
	}
	
	//고객 > 대출 추천
	public static void loanRecommend() {

	      
	   
	      System.out.println("1.신용 대출");
	      System.out.println();
	      System.out.println("2.전/월세 반환보증");
	      System.out.println();
	      System.out.println("3.자동차 대출");
	      System.out.println();
	      
	      
	}
	
	//고객 > 대출추천 > 신용대출
	public static void creditLoan() {
	      
	      Scanner scan = new Scanner(System.in);
	      
	      System.out.println("<상품 유형>");
	      System.out.println("1.전체\t2.직장인\t3.전문직\t4.사업자\t5.연급수급자\t6.군인");
	      System.out.println();
	      
	      
	      System.out.println("<가입 방법>");
	      System.out.println("1.전체\t2.인터넷뱅킹\t3.스타뱅킹\t4.리브Next\t5.영업점\t6.스마트대출");
	      System.out.println();
	      
	}
	
	//고객 > 대출 > 대출조회
	public static void loanList() {
	      Data.loanload();
	      UI.subMenu("대출 상품 목록");
	      
	      
	      
	      for(Loan m : Data.loanlist) {
	         System.out.printf("%s. %s\n"
	                     ,m.getLoanno()
	                     ,m.getLoanname());
	      }
	}
	   
	
}
