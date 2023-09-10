package com.project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoanManagerService {
 
	
	public static void loanList() {
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		
		UI.subMenu("대출 상품 목록");
		
		System.out.println("[상품번호. 상품명]\n[신청자격]\n[이벤트상품]\t[대출종류]\t[가입방법]\t[적용금리]\t[최장기간]\t[최고대출금액]\t[상환방법]\n\n");
		
		for (Loan l : Data.loanlist) {
			
			System.out.printf("[%s. %s]"
							+ "\n%s\n"
							+ "%s\t%s\t%s\t%s(%%)\t\t%s\t\t%,d원\t%s\n"
							, l.getLoanno()
							, l.getLoanname()
							, l.getLoanperson()
							, l.getLoanevent().equals("0") ? "일반상품" : "이벤트상품"
							, l.getLoantype()
							, l.getLoanjointype()
							, l.getLoanrate()
							, l.getLoanmaxperiod()
							, Integer.parseInt(l.getLoanmaxamount())
							, l.getLoanrepaytype());
			
			System.out.println();
		
		}
		
		while(loop) {
			
			System.out.println("==============================");
			System.out.println("1. 대출 상품 제거");
			System.out.println("0. 이전으로");
			System.out.println();
			
			System.out.print("번호 입력 : ");
			String sel = scan.nextLine();
			
			if (sel.equals("0")) {
				LoanManager.loanManagerMain();
			} else if (sel.equals("1")) {
				LoanManagerService.loanDelete();
			} else {
				System.out.println("숫자를 잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
		
		
	}//loanList

	public static void loanDelete() {
		
		UI.subMenu("대출 상품 제거");
		
		boolean loop = true;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("제거할 상품 번호 입력 : ");
		String sel = scan.nextLine();
		System.out.println();
		
		
		for (Loan l : Data.loanlist) {
			
			if (l.getLoanno().equals(sel)) {
				
				Data.loanlist.remove(l); //방번호, 요소로 삭제 가능
				System.out.println("삭제가 완료되었습니다.");
				count++;
				break;
			} 
		}
		
		if (count == 0) {
			System.out.println("삭제에 실패했습니다. 번호를 올바르게 입력해주세요.");
		}
		
		Data.loanSave();
		
		
		while(loop) {
			System.out.println("==============================");
			System.out.println("1. 다시 삭제하기");
			System.out.println("0. 이전으로");
			System.out.println();
			
			System.out.print("번호 입력 : ");
			String sel2 = scan.nextLine();
		
			if (sel2.equals("1")) {
				LoanManagerService.loanDelete();
			} else if (sel2.equals("0")){
				LoanManagerService.loanList();
			} else {
				System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
				System.out.println();
			}
			
		}
		
	}//loanDelete

	
	public static void loanAdd() {
		
		UI.subMenu("대출 상품 추가");
		
		Scanner scan = new Scanner(System.in);
		
		String no = Data.loanlist.stream()
						 .mapToInt(l -> Integer.parseInt(l.getLoanno()))
						 .max().getAsInt() 
						 + 1 + "";
		
		System.out.print("0. 이벤트 상품 여부(0. 일반 상품 1. 이벤트 상품) 번호 입력 : ");
		String event = scan.nextLine();	
		
		System.out.print("1. 대출종류 (1. 신용대출 2. 전월세/반환보증 3. 자동차대출) 번호 입력 : ");
		String type = scan.nextLine();
		
		System.out.print("2. 상품명 입력 : ");
		String name = scan.nextLine();
		
		System.out.print("3. 신청자격 입력 : ");
		String person = scan.nextLine();
		
		System.out.print("4. 가입방법 (1. 인터넷뱅킹 2. 스타뱅킹 3. 리브Next 4. 영업점 5. 스마트대출) 번호 입력 : ");
		String join = scan.nextLine();
		
		System.out.print("5. 적용금리(%) 입력 : ");
		String rate = scan.nextLine();
		
		System.out.print("6. 계약기간(년) 입력 : ");
		String period = scan.nextLine();
		
		System.out.print("7. 최고대출금액(원) 입력 : ");
		String amount = scan.nextLine();
		
		System.out.print("8. 상환방법 입력 (ex. 일시상환, 만기일시상환, 원금균등, 원리금균등상환) : ");
		String repay = scan.nextLine();
		
		System.out.println();
		
		if (isValid(event, type, name, person, join, rate, period, amount, repay)) {

			type = type.equals("1") ? "신용대출" :  type.equals("2") ? "전월세/반환보증" : type.equals("3") ? "자동차대출" : "";
			join = join.equals("1") ? "인터넷뱅킹" :  join.equals("2") ? "스타뱅킹" : join.equals("3") ? "리브Next"  : join.equals("4") ? "영업점" : join.equals("5") ? "스마트대출" : "";
			
			Loan l = new Loan(event, type, no, name, person, join, rate, period + "년", amount, repay);
			
			Data.loanlist.add(l);
			
			System.out.println("추가가 완료되었습니다.");
			
		} else {
			//System.out.println("추가를 실패했습니다.");
		}
		
		Data.loanSave();
		
		
		boolean loop = true;
		while(loop) {
			System.out.println("==============================");
			System.out.println("1. 다시 추가하기");
			System.out.println("0. 이전으로");
			System.out.println();
			
			System.out.print("번호 입력 : ");
			String sel = scan.nextLine();
		
			if (sel.equals("1")) {
				LoanManagerService.loanAdd();
			} else if (sel.equals("0")){
				LoanManager.loanManagerMain();
			} else {
				System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
		
	}//loanAdd

	private static boolean isValid(String event, String type,String name, String person, String join, String rate,
			String period, String amount, String repay) {
		
		String regex = "";		//정규식
		Pattern pattern = null;	//정규식 객체
		Matcher matcher = null;	//결과 객체
		
		//0. 이벤트 상품 여부 > 0 ~ 1번 이내
		regex = "^[0-1]$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(event);	
		
		if (!matcher.find()) {
			System.out.println("이벤트 상품 여부 입력이 잘못되었습니다. 0~1번 중에서 선택하세요.");
			return false;
		} 
		
		//1. 대출 종류 > 1 ~ 3번 이내
		regex = "^[1-3]$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(type);	
		
		if (!matcher.find()) {
			System.out.println("대출종류 입력이 잘못되었습니다. 1~3번 중에서 선택하세요.");
			return false;
		} 
		
		//2. 상품명 > 한글, 영대소문자, 숫자
		regex = "^[A-Za-z0-9가-힣]{1,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(name);
		
		if (!matcher.find()) {
			System.out.println("상품명 입력이 잘못되었습니다. 한글, 영대소문자, 숫자만 입력하세요.");
			return false;
		}
		
		//3. 신청자격 > 한글, 영대소문자
		regex = "^[A-Za-z가-힣]{1,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(person);
		
		if (!matcher.find()) {
			System.out.println("신청자격 입력이 잘못되었습니다. 한글, 영대소문자만 입력하세요.");
			return false;
		}
		
		//4. 가입방법 > 1 ~ 5번 이내
		regex = "^[1-5]$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(join);	
		
		if (!matcher.find()) {
			//한글로 된 2~5자를 못찾았습니다
			System.out.println("가입방법 입력이 잘못되었습니다. 1~5번 중에서 선택하세요.");
			return false;
		} 
		
		//5. 적용금리 > ".", 숫자
		regex = "^[0-9.]{1,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(rate);	
		
		if (!matcher.find()) {
			//한글로 된 2~5자를 못찾았습니다
			System.out.println("적용금리 입력이 잘못되었습니다. 숫자만 입력하세요.");
			return false;
		} 
		
		//6. 계약기간 > 숫자만
		regex = "^[0-9]{1,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(period);	
		
		if (!matcher.find()) {
			//한글로 된 2~5자를 못찾았습니다
			System.out.println("계약기간 입력이 잘못되었습니다. 숫자만 입력하세요.");
			return false;
		} 
				
		//7. 최고대출금액 > 숫자만
		regex = "^[0-9]{1,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(amount);	
		
		if (!matcher.find()) {
			//한글로 된 2~5자를 못찾았습니다
			System.out.println("최고대출금액 입력이 잘못되었습니다. 숫자만 입력하세요.");
			return false;
		} 
		
		//8. 상환방법 > 한글, 영대소문자
		regex = "^[A-Za-z가-힣]{1,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(repay);	
		
		if (!matcher.find()) {
			//한글로 된 2~5자를 못찾았습니다
			System.out.println("상환방법 입력이 잘못되었습니다. 한글, 영대소문자만 입력하세요.");
			return false;
		} 
		
		return true;
	}
	
	
	
	
	
	
}//LoanManangerService class












