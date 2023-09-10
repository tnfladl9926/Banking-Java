package com.project;

import java.util.Scanner;

/**
 * 회원가입하는 클래스
 */
public class SignupService {

	/**
	 * 회원가입하는 메소드입니다.
	 */
	//회원 가입
	public static void signup() {
		
		//회원가입하기
		//- 회원가입 > ArrayList<Customer>에 추가
		
		UI.subMenu("회원가입");
		
		Scanner scan = new Scanner(System.in);
		
		
		
		String no = Data.customerlist.stream()
							 .mapToInt(m -> Integer.parseInt(m.getNo()))
							 .max().getAsInt() 
							 + 1 + "";
		
		System.out.print("이름(한글2~5자): ");
		String name = scan.nextLine();
		if (!rightName(name)) {
			retry();
		}
		System.out.print("주민등록번호(‘-’포함): ");
		String jumin = scan.nextLine();
		if (!rightJumin(jumin)) {
			retry();
		}
		System.out.print("전화번호(‘-’포함): ");
		String tel = scan.nextLine();
		if (!rightTel(tel)) {
			retry();
		}
		System.out.print("아이디(영문자+숫자,8~16자): ");
		String id = scan.nextLine();
		if (!rightId(id)) {
			retry();
		}
		System.out.print("계좌번호(XXXXXX-XX-XXXXXX): ");
		String account = scan.nextLine();
		if (!rightAccount(account)) {
			retry();
		}
		System.out.print("비밀번호(영문자+숫자): ");
		String pw = scan.nextLine();
		if (!rightPw(pw)) {
			retry();
		}
		System.out.println("군인 1. 복무중\t\t2. 군필\t\t3. 미필");
		System.out.print("선택(여자는 3번선택): ");
		String army = scan.nextLine();
		if (!rightArmy(army)) {
			retry();
		}
		System.out.println("기혼여부 0. x\t\t1. o");
		System.out.print("선택: ");
		String married = scan.nextLine();
		if (!rightMarried(married)) {
			retry();
		}
		System.out.println("기초생활 수급자 0. x\t\t1. o");
		System.out.print("선택: ");
		String poor = scan.nextLine();
		if (!rightPoor(poor)) {
			retry();
		}
		System.out.println("직장 0. x\t\t1. o");
		System.out.print("선택: ");
		String job = scan.nextLine();
		if (!rightJob(job)) {
			retry();
		}
		System.out.println("가입되어있는 상품 0. x\t\t1. o");
		System.out.print("선택: ");
		String goods = scan.nextLine();
		if (!rightGoods(goods)) {
			retry();
		}
		
		
		
		Customer m = new Customer(no, name, jumin, army, tel, id, account, pw, married, poor, job, goods,null,null,null,null);
		Data.customerlist.add(m); //고객정보 추가
		
		Data.saveCustomer();
		
		System.out.println("회원가입 완료!");
		UI.goMain();
		
	}
	
	/**
	 * 잘못된 입력을 하면 되돌아가는 메소드입니다.
	 */
	//다시입력
	private static void retry() {
		System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		signup();
	}
	
	/**
	 * 기혼 유효성 검사 메소드입니다.
	 * @param 기혼여부
	 */
	//기혼 유효성 검사
	private static boolean rightMarried(String married) {
		
		if (!married.matches("^[01]$")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 기초생활 수급자 유효성 검사 메소드입니다.
	 * @param 기초생활수급자여부
	 */
	//기초생활 수급자 유효성 검사
	private static boolean rightPoor(String poor) {
			
		if (!poor.matches("^[01]$")) {
			return false;
		}
		
		return true;
	}

	/**
	 * 직장 유효성 검사 메소드입니다.
	 * @param 직장여부
	 */
	//직장 유효성 검사
	private static boolean rightJob(String job) {
		
		if (!job.matches("^[01]$")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 가입되어 있는 상품 유효성 검사입니다.
	 * @param 가입되어 있는 상품 여부
	 */
	//가입되어 있는 상품 유효성 검사
	private static boolean rightGoods(String goods) {
		
		if (!goods.matches("^[01]$")) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 군인 유효성 검사 메소드입니다.
	 * @param 군인 상태
	 */
	//군인 유효성 검사
	private static boolean rightArmy(String army) {
		
		if (!army.matches("^[123]$")) {
			return false;
		}
		
		return true;
	}

	/**
	 * 이름 유효성 검사 메소드입니다.
	 * @param 이름
	 */
	//이름 유효성 검사
	private static boolean rightName(String name) {
		
		String pattern = "^[가-힣]{2,5}$";
		
		return name.matches(pattern);
		
	}

	/**
	 * 주민등록번호 유효성 검사 메소드입니다.
	 * @param 주민번호
	 */
	//주민등록번호 유효성 검사
	private static boolean rightJumin (String jumin) {
	    // 입력된 주민등록번호에서 -를 제거
		jumin = jumin.replaceAll("-", "");
		
	    // 입력된 주민등록번호가 13자리가 아니면 유효하지 않음
	    if (jumin.length() != 13) {
	        return false;
	    }

	    // 숫자로 이루어져 있지 않으면 유효하지 않음
	    if (!jumin.matches("[0-9]+")) {
	        return false;
	    }

	    return true;
	}

	/**
	 * 전화번호 유효성 검사 메소드입니다.
	 * @param tel
	 * @return
	 */
	//전화번호 유효성 검사
	private static boolean rightTel(String tel) {
	    // 입력된 전화번호에서 -를 제거
		tel = tel.replaceAll("-", "");
		
		// 전화번호가 11자리가 아니면 유효하지 않음
	    if (tel.length() != 11) {
	        return false;
	    }

	    // 숫자로 이루어져 있지 않으면 유효하지 않음
	    if (!tel.matches("[0-9]+")) {
	        return false;
	    }

	    // 앞 3자리가 010인지 확인
	    String firstThreeDigits = tel.substring(0, 3);
	    if (!firstThreeDigits.equals("010")) {
	        return false;
	    }

	    return true;
	}

	//아이디 검사
	private static boolean rightId(String id) {
	    // 영문자와 숫자로만 이루어진 8~16자의 문자열인지 확인
	    if (!id.matches("^[a-zA-Z0-9]{8,16}$")) {
	        return false;
	    }

	    return true;
	}
	
	//계좌번호 유효성검사
	private static boolean rightAccount (String account) {
	    // 입력된 계좌번호에서 -를 제거
		account = account.replaceAll("-", "");
		
	    // 입력된 계좌번호가 14자리가 아니면 유효하지 않음
	    if (account.length() != 14) {
	        return false;
	    }

	    // 숫자로 이루어져 있지 않으면 유효하지 않음
	    if (!account.matches("[0-9]+")) {
	        return false;
	    }

	    return true;
	}

	//비밀번호 유효성검사
	private static boolean rightPw (String pw) {
	    // 영문자와 숫자로만 이루어진 문자열인지 확인
	    if (!pw.matches("^[a-zA-Z0-9]*$")) {
	        return false;
	    }

	    return true;
	}

	
}


