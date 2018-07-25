
/*
 * 
 * @author Jacob Quickert
 * Grand Circus Lab 8
 * 
 * 
 */
import java.util.Scanner;

public class Lab8AboutJavaStudents {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userNum = 0;
		String cont = "y";
		String cont2;

		while (cont.equalsIgnoreCase("y")) {
			// print out the options for the user
			for (int i = 0; i < 4; i++) {
				// use (i + 1) for the line number to print
				// and simply i for the column marker in the method call to the 2D array
				// 0 in the method call ensures that I only access the names of the students
				System.out.println((i + 1) + ". " + studentInfoGet(0, i));
			}
			// prompt user to ask about a particular student.
			userNum = Validator.getInt(scan, "Which student would you like to know more about? (1 - 4): ", 1, 4);
			// Give proper responses according to user-submitted information
			System.out.println("Student " + userNum + " is " + studentInfoGet(0, userNum - 1));
			// initialize cont2 inside 1st while loop and just outside of 2nd
			// to ensure 2nd while loop runs once every time the 1st while loop runs
			cont2 = "y";
			while (cont2.equalsIgnoreCase("y")) {
				// I put the three parameters on separate lines because the prompt was long
				System.out.println(moreInfoChecker(scan,
						"What would you like to know about them?: (Hometown or Favorite Food) ", userNum));

				// Ask if the user would like to know more about a particular student
				System.out.println("Would you like to know more about " + studentInfoGet(0, userNum - 1) + "? (y/n)");
				cont2 = scan.nextLine();
			}
			// Ask if the user would like to know about another student.
			System.out.println("Would you like to know about another student? (y/n)");
			cont = scan.nextLine();
		}
		// tell the user that the program has ended
		System.out.println("Goodbye.");
		scan.close();

	}

	public static String studentInfoGet(int i, int j) {
		// Provide information about students in the class
		// use 2 D array
		String[][] arr = { { "Michelle", "Tiffany", "Camila", "Joseph" },
				{ "Hong Kong", "Detroit", "Brazil", "Dearborn" }, { "sushi", "olives", "chocolate", "pasta" } };
		// use integers passed in from main to access appropriate string
		// assign str to the string at the array address provided
		String str = arr[i][j];
		// return the appropriate string from the array to main method
		return str;
	}

	public static String moreInfoChecker(Scanner sc, String prompt, int num) {
		// set boolean to false
		boolean isValid = false;
		// initialize string for the if-else boolean check
		String moreInfo = "";
		// string to reassign based on user response
		String response = "";

		while (isValid == false) {
			// prompt user to enter value for moreInfo variable
			System.out.println(prompt);
			// reassign moreInfo variable to user response
			moreInfo = sc.nextLine();
			if (moreInfo.equalsIgnoreCase("Hometown")) {
				// access appropriate string in 2D array method
				// 1 in the method call refers to the row containing hometowns
				response = studentInfoGet(1, num - 1);
				// reassign boolean to exit while loop
				isValid = true;
			} else if (moreInfo.equalsIgnoreCase("Favorite food")) {
				// access appropriate string in 2D array method
				// 2 in the method call refers to the row containing foods
				response = studentInfoGet(2, num - 1);
				// reassign boolean to exit while loop
				isValid = true;
			} else {
				// print error message and keep looping (boolean remains false)
				System.out.println("Error! That is not a valid entry. Hometown or favorite food, please.");
			}
		}
		// return this string based on user response in the if-else statement
		return response;
	}

}
