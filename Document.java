package com.vti.entity;

public abstract class Document {

	private String id;
	private String publisher;
	private int numOfIssue;
	private int type;

	public Document() {
		super();
	}

	public Document(String id, String publisher, int numOfIssue, int type) {
		super();
		this.id = id;
		this.publisher = publisher;
		this.numOfIssue = numOfIssue;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNumOfIssue() {
		return numOfIssue;
	}

	public void setNumOfIssue(int numOfIssue) {
		this.numOfIssue = numOfIssue;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public abstract void showInfo();

}
