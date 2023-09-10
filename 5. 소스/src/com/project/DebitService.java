package com.project;

import java.util.Scanner;

public class DebitService {
	
	//체크카드 내용 출력 
	public static void debitList() {
			
		Data.debitlist.clear();
		Data.loadDebit();
		Scanner scan = new Scanner(System.in);

		boolean loop = true;
		boolean manager =true;
		for(Debit d : Data.debitlist) {
			System.out.println();
			System.out.printf("%s. %s\r",d.getNo(),d.getCardname());
			System.out.printf("혜택: %s\r",d.getBenefit());
			System.out.println();
		}
		UI.backSapce();
		System.out.print("숫자 입력: ");
		String input2 =scan.nextLine();
		
		if(input2.equals("0")) {
			CardService.cardMain();
		}else {
			Data.loadDebitD(input2);
			debitD(input2);
			UI.backSapce();
			Data.debit_d.clear();
			System.out.print("숫자입력: ");
			String input3 =scan.nextLine();
			while(loop) {
				if(input3.equals("0")) {
					debitList();
					loop=false;
				}
				else {
					System.out.println("올바른 숫자를 입력하세요.");
					System.out.print("숫자입력: ");
					input3 = scan.nextLine();
				}
			}
		}
	}
	
	//상세내용 개별 출력
	public static void debitD(String input) {
		
		for(Debit d : Data.debitlist) {
			if(d.getNo().equals(input)) {
				for(Debit dd : Data.debit_d) {
					System.out.printf("%s\r",dd.getdBenefit());	
				
				}
				break;
			}
		}
	}
	
	public static void recommend(int age) {
		//refresh
		Data.debitlist.clear();
		Data.loadDebit();
		Data.customerlist.clear();
		Data.loadCustomer();
		int max = 0;
		int count =0;
		int no = 0;
		String z=" ";
		
		String[] a = new String[Data.customerlist.size()+1];
		Integer[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (int i = 1; i < Data.customerlist.size()+1; i++) { 
			if(Data.customerlist.get(i-1).getJumin().substring(0,2).compareTo("23")>=1) {
				a[i]="19"+Data.customerlist.get(i-1).getJumin().substring(0,2);//97 or 00 등등..
			}
			else {
				a[i]="20"+Data.customerlist.get(i-1).getJumin().substring(0,2);
			}
		}
		for (int j = 1; j < a.length; j++) {// 501개 0~ 500      
			if((2023-Integer.parseInt(a[j])>=age) && ((2023-Integer.parseInt(a[j])<(age+10)))) {
				for(Customer c : Data.customerlist) { //유저 리스트에서 
					for (int i = 0; i <= 30; i++) {
						if(Integer.parseInt(c.getNo())==j&&Integer.parseInt(c.getCheckCard())==i) {
							result[i]++;
						}
					}
				}
			}
			
		}
		for (int i = 1; i < result.length; i++) {
			max=result[1];
			if(result[i]>max) {
				max= result[i];
				no= i;
				z = i+"번카드 "+Data.debitlist.get(i-1).getCardname();
			}
			else if(result[i]==max) {
				z += "\r"+i+"번카드 "+Data.debitlist.get(i-1).getCardname();
			}
		}
		if(max==0) {
			System.out.println("해당 데이터가 존재하지 않습니다.");
		}
		else {
			UI.subMenu(age+"대가 가장 많이 가입한 카드상품");
			System.out.println(age+"대의 가장 많은 고객이 가입한 상품은");
			System.out.println(z+"이며 "+max+"명 가입했습니다.");
			System.out.println();
		}
		System.out.println("1.카드 목록보기");
		Scanner scan = new Scanner(System.in);
		UI.backSapce();
		System.out.print("숫자입력: ");
		String input = scan.nextLine();
		if(input.equals("1")) {
			DebitService.debitList();
		}
		else if(input.equals("0")) {
			CardService.cardMain();
		}
	
	}
	
}
