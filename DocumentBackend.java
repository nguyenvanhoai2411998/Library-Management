package vti.com.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Book;
import com.vti.entity.Document;
import com.vti.entity.Magazine;
import com.vti.entity.Newspaper;

public class DocumentBackend {

	// REQUIREMENTS
	// a) ADD NEW DOCUMENT
	// b) DELETE DOCUMENT BY DOCUMENT ID
	// c) SHOW DOCUMENT INFO
	// d) SEARCH DOCUMENT BY TYPE: BOOK, NEWS, MAGAZINE
	// e) EXIT

	private Scanner scanner;
	private ArrayList<Document> documents;

	public void menu() {
		scanner = new Scanner(System.in);
		documents = new ArrayList<>();

		// CREATE DEFAULT DOCUMENT
		createDoc();

		while (true) {

			System.out.println("+----------------please select options-----------------+");
			System.out.println("+------------------------------------------------------+");
			System.out.printf("| %-53s|\n", "1. Add new documents");
			System.out.printf("| %-53s|\n", "2. Delete document by id");
			System.out.printf("| %-53s|\n", "3. Show document info");
			System.out.printf("| %-53s|\n", "4. Search document by type");
			System.out.printf("| %-53s|\n", "5. Exit");
			System.out.println("+------------------------------------------------------+");
			System.out.println("Please choose your options");

			int input = scanner.nextInt();
			boolean inputFinish = false;

			switch (input) {
			case 1:
				System.out.println("please select document type: 1- Book, 2- Magazine, 3- Newspaper");
				while (!inputFinish) {
					switch (scanner.nextInt()) {
					case 1:
						addBook();
						inputFinish = true;
						break;
					case 2:
						addMagazine();
						inputFinish = true;
						break;
					case 3:
						addNewspaper();
						inputFinish = true;
						break;
					default:
						System.out.println("your input mismatch, select 1->3");
						break;
					}
				}
				break;
			case 2:
				deleteByID();
				break;
			case 3:
				displayInfo();
				break;
			case 4:
				searchByType();
				break;
			case 5:
				return;
			default:
				break;
			}

		}
	}

	private void searchByType() {
		System.out.println();
		System.out.println("please enter type(Book, Magazine, Newspaper):");
		String inputType = scanner.next();

		switch (inputType) {
		case "Book":
			bookInterface();
			for (Document document : documents) {
				if (document.getType() == 1) {
					document.showInfo();
				}
			}
			System.out.println();
			break;
		case "Magazine":
			magazineInterface();
			for (Document document : documents) {
				if (document.getType() == 2) {
					document.showInfo();
				}
			}
			System.out.println();
			break;
		case "Newspaper":
			newspaperInterface();
			for (Document document : documents) {
				if (document.getType() == 3) {
					document.showInfo();
				}
			}
			System.out.println();
			break;

		default:
			break;
		}

	}

	private void deleteByID() {
		System.out.println("enter document ID");
		String inputId = scanner.next();
		int idCheck = 0; // if idCheck == 0 (entered ID doesn't exist)
		Iterator<Document> docIterator = documents.iterator();
		while (docIterator.hasNext()) {
			Document document = (Document) docIterator.next();
			if (document.getId().equals(inputId)) {
				idCheck++;
				docIterator.remove();
				System.out.println("document have been deleted");
			} else if ((docIterator.hasNext() == false) && (idCheck == 0)) {
				System.out.println("entered Id can't be found");
			}
		}

	}

	private void createDoc() {
		Book book1 = new Book("1H2D", "Nhi_Dong", 2, 1, "Takeshi", 200);
		Book book2 = new Book("1H2E", "Nhi_Dong", 1, 1, "Ezumi", 202);
		Book book3 = new Book("1H2F", "Nhi_Dong", 3, 1, "Takeshi", 203);

		Magazine magazine1 = new Magazine("DS2K", "Tuoi_Tre", 1, 2, 1, "2022-11-27");
		Magazine magazine2 = new Magazine("DS2J", "Tuoi_Tre", 2, 2, 2, "2022-11-27");
		Magazine magazine3 = new Magazine("DS2H", "Tuoi_Tre", 3, 2, 3, "2022-11-27");

		Newspaper newspaper1 = new Newspaper("DUK1", "Kim_Dong", 1, 3, "2022-11-07");
		Newspaper newspaper2 = new Newspaper("DUK2", "Kim_Dong", 1, 3, "2022-11-07");
		Newspaper newspaper3 = new Newspaper("DUK3", "Kim_Dong", 1, 3, "2022-11-07");

		documents.add(book1);
		documents.add(book2);
		documents.add(book3);

		documents.add(magazine1);
		documents.add(magazine2);
		documents.add(magazine3);

		documents.add(newspaper1);
		documents.add(newspaper2);
		documents.add(newspaper3);
	}

	private void addBook() {
		Book book = new Book();
		System.out.println("your selection is: add new book!");
		System.out.println("please enter Book ID:");
		book.setId(scanner.next());
		System.out.println("please enter Book Publisher:");
		book.setPublisher(scanner.next());
		System.out.println("please enter num of issue");
		book.setNumOfIssue(scanner.nextInt());
		book.setType(1);
		System.out.println("please enter author");
		book.setAuthor(scanner.next());
		System.out.println("please enter num of page");
		book.setNumOfPage(scanner.nextInt());
		System.out.println("book have been added!");
		documents.add(book);
	}

	private void addMagazine() {
		Magazine magazine = new Magazine();
		System.out.println("your selection is: add new Magazine!");
		System.out.println("please enter Magazine ID:");
		magazine.setId(scanner.next());
		System.out.println("please enter Magazine Publisher:");
		magazine.setPublisher(scanner.next());
		System.out.println("please enter num of issue");
		magazine.setNumOfIssue(scanner.nextInt());
		System.out.println("please enter issueNum");
		magazine.setIssueNum(scanner.nextInt());
		System.out.println("please enter issue month");
		magazine.setIssueMonth(scanner.next());
		magazine.setType(2);
		System.out.println("magazine have been added!");
		documents.add(magazine);
	}

	private void addNewspaper() {
		Newspaper newspaper = new Newspaper();
		System.out.println("your selection is: add new Newspaper!");
		System.out.println("please enter Newspaper ID:");
		newspaper.setId(scanner.next());
		System.out.println("please enter Newspaper Publisher:");
		newspaper.setPublisher(scanner.next());
		System.out.println("please enter num of issue");
		newspaper.setNumOfIssue(scanner.nextInt());
		newspaper.setType(3);
		System.out.println("please enter issueDate");
		newspaper.setIssueDate(scanner.next());
		System.out.println("newspaper have been added!");
		documents.add(newspaper);

	}

	private void displayInfo() {
		// DISPLAY LIST OF BOOKS
		bookInterface();
		for (Document document : documents) {
			if (document.getType() == 1) {
				document.showInfo();
			}
		}
		System.out.println("\n");

		// DISPLAY LIST OF MAGAZINES
		magazineInterface();
		for (Document document : documents) {
			if (document.getType() == 2) {
				document.showInfo();
			}
		}
		System.out.println("\n");

		// DISPLAY LIST OF NEWSPAPER
		newspaperInterface();
		for (Document document : documents) {
			if (document.getType() == 3) {
				document.showInfo();
			}
		}
		System.out.println("\n");

	}

	// SUPPORT FUNCTION
	private void bookInterface() {
		System.out.println();
		System.out.println("+----------------------------LIST OF BOOKS---------------------------+");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("|%-5s|%-20s|%-5s|%-5s|%-10s|%-5s|%n", "ID", "Publisher", "Num Of Issue", "Type", "Author",
				"Num Of Page");
		System.out.println("+--------------------------------------------------------------------+");
	}

	private void magazineInterface() {
		System.out.println();
		System.out.println("+------------------------------LIST OF MAGAZINES----------------------------+");
		System.out.println("+---------------------------------------------------------------------------+");
		System.out.printf("|%-5s|%-20s|%-14s|%-5s|%-14s|%-12s|%n", "ID", "Publisher", "Num Of Issue", "Type",
				"Issue Numbers", "Issue Month");
		System.out.println("+---------------------------------------------------------------------------+");
	}

	private void newspaperInterface() {
		System.out.println();
		System.out.println("+-----------------------LIST OF NEWSPAPER----------------------+");
		System.out.println("+--------------------------------------------------------------+");
		System.out.printf("|%-5s|%-20s|%-14s|%-5s|%-14s|%n", "ID", "Publisher", "Num Of Issue", "Type", "Issue Date");
		System.out.println("+--------------------------------------------------------------+");
	}

}