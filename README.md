# Java Console Project - SSangYong Bank
JAVA를 기반으로 사용자에게 적합한 금융 상품을 추천하는 콘솔 프로젝트 입니다.  
<br/>

## 🖥 프로젝트 소개
적금, 대출, 카드 상품과 상세정보를 조회하고, 자신에게 맞는 상품을 추천 받을 수 있는 프로그램.

고객의 상황을 고려해 그에 맞는 금융상품을 추천하여 서비스를 이용하는 고객 편의 향상에 목표  
<br/>


## 📅 개발기간
* 23.06.19 ~ 23.07.12  
<br/>

## :two_men_holding_hands: 팀원 구성
 - 김수림: 관리자의 적금 상품 조회, 적금 상품 추가 및 제거, 고객의 적금 상품 조회, 추천 서비스, 적금 계산기 서비스 구현
 - 연진섭: 관리자/고객의 대출 조회, 상세조회, 신용대출 추천, 대출 계산기 서비스 구현
 - 김경민: 관리자/고객의 카드 조회, 추가, 추천, 제거 서비스 구현  
 - 최영진: 관리자의 대출 추가/제거, 전월세/반환보증 대출 추천, 자동차대출 추천, 대출 계산기 서비스 구현
 - 이동재: 프로그램 초기화면, 관리자/고객의 로그인 및 회원가입, 관리자/고객의 메인화면 구현
<br/>
  
  
## ⚙ 개발 환경
* `Java 8`
* `JDK 11.0.1`
- **IDE** : Eclipse(2021-03 R)  
<br/>
  
### ✔️Back-end
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">  
<br/>

### 📌 주요 기능  

### :heavy_check_mark: 적금 상품 추천
  - 만약 회원 정보의 직업과 적금 상품의 가입대상, 우대 대상이 같으면 적금 상품을 추천
  - 고객이 가입할 수 있는 이벤트 상품이 있으면 이벤트 상품도 함께 추천
##### :computer: 코드
```
public static void savReco() {	//적금 추천
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("2. 적금 추천");
		
		//추천상품
		
		for (Login m : Data.customerInfo) {
			
			System.out.printf("%s 고객님에게 다음의 적금을 추천합니다.\n", m.getName());
			System.out.println();
	
			for (Savings s : Data.List) {
				
				if (m.getJob().equals("1") && s.getSavQuali().equals("직장인")) {
					System.out.println(s.getSavName());
				}
				
				if (m.getPoor().equals("1") && s.getSavQuali().equals("차상위계층")) {
					System.out.println(s.getSavName());
					
				}
				
				if (m.getMarried().equals("1") && s.getSavQuali().equals("기혼")) {
					System.out.println(s.getSavName());
				}
			}
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("****************** EVENT *******************");
		//이벤트 상품여부 알려주기
		System.out.println();
		for (Login m : Data.customerInfo) {
			for (Savings s : Data.List) {
				
				if (s.getEventOX().equals("1") && m.getJob().equals("1") && s.getSavQuali().equals("직장인")) {
					System.out.printf("현재 %s인 고객님들을 위한 적금 이벤트가 진행중 입니다.\n", s.getSavQuali());
					System.out.println(s.getSavName()+'\n');
				}
				
				
				if (s.getEventOX().equals("1") && m.getPoor().equals("1") && s.getSavQuali().equals("차상위계층")) {
					System.out.printf("현재 %s인 고객님들을 위한 적금 이벤트가 진행중 입니다.\n", s.getSavQuali());
					System.out.println(s.getSavName()+'\n' );
					
				}
				
				if (s.getEventOX().equals("1") && m.getMarried().equals("1") && s.getSavQuali().equals("기혼")) {
					System.out.printf("현재 %s인 고객님들을 위한 적금 이벤트가 진행중 입니다.\n", s.getSavQuali());
					System.out.println(s.getSavName()+'\n');
				}
			}
			
			System.out.println("********************************************");
			back(scan);
			
		}
	}//savReco()
```
##### :camera: 구동 화면
<img src="https://github.com/tnfladl9926/Bookbbang-Spring/assets/134984241/de6da2f7-99a9-4387-884a-0021870cd7c4" width="60%" height="60%"/>
<br/>

### :heavy_check_mark: 적금 상품 조회
  - 메소드가 실행되면 적금상품 데이처를 리스트에 넣고 콘솔에 출력
##### :computer: 코드
```
public static void savList() {	//적금 조회
		
		Scanner scan = new Scanner(System.in);
		
		SavUI.savSub("1. 적금조회");
		
		System.out.println("[상품번호]\t\t[상품명]\n");
		
		for (Savings s : Data.List) {
			System.out.printf("%s\t\t%s\n", s.getSavNO(), s.getSavName());
		}
		
		
		System.out.println("1. 적금 상세정보 보기");
		System.out.println("0. 이전으로 돌아가기");
		System.out.print("입력: ");
		String sel = scan.nextLine();
		
		
		if (sel.equals("1")) {
			seeDetailSav();
		} else if (sel.equals("0")) {
			savMain();
		} else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			savList();
		}
		
	} //savList()
```
##### :camera: 구동 화면
<img src="https://github.com/tnfladl9926/Bookbbang-Spring/assets/134984241/bbe1c391-8f73-4d86-9aed-ca62de58379d" width="60%" height="60%"/>
<br/>

### :heavy_check_mark: 적금 계산기
  - 매월 일정금액을 모을때
  - 목표 금액을 모을때

##### :computer: 코드
매월 일정금액을 모을때
```
private static void monthlyPay() {	//1. 매월 일정 금액을 저축할 때
		
		System.out.println("------------매월 일정 금액을 저축할 때------------");
		
		Scanner scan = new Scanner(System.in);
		double total = 0;
		
		System.out.print("월 저축액 :");
		int monPay = scan.nextInt();
		
		System.out.print("적금 기간(개월): ");
		int month = scan.nextInt();
		
		System.out.print("금리(주의! 3%의 경우 0.03으로 입력): ");
		double rate = scan.nextDouble();
		scan.nextLine();
		
		total = monPay * month + monPay * (rate /12) * (month * (month+1)/2);
		
		System.out.printf("%d원씩 %d개월 간 %.2f의 이자율의 적금상품에 저축하면 총 %.1f원을 모으실 수 있습니다.\n", monPay, month, rate, total);
		
		back(scan);
		
	} //monthlyPay()
```
목표 금액을 모을때
```
private static void goalPay() {	//2. 목표 금액을 모을 때
		
		System.out.println("------------목표 금액을 모을 때------------");
		
		Scanner scan = new Scanner(System.in);
		double monPay = 0;
		
		System.out.print("목표 금액: ");
		int goal = scan.nextInt();
		
		System.out.print("적금 기간: ");
		int month = scan.nextInt();
		
		System.out.print("금리(주의! 3%의 경우 0.03으로 입력): ");
		double rate = scan.nextDouble();
		scan.nextLine();
		
		monPay = goal / (month + (rate/12) * (month *(month+1)/2));
		
		System.out.printf("%d원을 목표로 %d개월 간 %.2f로 저축한다면 월 %.2f원을 저축해야 합니다.\n", goal, month, rate, monPay);
		
		back(scan);
		
	} //goalPay()
```
##### :camera: 구동 화면
<img src="https://github.com/tnfladl9926/Bookbbang-Spring/assets/134984241/e99d3664-b15d-45ad-a19d-8ee509aa503a" width="70%" height="70%"/>
<img src="https://github.com/tnfladl9926/Bookbbang-Spring/assets/134984241/f37628eb-95b8-4100-a7da-759c8cc5a774" width="70%" height="70%"/>
<br/>



