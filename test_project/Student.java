package test_project;

import java.util.Scanner;

public class Student {

	private String name = "";
	private int marks = 0;

	public void getDetails() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter your name:");
			name = scan.nextLine();
			System.out.println("Enter your marks:");
			if (scan.hasNextInt()) {
				marks = scan.nextInt();
			} else {
				System.out.println("Invalid input for marks. Please enter an integer.");
			}
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public void showDetails() {
		System.out.println("Name of the student is " + name);
		System.out.println("Marks of the student are " + marks);
	}
}

