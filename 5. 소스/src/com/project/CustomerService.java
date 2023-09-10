package com.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 고객서비스 클래스입니다.
 *
 */

public class CustomerService {
	

	/**
	 * 고객 로그인
	 */
	//고객 로그인
	public static void customerLogin() {

		UI.subMenu("고객 로그인");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("고객 ID 입력: ");
		String cId = scan.nextLine();
		System.out.print("비밀번호 입력: ");
		String cPw = scan.nextLine();
		
		for(Customer m : Data.customerlist) {
			
			if (cId.equals(m.getId()) && cPw.equals(m.getPw())) {
				try {
		            FileWriter fw = new FileWriter(".\\dat\\회원\\로그인정보.txt");
		            BufferedWriter bw = new BufferedWriter(fw);

		            bw.write(m.getNo() + "," + m.getName() + "," + m.getJumin() + "," + m.getArmy() + "," + m.getTel() + "," + m.getId() + "," + m.getAccount() + "," + m.getPw() + "," + m.getMarried() + "," + m.getPoor() + "," + m.getJob() + "," + m.getGoods() + "," + m.getSavings() + "," + m.getLoan() + "," + m.getCheckCard() + "," + m.getCreditCard()) ;
		            
		            bw.close();
		            fw.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				customerMain();
			}
			
		}
		
		System.out.println("고객 ID 또는 비밀번호가 틀렸습니다.");
		System.out.println("메인메뉴로 돌아가시겠습니까?");
		System.out.println("1. 네\t\t2. 아니요");
		String sel = scan.nextLine();
		if (sel.equals("1")) {
			UI.goMain();
		} else if (sel.equals("2")) {
			customerLogin();
		} 
		
		
	}

	/**
	 * 고객 메인화면
	 */
	//고객 메인화면
	public static void customerMain() {
		
		UI.subMenu("고객-메인화면");
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 적금 조회/추천");
		System.out.println("2. 대출 조회/추천");
		System.out.println("3. 카드 조회/추천");
		System.out.println("4. 가입한 상품 조회");
		System.out.println("0. 로그아웃");
		
		System.out.print("선택: ");
		String sel = scan.nextLine();
		
		while (loop) {
			if (sel.equals("1")) {
				SavingService.savMain();
			} else if (sel.equals("2")) {
				LoanService.loanMain();
			} else if (sel.equals("3")) {
				CardService.cardMain();
			} else if (sel.equals("4")) {
				customerGoods();
			} else if (sel.equals("0")) {
				UI.goMain();
			} else {
				System.out.println("숫자를 다시 입력해주세요.");
				customerMain();
			}
		}
		
	}

	/**
	 * 가입된 상품 조회
	 */
	private static void customerGoods() {
		
		UI.subMenu("고객-메인화면-가입된 상품 조회");
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		for(Login m : Data.customerInfo) {
			if(m.getGoods().equals("0")) {
				System.out.println("가입된 상품이 없습니다.");
			} else if(m.getGoods().equals("1")) {
				System.out.print("적금: \t\t" + m.getSavings() + "\t");
				for (Savings s : Data.List) {
					if(m.getSavings().equals(s.getSavNO())) {
						System.out.println(s.getSavName());
					}
				}
				System.out.print("대출: \t\t" + m.getLoan() + "\t");
				for (Loan l : Data.loanlist) {
					if(m.getLoan().equals(l.getLoanno())) {
						System.out.println(l.getLoanname());
					}
				}
				System.out.print("체크 카드: \t" + m.getCheckCard() + "\t");
				for (Debit d : Data.debitlist) {
					if(m.getCheckCard().equals(d.getNo())) {
						System.out.println(d.getCardname());
					}
				}
				System.out.print("신용 카드: \t" + m.getCreditCard() + "\t");
				for (Credit c : Data.creditlist) {
					if(m.getCreditCard().equals(c.getNo())) {
						System.out.println(c.getCardName());
					}
				}
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("0. 이전으로");
		String sel = scan.nextLine();
		if (sel.equals("0")) {
			customerMain();
		} else {
			System.out.println("숫자를 다시 입력해주세요.");
		}
		
		
		
		
	}

}
