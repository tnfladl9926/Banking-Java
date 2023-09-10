package com.project;

public class Loan {
	
	//10개
	private String loanevent;
	private String loantype;
	private String loanno;
	private String loanname;
	private String loanperson;
	private String loanjointype;
	private String loanrate;
	private String loanmaxperiod;
	private String loanmaxamount;
	private String loanrepaytype;
	
	public Loan(String loanevent, String loantype, String loanno, String loanname, String loanperson,
			String loanjointype, String loanrate, String loanmaxperiod, String loanmaxamount, String loanrepaytype) {
		this.loanevent = loanevent;
		this.loantype = loantype;
		this.loanno = loanno;
		this.loanname = loanname;
		this.loanperson = loanperson;
		this.loanjointype = loanjointype;
		this.loanrate = loanrate;
		this.loanmaxperiod = loanmaxperiod;
		this.loanmaxamount = loanmaxamount;
		this.loanrepaytype = loanrepaytype;
	}

	public String getLoanevent() {
		return loanevent;
	}

	public void setLoanevent(String loanevent) {
		this.loanevent = loanevent;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public String getLoanno() {
		return loanno;
	}

	public void setLoanno(String loanno) {
		this.loanno = loanno;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	public String getLoanperson() {
		return loanperson;
	}

	public void setLoanperson(String loanperson) {
		this.loanperson = loanperson;
	}

	public String getLoanjointype() {
		return loanjointype;
	}

	public void setLoanjointype(String loanjointype) {
		this.loanjointype = loanjointype;
	}

	public String getLoanrate() {
		return loanrate;
	}

	public void setLoanrate(String loanrate) {
		this.loanrate = loanrate;
	}

	public String getLoanmaxperiod() {
		return loanmaxperiod;
	}

	public void setLoanmaxperiod(String loanmaxperiod) {
		this.loanmaxperiod = loanmaxperiod;
	}

	public String getLoanrepaytype() {
		return loanrepaytype;
	}

	public void setLoanrepaytype(String loanrepaytype) {
		this.loanrepaytype = loanrepaytype;
	}

	
	public String getLoanmaxamount() {
		return loanmaxamount;
	}

	public void setLoanmaxamount(String loanmaxamount) {
		this.loanmaxamount = loanmaxamount;
	}

	@Override
	public String toString() {
		return "loan [loanevent=" + loanevent + ", loantype=" + loantype + ", loanno=" + loanno + ", loanname="
				+ loanname + ", loanperson=" + loanperson + ", loanjointype=" + loanjointype + ", loanrate=" + loanrate
				+ ", loanmaxperiod=" + loanmaxperiod + ", loanmaxamount=" + loanmaxamount + ", loanrepaytype="
				+ loanrepaytype + "]";
	}
	
	
	
	
}




