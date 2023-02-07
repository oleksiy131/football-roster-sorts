import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/*	NAME: Oleksii Dukhovenko
 * 	CLASS: CPSC 374
 * 	PROFESSOR: Dr. Whitfield
 *	ASSIGNMENT_1
 */



public class Main {

	//initializing array of type Person
	public static Person[] player = new Person[100];
	static int count = 0;

	//printPlayer method that formats the each subsection respectively
	public static void printPlayer(Person p1) {
		System.out.printf("%s %s\t\t%d %s\t%s \t%d\t%d\t%s", p1.firstName, p1.lastName, p1.number, p1.Position, p1.Height, p1.weight,
				p1.age, p1.Something);
		System.out.println(p1.College);

	}

	//read method that finds the roster.txt file, scans it, and loads all the data from  the file into an array
	public static int readData() throws FileNotFoundException {
		String lastName, firstName, College, Position, Height, Something;
		int number, age, weight;

		//creates a scanner
		// PLEASE NOTE: 
		// For the program to work the PATH to the file needs to be correct!!!
		
		Scanner sc = new Scanner(new File("/Users/oleksii/Desktop/Roster.txt"));	//PATH
		while (sc.hasNextLine()) {
			firstName = new String();
			firstName = sc.next();
			lastName = new String();
			lastName = sc.next();
			number = sc.nextInt();
			Position = new String();
			Position = sc.next();
			Height = new String();
			Height = sc.next();
			weight = sc.nextInt();
			age = sc.nextInt();
			Something = new String();
			Something = sc.next();
			College = new String();
			College = sc.nextLine();

			//array loading
			player[count] = new Person(firstName, lastName, number, Position, Height, weight, age, Something, College);
			count++;
		}
		sc.close();
		return count;
	}

	//A print method that prints out the whole roster using the 'printPlayer' method above
	public static void printRoster() throws FileNotFoundException {
		System.out.println("ROSTER:");
		System.out.println("------------------------------------------------------------------------------");
				for (int j = 0; j < count; j++) {
			printPlayer(player[j]);
		}
	}
	
	//Method that checks whether the a certain player comes before the next in the file
	public static void comesBefore(String name, String name2) {
		
		while(true) {
			boolean yesItDoes = false;
			
			for (int i = 0; i < count; i++) {
				if (player[i].firstName.equals(name) && player[i+1].firstName.equals(name2)) {
					yesItDoes = true;
					System.out.println("TRUE");
					break;
				}
			}
			
			if (!yesItDoes) {
				System.out.println("FALSE");
			}
			break;
		}
}


	//A simple bubble sorting algorithm that sorts all the integer data respectively in ascending order
	public static void bubbleSort(int val) throws FileNotFoundException {
		int out, in = 0;

		System.out.println();
		System.out.println("Bubble Sorting...");

		for (out = count - 1; out > 1; out--)
			for (in = 0; in < out; in++)
				if (player[in] != null) {
					if (val == 4) {
						if (player[in].age > player[in + 1].age)
							swap(in, in + 1);
					} else if (val == 5) {
						if (player[in].weight > player[in + 1].weight)
							swap(in, in + 1);
					} else if (val == 3) {
						if (player[in].number > player[in + 1].number)
							swap(in, in + 1);
					}
				}

	}

	//A simple selection sort algorithm that sorts out all the String data in alphabetical order respectively
	public static void selectionSort(int val) throws FileNotFoundException {

		System.out.println();
		System.out.println("Selection Sorting...");

		if (val == 1) {
			for (int i = 0; i < count - 1; i++) {

				// Finding the minimum element in unsorted array
				int min_index = i;
				String minStr = player[i].firstName;
				for (int j = i + 1; j < count; j++) {

					if (player[j].firstName.compareTo(minStr) < 0) {
						
						// Make player[j].firstName as minStr and update min_idx
						minStr = player[j].firstName;
						min_index = j;
					}
				}

				// Swapping the minimum element
				// found with the first element.
				if (min_index != i) {
					swap(i, min_index);
				}
			}

		}
		if (val == 2) {
		for (int i = 0; i < count - 1; i++) {

			int min_index = i;
			String minStr = player[i].lastName;
			for (int j = i + 1; j < count; j++) {

				if (player[j].lastName.compareTo(minStr) < 0) {
					
					minStr = player[j].lastName;
					min_index = j;
				}
			}

			if (min_index != i) {
				swap(i, min_index);
			}
		}
	}

		if (val == 6) {
			for (int i = 0; i < count - 1; i++) {

				// Find the minimum element in unsorted array
				int min_index = i;
				String minStr = player[i].College;
				for (int j = i + 1; j < count; j++) {

					if (player[j].College.compareTo(minStr) < 0) {

						minStr = player[j].College;
						min_index = j;
					}
				}

				if (min_index != i) {
					swap(i, min_index);
				}
			}
		}
	}

	//A swap method that swaps the 2 integers within the parameter of the method
	public static void swap(int one, int two) throws FileNotFoundException {

		String tempS;
		int temp;

		temp = player[one].age;
		player[one].age = player[two].age;
		player[two].age = temp;

		temp = player[one].weight;
		player[one].weight = player[two].weight;
		player[two].weight = temp;

		temp = player[one].number;
		player[one].number = player[two].number;
		player[two].number = temp;

		tempS = player[one].firstName;
		player[one].firstName = player[two].firstName;
		player[two].firstName = tempS;

		tempS = player[one].lastName;
		player[one].lastName = player[two].lastName;
		player[two].lastName = tempS;

		tempS = player[one].Position;
		player[one].Position = player[two].Position;
		player[two].Position = tempS;

		tempS = player[one].Something;
		player[one].Something = player[two].Something;
		player[two].Something = tempS;

		tempS = player[one].College;
		player[one].College = player[two].College;
		player[two].College = tempS;
		
		tempS = player[one].Height;
		player[one].Height = player[two].Height;
		player[two].Height = tempS;
		

	}

	//A User Prompt with a  scanner that prompts the user for what they want the data to be sorted by
	public static int userPrompt() throws FileNotFoundException {
		Scanner uInput = new Scanner(System.in);
		System.out.println("Would you like to sort by:" + "\n--------------------------" + "\nfirst name \t[Press 1] "
				+ "\nlast name\t[Press 2]" + "\nplayer number \t[Press 3]" + "\nage \t\t[Press 4]"
				+ "\nweight \t\t[Press 5]" + "\nCollege \t[Press 6]");
		System.out.println("--------------------------");
		System.out.print("Your choice: ");

		int input = uInput.nextInt();

		switch (input) {
		case 1:
			// sort by firstName
			selectionSort(1);

			break;
		case 2:
			// sort by lastName
			selectionSort(2);
			break;
		case 3:
			// sort by playerNum
			bubbleSort(3);
			break;
		case 4:
			//sort by age
			bubbleSort(4);

			break;
		case 5:
			// sort by weight
			bubbleSort(5);
			break;
		case 6:
			// sort by college
			selectionSort(6);
			break;

		}
		System.out.println("-------------------");
		printRoster();

		return 1;

	}

	//MAIN
	public static void main(String[] args) throws FileNotFoundException {
		int count;
		count = readData();

		userPrompt();
		
		//comesBefore("Kevin", "Joe");
		 
	}
}
