package com.vti.entity;

public class Magazine extends Document {

	private int issueNum;
	private String issueMonth;

	public Magazine() {
		super();
	}

	public Magazine(String id, String publisher, int numOfIssue, int type, int issueNum, String issueMonth) {
		super(id, publisher, numOfIssue, type);
		this.issueNum = issueNum;
		this.issueMonth = issueMonth;
	}

	public int getIssueNum() {
		return issueNum;
	}

	public void setIssueNum(int issueNum) {
		this.issueNum = issueNum;
	}

	public String getIssueMonth() {
		return issueMonth;
	}

	public void setIssueMonth(String issueMonth) {
		this.issueMonth = issueMonth;
	}

	@Override
	public void showInfo() {
		System.out.printf("|%-5s|", super.getId());
		System.out.printf("%-20s|", super.getPublisher());
		System.out.printf("%-14d|", super.getNumOfIssue());
		System.out.printf("%-5d|", super.getType());
		System.out.printf("%-14d|", getIssueNum());
		System.out.printf("%-12s|%n", getIssueMonth());
		System.out.println("+---------------------------------------------------------------------------+");

	}

}
