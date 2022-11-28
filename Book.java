package com.vti.entity;

public class Book extends Document {

	private String author;
	private int numOfPage;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String author, int numOfPage) {
		super();
		this.author = author;
		this.numOfPage = numOfPage;
	}

	public Book(String id, String publisher, int numOfIssue, int type, String author, int numOfPage) {
		super(id, publisher, numOfIssue, type);
		this.author = author;
		this.numOfPage = numOfPage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

	@Override
	public void showInfo() {
		System.out.printf("|%-5s|", super.getId());
		System.out.printf("%-20s|", super.getPublisher());
		System.out.printf("%-12d|", super.getNumOfIssue());
		System.out.printf("%-5d|", super.getType());
		System.out.printf("%-10s|", getAuthor());
		System.out.printf("%-11d|%n", getNumOfPage());
		System.out.println("+--------------------------------------------------------------------+");

	}

}
