package edu.examples.java_classes.input;

import java.util.Scanner;

public class InputTerminal {

	private Scanner sc = new Scanner(System.in);

	public int input() {

		int variant;

		System.out.println(" - Select an option. >");

		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("incorrect value");
			System.out.print(" - Select an option. >");
		}
		variant = sc.nextInt();
		sc.nextLine();
		return variant;
	}

	public String strInputWithContext(String context){
		String result;
		System.out.println(context);

		result = sc.nextLine();

		return result;
	}
}
