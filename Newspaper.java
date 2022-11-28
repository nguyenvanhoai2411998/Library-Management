package com.vti.entity;

public class Newspaper extends Document {

	private String issueDate;

	public Newspaper() {
		super();
	}

	public Newspaper(String id, String publisher, int numOfIssue, int type, String issueDate) {
		super(id, publisher, numOfIssue, type);
		this.issueDate = issueDate;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public void showInfo() {
		System.out.printf("|%-5s|", super.getId());
		System.out.printf("%-20s|", super.getPublisher());
		System.out.printf("%-14d|", super.getNumOfIssue());
		System.out.printf("%-5d|", super.getType());
		System.out.printf("%-14s|%n", getIssueDate());
		System.out.println("+--------------------------------------------------------------+");
	}

}
