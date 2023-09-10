package com.project;

public class Login {
	
	private String no = ""; //고객번호
	private String name = ""; //이름
	private String jumin = ""; //주민등록번호
	private String army = ""; //군인
	private String tel = ""; //전화번호 
	private String id = ""; //id
	private String account = ""; //계좌번호
	private String pw = ""; //비밀번호
	private String married = ""; //기혼여부
	private String poor = ""; //기초생활수급자
	private String goods = ""; //가입되어 있는 상품
	private String job = ""; //직장유무
	private String savings = ""; //적금
	private String loan = ""; //대출
	private String checkCard = ""; //체크카드
	private String creditCard = ""; //신용카드
	
	public Login(String no, String name, String jumin, String army, String tel, String id, String account, String pw,
			String married, String poor, String goods, String job, String savings, String loan, String checkCard,
			String creditCard) {
		this.no = no;
		this.name = name;
		this.jumin = jumin;
		this.army = army;
		this.tel = tel;
		this.id = id;
		this.account = account;
		this.pw = pw;
		this.married = married;
		this.poor = poor;
		this.goods = goods;
		this.job = job;
		this.savings = savings;
		this.loan = loan;
		this.checkCard = checkCard;
		this.creditCard = creditCard;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getArmy() {
		return army;
	}

	public void setArmy(String army) {
		this.army = army;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getPoor() {
		return poor;
	}

	public void setPoor(String poor) {
		this.poor = poor;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSavings() {
		return savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getCheckCard() {
		return checkCard;
	}

	public void setCheckCard(String checkCard) {
		this.checkCard = checkCard;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Customer [no=" + no + ", name=" + name + ", jumin=" + jumin + ", army=" + army + ", tel=" + tel
				+ ", id=" + id + ", account=" + account + ", pw=" + pw + ", married=" + married + ", poor=" + poor
				+ ", goods=" + goods + ", job=" + job + ", savings=" + savings + ", loan=" + loan + ", checkCard="
				+ checkCard + ", creditCard=" + creditCard + "]";
	}
	
}