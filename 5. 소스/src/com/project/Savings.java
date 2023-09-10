package com.project;

public class Savings {
	
	private String eventOX;		//이벤트여부
	private String savNO;		//번호
	private String savName;		//이름
	private String savQuali;	//신청자격
	private String savInterest;	//이율(%)
	private String savMaxPay;		//최대월납입액
	private String savPer;			//최대계약기간(개월)
	
	public Savings(String eventOX, String savNO, String savName, String savQuali, String savInterest, String savMaxPay,
			String savPer) {
		super();
		this.eventOX = eventOX;
		this.savNO = savNO;
		this.savName = savName;
		this.savQuali = savQuali;
		this.savInterest = savInterest;
		this.savMaxPay = savMaxPay;
		this.savPer = savPer;
	}

	public String getEventOX() {
		return eventOX;
	}

	public void setEventOX(String eventOX) {
		this.eventOX = eventOX;
	}

	public String getSavNO() {
		return savNO;
	}

	public void setSavNO(String savNO) {
		this.savNO = savNO;
	}

	public String getSavName() {
		return savName;
	}

	public void setSavName(String savName) {
		this.savName = savName;
	}

	public String getSavQuali() {
		return savQuali;
	}

	public void setSavQuali(String savQuali) {
		this.savQuali = savQuali;
	}

	public String getSavInterest() {
		return savInterest;
	}

	public void setSavInterest(String savInterest) {
		this.savInterest = savInterest;
	}

	public String getSavMaxPay() {
		return savMaxPay;
	}

	public void setSavMaxPay(String savMaxPay) {
		this.savMaxPay = savMaxPay;
	}

	public String getSavPer() {
		return savPer;
	}

	public void setSavPer(String savPer) {
		this.savPer = savPer;
	}

	@Override
	public String toString() {
		return "SAVINGS [eventOX=" + eventOX + ", savNO=" + savNO + ", savName=" + savName + ", savQuali=" + savQuali
				+ ", savInterest=" + savInterest + ", savMaxPay=" + savMaxPay + ", savPer=" + savPer + "]";
	}
	
	

}
