package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Data클래스입니다.
 *
 */

public class Data {
	
	public final static String CUSTOMER = ".\\dat\\회원\\회원 정보.txt";
	public final static String LOGIN = ".\\dat\\회원\\로그인정보.txt";
	public final static String MANAGER = ".\\dat\\회원\\관리자정보.txt";
	public final static String CREDIT = ".\\dat\\신용카드\\카드상품.txt";
	public final static String CREDIT_D = ".\\dat\\신용카드\\신용카드D\\신용카드";
	public final static String DEBIT =".\\dat\\체크카드\\체크카드데이터.txt";
	public final static String DEBIT_D =".\\dat\\체크카드\\체크카드D\\체크카드";
	public final static String LOAN = ".\\dat\\대출\\대출 데이터.txt";
	public final static String SAVINGS = ".\\dat\\적금\\적금상품데이터.txt";

	
	
	public static ArrayList<Customer> customerlist;
	public static ArrayList<Login> customerInfo;
	public static ArrayList<Manager> managerlist;
	public static ArrayList<Credit> creditlist;
	public static ArrayList<Credit> credit_d;
	public static ArrayList<Debit> debitlist;
	public static ArrayList<Debit> debit_d;
	public static ArrayList<Loan> loanlist;
	public static ArrayList<Savings> List;

	
	
	static {
		customerlist = new ArrayList<Customer>();
		customerInfo = new ArrayList<Login>();
		managerlist = new ArrayList<Manager>();
		creditlist = new ArrayList<Credit>();
		credit_d= new ArrayList<Credit>();
		debitlist = new ArrayList<Debit>();
		debit_d = new ArrayList<Debit>();
		loanlist = new ArrayList<Loan>();
		List = new ArrayList<Savings>();

	}

	/**
	 * 대출데이터를 배열로 받아오는 메소드입니다.
	 */
	public static void loanload() {

		try {
	         BufferedReader reader = new BufferedReader(new FileReader(Data.LOAN));
	         
	         String line = null;
	         
	         while ((line = reader.readLine()) != null) {
	            
	            String[] temp = line.split(",");
	            
	            Loan l = new Loan(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],temp[8],temp[9]);
	            
	            loanlist.add(l);
	         }
	         
	         reader.close();
	         
		} catch (Exception e) {
	         e.printStackTrace();
	    }
	      
	}
	
	/**
	 * 신용카드 데이터를 배열로 받아오는 메소드입니다.
	 */
	//신용카드
	public static void loadCredit() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.CREDIT));

			
			String line =null;
			while((line=reader.readLine()) !=null) {
				String[] temp = line.split(",");
				
				//텍스트 1줄 > Member 객체 1개 
				Credit c = new Credit(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
				creditlist.add(c);
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	/**
	 * 
	 * 신용카드 상세데이터를 배열로 받아오는 메소드입니다.
	 * 
	 */
	//신용카드
	public static void loadCreditD(String input) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.CREDIT_D+input+".txt"));
			String line =null;
			while((line=reader.readLine()) !=null) {
				Credit cd = new Credit(line);
				credit_d.add(cd);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	/**
	 * 체크카드 데이터를 배열로 받아오는 메소드입니다.
	 */
	//체크카드
	public static void loadDebit() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Data.DEBIT));
	
			
			String line =null;
			while((line=reader.readLine()) !=null) {
				String[] temp = line.split(",");
				
				//텍스트 1줄 > Member 객체 1개 
				Debit d = new Debit(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
				debitlist.add(d);
			}
		
			reader.close();
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	
		
	}

	/**
	 * 체크카드 상세데이터를 배열로 받아오는 메소드입니다.
	 */
	//체크카드
	public static void loadDebitD(String input) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.DEBIT_D+input+".txt"));
			String line =null;
			while((line=reader.readLine()) !=null) {
				Debit dd = new Debit(line);
				debit_d.add(dd);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	/**
	 * 관리자정보 데이터를 배열로 받아오는 메소드입니다.
	 */
	//관리자정보
	public static void loadManager () {
		
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(Data.MANAGER));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//텍스트 1줄 > Member 객체 1개
				Manager m = new Manager(temp[0], temp[1], temp[2]);
				
				managerlist.add(m);
			
		}
		
		reader.close();
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * 고객정보 데이터를 배열로 받아오는 메소드입니다.
	 */
	//고객정보
	public static void loadCustomer() {
	
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(Data.CUSTOMER));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//텍스트 1줄 > Member 객체 1개
				Customer m = new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12], temp[13], temp[14], temp[15]);
				
				customerlist.add(m);
			
		}
		
		reader.close();
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * 로그인정보 데이터를 배열로 받아오는 메소드입니다.
	 */
	//로그인정보
	public static void loadLogin() {
		
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(Data.LOGIN));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//텍스트 1줄 > Member 객체 1개
				Login m = new Login(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12], temp[13], temp[14], temp[15]);
				
				customerInfo.add(m);
			
		}
		
		reader.close();
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * 회원가입을 성공하면 회원정보에 추가하는 메소드입니다.
	 */
	public static void saveCustomer() {
		
		//배열 > (덮어쓰기) > Customer.txt
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.CUSTOMER));
			
			//Member m > 1,홍길동,20,남자
			for (Customer m : customerlist) {
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
											, m.getNo()
											, m.getName()
											, m.getJumin()
											, m.getArmy()
											, m.getTel()
											, m.getId()
											, m.getAccount()
											, m.getPw()
											, m.getMarried()
											, m.getPoor()
											, m.getGoods()
											, m.getJob()
											, m.getSavings()
											, m.getLoan()
											, m.getCheckCard()
											, m.getCreditCard()
											));	
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 적금정보 데이터를 배열로 받아오는 메소드입니다.
	 */
	public static void savLoad() {
	      
	      try {
	         BufferedReader reader = new BufferedReader(new FileReader(Data.SAVINGS));
	         String line = null;
	         
	         while ((line = reader.readLine()) != null) {
	            String temp[] = line.split(",");
	            
	            Savings s = new Savings(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
	            List.add(s);
	         }
	         reader.close();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	}//savLoad
	
	/**
	 * 적금을 추가하면 적금정보에 추가하는 메소드입니다.
	 */
	public static void savsave() {
	      
	      
	      try {
	         
	         BufferedWriter writer = new BufferedWriter(new FileWriter(Data.SAVINGS));
	         
	         
	         for (Savings s : List) {
	            
	            writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n"
	                  , s.getEventOX()
	                  , s.getSavNO()
	                  , s.getSavName()
	                  , s.getSavQuali()
	                  , s.getSavInterest()
	                  , s.getSavMaxPay()
	                  , s.getSavPer()));
	         }
	         
	         writer.close();
	         
	      } catch (Exception e ) {
	         e.printStackTrace();
	      }

	}
	
	/**
	 * 대출을 추가하면 대출정보에 추가하는 메소드입니다.
	 */
	public static void loanSave() {
		   
		   try {
		      BufferedWriter writer = new BufferedWriter(new FileWriter(Data.LOAN));
		      
		      for (Loan l : loanlist) {
		         writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
		                           , l.getLoanevent()
		                           , l.getLoantype()
		                           , l.getLoanno()
		                           , l.getLoanname()
		                           , l.getLoanperson()
		                           , l.getLoanjointype()
		                           , l.getLoanrate()
		                           , l.getLoanmaxperiod()
		                           , l.getLoanmaxamount()
		                           , l.getLoanrepaytype()));
		      }
		      writer.close();
		      
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   
	} //loansave
	
	
}
