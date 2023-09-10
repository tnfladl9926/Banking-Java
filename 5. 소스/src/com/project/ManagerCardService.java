package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ManagerCardService {
	public static void mCardMain() {
		Data.creditlist.clear();  //refresh
		Data.loadCredit();
		Data.debitlist.clear();
		Data.loadDebit();
		UI.mCardMain();//"카드 상품 목록","카드 상품 추가","카드 상품 삭제","뒤로가기"
		UI.backSapce();
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요.: ");
		String input = scan.nextLine();
		if(input.equals("1")) {
			UI.subMenu("카드 상품 목록");
			System.out.println("1.체크카드");
			System.out.println("2.신용카드");
			System.out.println("0.뒤로가기");
			System.out.print("숫자입력: ");
			
			String input2 = scan.nextLine();
			
			if(input2.equals("0")) {
				mCardMain();
			}	
			else if(input2.equals("1")) {
				mList("debit");
			}//체크카드
			else if(input2.equals("2")) {
				mList("credit");	
			}//신용카드
		}else if(input.equals("2")) {
			UI.subMenu("카드 상품 추가");
			System.out.println("1.체크카드");
			System.out.println("2.신용카드");
			System.out.println("0.뒤로가기");
			System.out.print("숫자입력: ");
			String input2 = scan.nextLine();
			if(input2.equals("1")) {
				debitAdd();
				System.out.println("추가성공");
				System.out.println("카드 상품 관리화면으로 이동합니다.");
				mCardMain();
			}else if(input2.equals("2")) {
				creditAdd();
				System.out.println("추가 성공");
				System.out.println("카드 상품 관리화면으로 이동합니다.");
				mCardMain();
			}else if(input2.equals("0")) {
				mCardMain();
			}
		}else if(input.equals("0")){
			ManagerService.goodsmanagement();
		}
	}
	
	private static void mList(String string) {
		Scanner scan = new Scanner(System.in);

		if(string.equals("debit")) {
			UI.subMenu("체크카드");
			for(Debit md : Data.debitlist) {
				System.out.printf("%s. %s\r",md.getNo(),md.getCardname());
			}
			UI.backSapce();
			System.out.print("숫자 입력: ");//상세정보를 받을 번호 입력
			String input3 = scan.nextLine();
			
			//유효성검사
//			CardService.inputVerify("30",input3);
			if(input3.equals("0")) {
				mCardMain();
			}				
			else {
				Data.loadDebitD(input3);//input3에 대한 상세정보 가져오기
				DebitService.debitD(input3);
				Data.debit_d.clear();
				System.out.println("1.상품 제거");
				UI.backSapce();
	
				System.out.print("숫자입력: ");
				String input4 =scan.nextLine();
				if(input4.equals("0")) {
					mList("debit");
				}else if(input4.equals("1")){
					debitDelete(input3);
					System.out.println("삭제성공");
					System.out.println("카드 상품 관리화면으로 이동합니다.");
					mCardMain();
				}
			}
		}else {
			UI.subMenu("신용카드");
			for(Credit mc : Data.creditlist) {
				System.out.printf("%s. %s\r",mc.getNo(),mc.getCardName());
				}
			UI.backSapce();
			
			System.out.print("숫자 입력: ");//상세정보를 받을 번호 입력
			String input3 = scan.nextLine();
			
//			CardService.inputVerify("30",input3);
			if(input3.equals("0")) {
				mCardMain();
			}
			else {
				Data.loadCreditD(input3);
				CreditService.creditD(input3);
				Data.credit_d.clear();
				System.out.println("1.상품 제거");
				UI.backSapce();
				
				System.out.print("숫자입력: ");
				String input4 =scan.nextLine();
				if(input4.equals("0")) {
					mList("credit");
				}else if(input4.equals("1")){
					creditDelete(input3);
					System.out.println("삭제성공");
					System.out.println("카드 상품 관리화면으로 이동합니다.");
					mCardMain();
				}
			}
		}//신용카드
	}
	
	private static void debitDelete(String input3) {
		String dummy = "";

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Data.DEBIT)));
		
			//1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
			String line;
			for(int i=0; i<Integer.parseInt(input3)-1; i++) {
			    line = br.readLine(); //읽으며 이동
			    dummy += (line + "\r\n" ); 
			}
			
			//2. 삭제하고자 하는 데이터는 건너뛰기
			String delData = br.readLine();
			
			//3. 삭제하고자 하는 position 이후부터 dummy에 저장
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}
			//4. FileWriter를 이용해서 덮어쓰기

			FileWriter fw = new FileWriter(Data.DEBIT);
			fw.write(dummy);	
			fw.close();
			br.close();
			
		} catch (Exception e) {

			// TODO Auto-generated catch block
			
			e.printStackTrace();

		}
	}

	private static void creditDelete(String input3) {
		String dummy = "";

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Data.CREDIT)));
		
			//1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
			String line;
			
			for(int i=0; i<Integer.parseInt(input3)-1; i++) {
			    line = br.readLine(); //읽으며 이동
			    dummy += (line + "\r\n" ); 
			}
			
			//2. 삭제하고자 하는 데이터는 건너뛰기
			String delData = br.readLine();
			
			//3. 삭제하고자 하는 position 이후부터 dummy에 저장
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}
			//4. FileWriter를 이용해서 덮어쓰기

			FileWriter fw = new FileWriter(Data.CREDIT);
			fw.write(dummy);	
			fw.close();
			br.close();
			
		} catch (Exception e) {

			// TODO Auto-generated catch block
			System.out.println("삭제에 실패했습니다.");
			e.printStackTrace();

		}
	}
	public static void creditAdd() {
		Data.creditlist.clear();
		Data.loadCredit();
		Scanner scan = new Scanner(System.in);

		System.out.print("1.카드 번호: ");
		String no = scan.nextLine();
		for(Credit md : Data.creditlist) {
			if(no.equals(md.getNo())) {//같으면
				System.out.println("목록에 없는 번호를 입력해주세요.");
				creditAdd();	
			}
		}
		System.out.print("2.카드 이름: ");
		String name = scan.nextLine();
		System.out.println();
		System.out.print("3.연회비: ");
		String annual = scan.nextLine();
		System.out.println();
		System.out.print("4.전 월 실적: ");
		String pre = scan.nextLine();
		System.out.println();
		System.out.print("5.요약된 혜택: ");
		String benefit = scan.nextLine();
		System.out.println();
		System.out.print("6.상세 혜택: ");
		String dBenefit = scan.nextLine();
		System.out.print("7.이벤트여부(o,x): ");
		String event = scan.nextLine();
		System.out.println();

		String dummy ="";

		try {
//			추가 파일 생성
			File file = new File(Data.CREDIT_D+no+".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String temp[] =dBenefit.split("/");
			for (int i = 0; i < temp.length; i++) {
				writer.write(temp[i]+"\r\n");
			}
			writer.close();
			
//			카드상품 목록에 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Data.CREDIT)));
			//1. 추가하고자 하는 position 이전까지는 이동하며 dummy에 저장
			String line;
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}
			dummy+= event+","+"신용카드,"+no+","+name+","+annual+","+pre+","+benefit;
			//4. FileWriter를 이용해서 덮어쓰기

			FileWriter fw = new FileWriter(Data.CREDIT);
			fw.write(dummy);	
			fw.close();
			br.close();
			
		} catch (Exception e) {

			// TODO Auto-generated catch block
			System.out.println("삭제에 실패했습니다.");
			e.printStackTrace();

		}

		
	}
	public static void debitAdd() {
		Scanner scan = new Scanner(System.in);
		Data.debitlist.clear();
		Data.loadDebit();
		System.out.print("1.카드 번호: ");
		String no = scan.nextLine();
		for(Debit md : Data.debitlist) {
			if(no.equals(md.getNo())) {//같으면
				System.out.println("목록에 없는 번호를 입력해주세요.");
				debitAdd();	
			}
		}
		System.out.print("2.카드 명: ");
		String name = scan.nextLine();
		System.out.println();
		System.out.print("3.신청 자격: ");
		String qualified = scan.nextLine();
		System.out.println();
		System.out.print("4.키워드: ");
		String benefit = scan.nextLine();
		System.out.println();
		System.out.print("5.상세 혜택(\',\'로구분,한줄로 작성):");
		String dBenefit = scan.nextLine();
		System.out.print("6.이벤트여부(o,x): ");
		String event = scan.nextLine();
		System.out.println();

		String dummy ="";

		try {
//			추가 파일 생성
			File file = new File(Data.DEBIT_D+no+".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String[] temp=dBenefit.split(",");
	
			writer.write(no+"."+name+"\r\n");
			writer.write("---------------------------------------------상세 보기--------------------------------------------\r\n");
			for (int i = 0; i < temp.length; i++) {
				writer.write(temp[i]+"\r\n");
			}
			writer.write("--------------------------------------------------------------------------------------------------\r\n");
			writer.close();
			
//			카드상품 목록에 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Data.DEBIT)));
			//1. 추가하고자 하는 position 이전까지는 이동하며 dummy에 저장
			String line;
			
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}
			dummy+= event+","+"체크카드,"+no+","+name+","+qualified+","+benefit;
			//4. FileWriter를 이용해서 덮어쓰기

			FileWriter fw = new FileWriter(Data.DEBIT);
			fw.write(dummy);	
			fw.close();
			br.close();
			
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		
	}
}

