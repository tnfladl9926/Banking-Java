package com.project;

public class Credit {
	private String event; 	//이벤트여부2
	private String debit;	//카드 종류
	private String no;		//카드번호

	private String cardName;//카드명
	private String annual;	//연회비
	private String pre;		//실적
	private String benefit;	//혜택
	private String dBenefit;//상세혜택

	public Credit(String dBenefit) {
		super();
		this.dBenefit = dBenefit;
	}



	public String getdBenefit() {
		return dBenefit;
	}



	public void setdBenefit( String dBenefit) {
		this.dBenefit = dBenefit;
	
	}
	

	//신용카드 정보 
	public Credit(String event, String debit, String no, String cardName, String annual, String pre, String benefit) {
		super();
		this.event = event;
		this.debit = debit;
		this.no = no;
		this.cardName = cardName;
		this.annual = annual;
		this.pre = pre;
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
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getAnnual() {
		return annual;
	}
	public void setAnnual(String annual) {
		this.annual = annual;
	}
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	
	@Override
	public String toString() {
		return "Credit [event=" + event + ", debit=" + debit + ", no=" + no + ", cardName=" + cardName + ", annual="
				+ annual + ", pre=" + pre + ", benefit=" + benefit + ", dBenefit=" + dBenefit + "]";
	}



}
