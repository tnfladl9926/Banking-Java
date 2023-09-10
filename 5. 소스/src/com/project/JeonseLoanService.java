package com.project;

import java.util.Scanner;

public class JeonseLoanService {

	public static void jeonseLoan() {
			
		UI.subMenu("전월세/반환보증 대출 추천");
		
		System.out.println("[상품 유형]");
		System.out.println("1. 전체\t 2. 전월세보증금대출\t3. 월세대출\t4. 전세금반환대출\n");
		System.out.println("[가입 방법]");
		System.out.println("1. 전체\t 2. 인터넷뱅킹\t3. 스타뱅킹\t4. 리브Next\t5. 영업점\t6. 스마트대출\n");
		
		Scanner scan = new Scanner(System.in);
		
		int count = 1;
		boolean loop = true;
		
		while (loop) {
			System.out.print("상품 유형 번호입력 : ");
			String typeSel = scan.nextLine();
			
			System.out.print("가입 방법 번호입력 : ");
			String joinSel = scan.nextLine();
			
			
			if (typeSel.equals("1")) {		//상품유형 1. 전체
				
				if (joinSel.equals("1")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("2")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && l.getLoanjointype().equals("인터넷뱅킹")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("3")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && l.getLoanjointype().equals("스타뱅킹")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("4")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && l.getLoanjointype().equals("리브Next")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						} 
					}
					break;
					
				}  else if (joinSel.equals("5")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && l.getLoanjointype().equals("영업점")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("6")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && l.getLoanjointype().equals("스마트대출")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else {
					System.out.println("가입 방법 번호를 잘못입력했습니다. 다시 선택해주세요.\n");
				}
				
			} else if (typeSel.equals("2")) {	//상품유형 2.전월세보증금대출
				
				if (joinSel.equals("1")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && !(l.getLoanname().contains("월세")) && !(l.getLoanname().contains("반환"))) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("2")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && !(l.getLoanname().contains("월세")) && !(l.getLoanname().contains("반환")) && l.getLoanjointype().equals("인터넷뱅킹")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("3")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && !(l.getLoanname().contains("월세")) && !(l.getLoanname().contains("반환")) && l.getLoanjointype().equals("스타뱅킹")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("4")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && !(l.getLoanname().contains("월세")) && !(l.getLoanname().contains("반환")) && l.getLoanjointype().equals("리브Next")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("5")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && !(l.getLoanname().contains("월세")) && !(l.getLoanname().contains("반환")) && l.getLoanjointype().equals("영업점")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("6")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && !(l.getLoanname().contains("월세")) && !(l.getLoanname().contains("반환")) && l.getLoanjointype().equals("스마트대출")) {
								
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
				} else {
					System.out.println("가입 방법 번호를 잘못입력했습니다. 다시 선택해주세요.\n");
				}
				
			} else if (typeSel.equals("3")) {	//상품유형 3.월세대출
				
				if (joinSel.equals("1")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("월세"))) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("2")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("월세")) && l.getLoanjointype().equals("인터넷뱅킹")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("3")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("월세")) && l.getLoanjointype().equals("스타뱅킹")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("4")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("월세")) && l.getLoanjointype().equals("리브Next")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
						
					}
					break;
					
				} else if (joinSel.equals("5")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("월세")) && l.getLoanjointype().equals("영업점")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else if (joinSel.equals("6")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("월세")) && l.getLoanjointype().equals("스마트대출")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
				} else {
					System.out.println("가입 방법 번호를 잘못입력했습니다. 다시 선택해주세요.\n");
				}
				
			} else if (typeSel.equals("4")) {	//상품유형 4.전세금반환대출
				
				if (joinSel.equals("1")) {
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("반환"))) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("2")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("반환")) && l.getLoanjointype().equals("인터넷뱅킹")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("3")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("반환")) && l.getLoanjointype().equals("스타뱅킹")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("4")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("반환")) && l.getLoanjointype().equals("리브Next")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("5")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("반환")) && l.getLoanjointype().equals("영업점")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				}  else if (joinSel.equals("6")) {
					
					UI.recComment();
					for (Loan l : Data.loanlist) {
						
						if(l.getLoantype().equals("전월세/반환보증") && (l.getLoanname().contains("반환")) && l.getLoanjointype().equals("스마트대출")) {
							
							System.out.printf("%d. %s",count, l.getLoanname());
							count++;
							System.out.println();
						}
					}
					break;
					
				} else {
					System.out.println("가입 방법 번호를 잘못입력했습니다. 다시 선택해주세요.\n");
				}
				
			} else {
				System.out.println("상품 유형 번호를 잘못입력했습니다. 다시 선택해주세요.\n");
			}
		}
		System.out.println("==============================");
		System.out.println();
		
		while (true) {
			
			System.out.println("0. 이전으로");
			System.out.println("1. 전월세/반환보증 대출 다시 추천받기");
			System.out.println();
			System.out.print("입력 : ");
			String sel = scan.nextLine();
			
			if (sel.equals("0")) {
				LoanService.loanRecommend();
				
			} else if (sel.equals("1")) {
				jeonseLoan();
				
			} else {
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
				System.out.println("==============================");
				System.out.println();
			}
		}
	
	} //jeonseLoan
	
	

} //JeonseLoanService class













