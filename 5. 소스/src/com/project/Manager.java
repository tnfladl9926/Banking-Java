package com.project;

public class Manager {
	
	private String ManagerNo = ""; //관리자 번호
	private String ManagerId = ""; //관리자 아이디
	private String ManagerCode = ""; //관리자 코드
	
	public Manager(String managerNo, String managerId, String managerCode) {
		ManagerNo = managerNo;
		ManagerId = managerId;
		ManagerCode = managerCode;
	}

	public String getManagerNo() {
		return ManagerNo;
	}

	public void setManagerNo(String managerNo) {
		ManagerNo = managerNo;
	}

	public String getManagerId() {
		return ManagerId;
	}

	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}

	public String getManagerCode() {
		return ManagerCode;
	}

	public void setManagerCode(String managerCode) {
		ManagerCode = managerCode;
	}

	@Override
	public String toString() {
		return "Manager [ManagerNo=" + ManagerNo + ", ManagerId=" + ManagerId + ", ManagerCode=" + ManagerCode + "]";
	}
	
	
	

}
