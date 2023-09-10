package com.project;

public class Debit {
	private String event; 	//이벤트여부
	private String debit;	//카드 종류
	private String no;		//카드번호
	private String cardname;//카드명
	private String qualified;//신청자격
	private String benefit;	//혜택
	private String dBenefit;//상세혜택
	
	public Debit(String dBenefit) {
		super();
		this.dBenefit = dBenefit;
	}

	
	public Debit(String event, String debit, String no, String cardname, String qualified, String benefit) {
		super();
		this.event = event;
		this.debit = debit;
		this.no = no;
		this.cardname = cardname;
		this.qualified = qualified;
		this.benefit = benefit;
	}
	
	


	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getQualified() {
		return qualified;
	}
	public void setQualified(String qualified) {
		this.qualified = qualified;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	public String getdBenefit() {
		return dBenefit;
	}
	public void setdBenefit(String dBenefit) {
		this.dBenefit = dBenefit;
	}

}
