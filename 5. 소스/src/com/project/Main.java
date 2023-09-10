package com.project;

import java.util.Scanner;


public class Main {

public static void main(String[] args) throws Exception{
		
		//프로그램 시작
		Data.List.clear();
		Data.creditlist.clear();
		Data.customerlist.clear();
		Data.debitlist.clear();
		Data.loanlist.clear();
		Data.managerlist.clear();
		Data.loanload();
		Data.loadCustomer();
		Data.loadManager();
		Data.loadLogin();
		Data.savLoad();
		Data.loadCredit();
		Data.loadDebit();
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		UI.mainMenu();
		
		while (loop) {
			
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				ManagerService.managerlogin();
			} else if (sel.equals("2")) {
				CustomerService.customerLogin();
			} else if (sel.equals("3")) {
				SignupService.signup();
			} else if (sel.equals("4")){
				loop = false;
			} else {
				System.out.println("숫자를 다시 입력해주세요. ");
			}
			
		}//while(menu)
		
		System.out.println("프로그램을 종료합니다.");
			
			
			
		
	}
	
}
