package com.project;

import java.util.ArrayList;
import java.util.Scanner;

public class CreditLoanService {

	//고객 > 메인화면 > 대출조회/추천 > 대출 추천 > 신용대출
			public static void creditLoan() {
				boolean loop = true;
				Scanner scan = new Scanner(System.in);
				UI.subMenu("신용대출");
				System.out.println();
				
				//추천 알고리즘
				creditLoanCalculate();
				System.out.println("==============================");
				System.out.println();
				
				while(loop) {
					
					System.out.println("0. 이전으로");
					System.out.println("1. 신용대출 다시 추천받기");
					System.out.println();
					
					
					System.out.print("입력 : ");
					String sel = scan.nextLine();
					
					if(sel.equals("0")) {
						LoanService.loanRecommend();
					} else if (sel.equals("1")) {
						creditLoan();
					} else {
						System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
						System.out.println("==============================");
						System.out.println();
					}
				}
				
			}
			//추천 알고리즘
			public static void creditLoanCalculate() {
				Scanner scan = new Scanner(System.in);
				
				System.out.println("[상품 유형]");
				System.out.println("1.전체 \t 2.직장인 \t 3.전문직 \t 4.사업자 \t 5.연금수급자 \t 6.군인");
				System.out.print("상품 유형 번호 입력 : ");
				String input = scan.next();
				System.out.println();

				
				System.out.println();
				System.out.println("[가입 방법]");
				System.out.println("1.전체 \t 2.인터넷뱅킹 \t 3.스타뱅킹 \t 4.리브Next \t 5.영업점 \t 6.스마트대출");
			    System.out.print("가입 방법 번호 입력 : ");
				String input2 = scan.next();
				System.out.println();
				
				//추후 회원정보 삽입
//				System.out.println("----------------");
//				System.out.println("아무개 님과 적합한 대출 상품 추천");
//				System.out.println();
//				
				UI.recComment();
				
				//각각 조건 선택 ex) (상품유형:1 , 가입방법:1)
				if(input.equals("1") && input2.equals("1")) {
					typeAjoinA();
				}else if(input.equals("1") && input2.equals("2")) {
					typeAjoinI();
				}else if(input.equals("1") && input2.equals("3")) {
					typeAjoinS();
				}else if(input.equals("1") && input2.equals("4")) {
					typeAjoinL();
				}else if(input.equals("1") && input2.equals("5")) {
					typeAjoinShop();
				}else if(input.equals("1") && input2.equals("6")) {
					typeAjoinSmart();
				}
				
				if(input.equals("2") && input2.equals("1")) {
					typeOjoinA();
				}else if(input.equals("2") && input2.equals("2")) {
					typeOjoinI();
				}else if(input.equals("2") && input2.equals("3")) {
					typeOjoinS();
				}else if(input.equals("2") && input2.equals("4")) {
					typeOjoinL();
				}else if(input.equals("2") && input2.equals("5")) {
					typeOjoinShop();
				}else if(input.equals("2") && input2.equals("6")) {
					typeOjoinSmart();
				}
				
				if(input.equals("3") && input2.equals("1")) {
					typePjoinA();
				}else if(input.equals("3") && input2.equals("2")) {
					typePjoinI();
				}else if(input.equals("3") && input2.equals("3")) {
					typePjoinS();
				}else if(input.equals("3") && input2.equals("4")) {
					typePjoinL();
				}else if(input.equals("3") && input2.equals("5")) {
					typePjoinShop();
				}else if(input.equals("3") && input2.equals("6")) {
					typePjoinSmart();
				}
				
				if(input.equals("4") && input2.equals("1")) {
					typeBjoinA();
				}else if(input.equals("4") && input2.equals("2")) {
					typeBjoinI();
				}else if(input.equals("4") && input2.equals("3")) {
					typeBjoinS();
				}else if(input.equals("4") && input2.equals("4")) {
					typeBjoinL();
				}else if(input.equals("4") && input2.equals("5")) {
					typeBjoinShop();
				}else if(input.equals("4") && input2.equals("6")) {
					typeBjoinSmart();
				}
				
				if(input.equals("5") && input2.equals("1")) {
					typePensionJoinA();
				}else if(input.equals("5") && input2.equals("2")) {
					typePensionJoinI();
				}else if(input.equals("5") && input2.equals("3")) {
					typePensionJoinS();
				}else if(input.equals("5") && input2.equals("4")) {
					typePensionJoinL();
				}else if(input.equals("5") && input2.equals("5")) {
					typePensionJoinShop();
				}else if(input.equals("5") && input2.equals("6")) {
					typePensionJoinSmart();
				}
				
				if(input.equals("6") && input2.equals("1")) {
					typeArmyJoinA();
				}else if(input.equals("6") && input2.equals("2")) {
					typeArmyJoinI();
				}else if(input.equals("6") && input2.equals("3")) {
					typeArmyJoinS();
				}else if(input.equals("6") && input2.equals("4")) {
					typeArmyJoinL();
				}else if(input.equals("6") && input2.equals("5")) {
					typeArmyJoinShop();
				}else if(input.equals("6") && input2.equals("6")) {
					typeArmyJoinSmart();
				}
				
			}
			//상품유형 1 
			public static void typeAjoinA() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전체")|| Data.loanlist.get(i).getLoanperson().contains("직장인")||Data.loanlist.get(i).getLoanperson().contains("전문직")||Data.loanlist.get(i).getLoanperson().contains("사업자")|| Data.loanlist.get(i).getLoanperson().contains("연금수급자")||Data.loanlist.get(i).getLoanperson().contains("군인")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
				
			}
			
			public static void typeAjoinI() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if((Data.loanlist.get(i).getLoanperson().contains("전체")|| Data.loanlist.get(i).getLoanperson().contains("직장인")||Data.loanlist.get(i).getLoanperson().contains("전문직")||Data.loanlist.get(i).getLoanperson().contains("사업자")|| Data.loanlist.get(i).getLoanperson().contains("연금수급자")||Data.loanlist.get(i).getLoanperson().contains("군인"))&& Data.loanlist.get(i).getLoanjointype().equals("인터넷뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			
			public static void typeAjoinS() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if((Data.loanlist.get(i).getLoanperson().contains("전체")|| Data.loanlist.get(i).getLoanperson().contains("직장인")||Data.loanlist.get(i).getLoanperson().contains("전문직")||Data.loanlist.get(i).getLoanperson().contains("사업자")|| Data.loanlist.get(i).getLoanperson().contains("연금수급자")||Data.loanlist.get(i).getLoanperson().contains("군인"))&& Data.loanlist.get(i).getLoanjointype().contains("스타뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeAjoinL() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if((Data.loanlist.get(i).getLoanperson().contains("전체")|| Data.loanlist.get(i).getLoanperson().contains("직장인")||Data.loanlist.get(i).getLoanperson().contains("전문직")||Data.loanlist.get(i).getLoanperson().contains("사업자")|| Data.loanlist.get(i).getLoanperson().contains("연금수급자")||Data.loanlist.get(i).getLoanperson().contains("군인"))&& Data.loanlist.get(i).getLoanjointype().contains("리브Next")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeAjoinShop() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if((Data.loanlist.get(i).getLoanperson().contains("전체")|| Data.loanlist.get(i).getLoanperson().contains("직장인")||Data.loanlist.get(i).getLoanperson().contains("전문직")||Data.loanlist.get(i).getLoanperson().contains("사업자")|| Data.loanlist.get(i).getLoanperson().contains("연금수급자")||Data.loanlist.get(i).getLoanperson().contains("군인"))&& Data.loanlist.get(i).getLoanjointype().contains("영업점")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeAjoinSmart() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if((Data.loanlist.get(i).getLoanperson().contains("전체")|| Data.loanlist.get(i).getLoanperson().contains("직장인")||Data.loanlist.get(i).getLoanperson().contains("전문직")||Data.loanlist.get(i).getLoanperson().contains("사업자")|| Data.loanlist.get(i).getLoanperson().contains("연금수급자")||Data.loanlist.get(i).getLoanperson().contains("군인"))&& Data.loanlist.get(i).getLoanjointype().contains("스마트대출")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			
			//-------------------------------------------------------------------
			//상품유형 2
			public static void typeOjoinA() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("직장인")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}

			}
			
			public static void typeOjoinI() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("직장인") && Data.loanlist.get(i).getLoanjointype().contains("인터넷뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}

			}
			
			public static void typeOjoinS() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("직장인") && Data.loanlist.get(i).getLoanjointype().contains("스타뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}

			}
			
			public static void typeOjoinL() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("직장인") && Data.loanlist.get(i).getLoanjointype().contains("리브Next")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}

			}
			
			public static void typeOjoinShop() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("직장인") && Data.loanlist.get(i).getLoanjointype().contains("영업점")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}

			}
			
			public static void typeOjoinSmart() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("직장인") && Data.loanlist.get(i).getLoanjointype().contains("스마트뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}

			}
			
			//--------------------------------------------------------------
			//상품유형 3
			public static void typePjoinA() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전문직")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePjoinI() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전문직")&& Data.loanlist.get(i).getLoanjointype().contains("인터넷뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePjoinS() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전문직")&& Data.loanlist.get(i).getLoanjointype().contains("스타뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePjoinL() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전문직")&& Data.loanlist.get(i).getLoanjointype().contains("리브Next")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePjoinShop() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전문직")&& Data.loanlist.get(i).getLoanjointype().contains("영업점")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePjoinSmart() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("전문직")&& Data.loanlist.get(i).getLoanjointype().contains("스마트뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			//------------------------------------------------------------------
			////상품유형 4
			
			public static void typeBjoinA() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("사업자")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeBjoinI() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("사업자") &&Data.loanlist.get(i).getLoanjointype().contains("인터넷뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeBjoinS() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("사업자") && Data.loanlist.get(i).getLoanjointype().contains("스타뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeBjoinL() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("사업자") && Data.loanlist.get(i).getLoanjointype().contains("리브Next")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeBjoinShop() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("사업자") && Data.loanlist.get(i).getLoanjointype().contains("영업점")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeBjoinSmart() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("사업자") && Data.loanlist.get(i).getLoanjointype().contains("스마트대출")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			//------------------------------------------------------------
			//상품유형 5
			public static void typePensionJoinA() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("연금수급자")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			
			public static void typePensionJoinI() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("연금수급자") && Data.loanlist.get(i).getLoanjointype().contains("인터넷뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePensionJoinS() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("연금수급자") && Data.loanlist.get(i).getLoanjointype().contains("스타뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePensionJoinL() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("연금수급자") && Data.loanlist.get(i).getLoanjointype().contains("리브Next")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePensionJoinShop() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("연금수급자") && Data.loanlist.get(i).getLoanjointype().contains("영업점")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typePensionJoinSmart() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("연금수급자") && Data.loanlist.get(i).getLoanjointype().contains("스마트대출")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			//-----------------------------------------------------------------
			//상품유형 6
			public static void typeArmyJoinA() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("군인")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeArmyJoinI() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("군인") && Data.loanlist.get(i).getLoanjointype().contains("인터넷뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeArmyJoinS() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("군인") && Data.loanlist.get(i).getLoanjointype().contains("스타뱅킹")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeArmyJoinL() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("군인") && Data.loanlist.get(i).getLoanjointype().contains("리브Next")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeArmyJoinShop() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("군인") && Data.loanlist.get(i).getLoanjointype().contains("영업점")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
			
			public static void typeArmyJoinSmart() {
				int count = 1;
				ArrayList<Loan> temp = new ArrayList<Loan>();
				for(int i=0; i<Data.loanlist.size();i++) {
				 if(Data.loanlist.get(i).getLoantype().contains("신용대출")) {
					 
					 if(Data.loanlist.get(i).getLoanperson().contains("군인") && Data.loanlist.get(i).getLoanjointype().contains("스마트대출")) {
						 temp.add(Data.loanlist.get(i));
					 	}
				 	}
				}
				if(temp.size()==0) {
					System.out.println("조건을 만족하는 상품이 존재하지 않습니다");
				}else {
					for(Loan m : temp) {
						System.out.printf("%d.%s\n",count,m.getLoanname());
						count++;
					}
				}
			}
	
}// class