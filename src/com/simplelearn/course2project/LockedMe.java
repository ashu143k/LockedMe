package com.simplelearn.course2project;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class LockedMe {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		System.out.println("--------------- Welcome to Company Lockers Pvt. Ltd ---------------\n"
				+ "Application Name : LockedMe.com\n" + "---------------Developer Details---------------\n"
				+ "Name: Ashish Kumar Pathak \n" + "Designation: JAVA Developer\n" + "Date: 20-09-2022");
		//While loop as True for Application to run until user give input to exit the Application 
		while (true) {
			System.out.println("----------MAIN MENU----------");
			System.out.println("Enter 1: To get file names in ascending order");
			System.out.println("Enter 2: For Business Level Operation");
			System.out.println("Enter 3: Close the Application");
			System.out.println("Enter your choice below");
			int choice = scan.nextInt();
			//Switch is used for user to give the choice which one to perform.
			switch (choice) {
			case 1: {
				ascendingOrderFiles();
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
	//BusinessLevelOperation() Method is used to perform Adding, deletion,searching of file in the directory and a option to return back to main menu.
	private static void businessLevelOperation() throws IOException {
		System.out.println("Select Any one to perform Business Level Operations");
		System.out.println("Enter 1: To add a file");
		System.out.println("Enter 2: To delete a file");
		System.out.println("Enter 3: To search a file");
		System.out.println("Enter 4: To go back to main menu ");
		System.out.println("Enter your choice :");
		int businessLevelOperationChoice = scan.nextInt();
		//Switch is used to perform different type of task - input such given by the user.
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
		//If condition is used here so that the application should not break after perfrom any of above task and return to main menu, as there is a option 4 to go back to main menu. 
		if (businessLevelOperationChoice != 4 || businessLevelOperationChoice > 4) {
			//Recalling the businessLevelOperation(); until user gives 4 to come back to main menu
			businessLevelOperation();
		}
	}
	//searchAFile() method is used Linear Searching of given input to search a file. 
	private static void searchAFile() {
		File searchFileDirectory = new File(System.getProperty("user.dir")+"//Files");
		if (searchFileDirectory.isDirectory()) {
			System.out.println("Enter file name to search");
			String searchFileName = scan.next();
			List<String> listFile = Arrays.asList(searchFileDirectory.list());
			Iterator<String> searchIterate = listFile.iterator();
			boolean flag = false;
			while (searchIterate.hasNext()) {
				String tempString = searchIterate.next().toString();
				if (searchFileName.equals(tempString)) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println(searchFileName + " File is available");
			} else {
				System.out.println("Can't find the given file name "+"'"+searchFileName+"'"+" please try again with case sensitive");
				searchAFile();
			}
		}else {
			System.out.println("Directory not found please give proper path to directory.");
		}
	}
	//deleteFile() is used a input given by user and deletes the file from directory
	private static void deleteFile() {
		System.out.println("Enter file name for deletion");
		String deleteFileName = scan.next();
		File deleteFileDirectory = new File(System.getProperty("user.dir")+"//Files" + deleteFileName);
		if (deleteFileDirectory.delete())
			System.out.println(deleteFileName + " is deleted");
		else
			System.out.println(deleteFileName + "is not deleted as file is not found in directory");		
	}
	//addFile() Method is used to add a file given name by user to the directory.
	private static void addFile() throws IOException {
		System.out.println("Enter your file name");
		String fileName = scan.next();
		File newFile = new File(System.getProperty("user.dir")+"//Files" + fileName);
		if (newFile.createNewFile()) {
			System.out.println("File is created\n");
			}
		else {
			System.out.println("File is already exist, Please try again with different name for file.\n");
		addFile();
		}
		}
	//ascendingOrderFiles() Method is used to retrive the files from the directory if directory found and then stored in a list as arrayList 
	//then using Collection.sort() method it gets sorted then using Iterator we iterate the data from the list to String format. else the directory is empty or not found. 
	private static void ascendingOrderFiles() throws IOException {
		File fileDir = new File(System.getProperty("user.dir")+"//Files");
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
