package com.simplelearn.course2project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("--------------- Welcome to Company Lockers Pvt. Ltd ---------------\n"
				+ "Application Name : LockedMe.com\n" + "---------------Developer Details---------------\n"
				+ "Name: Ashish Kumar Pathak \n" + "Designation: JAVA Developer\n" + "Date: 20-09-2022");

		while (true) {
			System.out.println("----------MAIN MENU----------");
			System.out.println("Enter 1: To get file names in ascending order");
			System.out.println("Enter 2: For Business Level Operation");
			System.out.println("Enter 3: Close the Application");
			System.out.println("Enter your choice below");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				accendingOrderFiles();
				break;
			}
			case 2: {
				businessLevelOperation();
				break;
			}
			case 3: {
				System.out.println(" Application is Closed ");
				System.exit(choice);
			}
			default:
				System.out.println("Kindly enter valid input");
			}
		}
	}

	private static void businessLevelOperation() throws IOException {
		System.out.println("Select Any one to perform Business Level Operations");
		System.out.println("Enter 1: To add a file");
		System.out.println("Enter 2: To delete a file");
		System.out.println("Enter 3: To search a file");
		System.out.println("Enter 4: To go back to main menu ");
		System.out.println("Enter your choice :");
		int businessLevelOperationChoice = scan.nextInt();
		switch (businessLevelOperationChoice) {
		case 1: {
			addFile();
			break;
		}
		case 2: {
			deleteFile();
			break;
		}
		case 3: {
			searchAFile();
			break;
		}
		case 4: {
			System.out.println("Back to Main Menu is Successful\n");
			break;
		}
		default:
			System.out.println("Kindly enter valid input");
		}
		if (businessLevelOperationChoice != 4 || businessLevelOperationChoice > 4) {
			businessLevelOperation();
		}
	}

	private static void searchAFile() {
		File fileDir = new File("C:\\Users\\ashis\\eclipse-workspace\\AssessmentProject\\Files\\");
		if (fileDir.isDirectory()) {
			System.out.println("Enter file name to search");
			String searchFileName = scan.next();
			List<String> listFile = Arrays.asList(fileDir.list());
			Iterator<String> searchIterate = listFile.iterator();
			boolean flag = false;
			while (searchIterate.hasNext()) {
				String tempString = searchIterate.next().toString();
				if (searchFileName.equalsIgnoreCase(tempString)) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println(searchFileName + " is available");
			} else {
				System.out.println(searchFileName + " is not available");
			}
		}
	}
	private static void deleteFile() {
		System.out.println("Enter file name for delete");
		String deleteFileName = scan.next();
		File deleteFileDirectory = new File(
				"C:\\Users\\ashis\\eclipse-workspace\\AssessmentProject\\Files\\" + deleteFileName);
		if (deleteFileDirectory.delete())
			System.out.println(deleteFileName + " is deleted");
		else
			System.out.println(deleteFileName + "is not deleted as file is not found in directory");

	}

	private static void addFile() throws IOException {
		System.out.println("Enter your file name");
		String fileName = scan.next();
		File newFile = new File("C:\\Users\\ashis\\eclipse-workspace\\AssessmentProject\\Files\\" + fileName);
		if (newFile.createNewFile())
			System.out.println("File is created\n");
		else
			System.out.println("File is alredy exist\n");
	}

	private static void accendingOrderFiles() throws IOException {
		File fileDir = new File("C:\\Users\\ashis\\eclipse-workspace\\AssessmentProject\\Files\\");
		if (fileDir.isDirectory()) {
			List<String> listFile = Arrays.asList(fileDir.list());
			Collections.sort(listFile);
			System.out.println("---------------------------------------");
			System.out.println("File Names in Ascending Order");
			Iterator<String> iterate = listFile.iterator();
			while (iterate.hasNext()) {
				System.out.println(iterate.next().toString());
			}
		} else {
			System.out.println(fileDir.getAbsolutePath() + " is not a directory");
		}
	}

}
