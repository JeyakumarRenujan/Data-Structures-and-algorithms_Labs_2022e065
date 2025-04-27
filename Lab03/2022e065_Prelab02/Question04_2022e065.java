//2022e065

import java.util.Scanner;
import java.util.Stack;

public class Question04{
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
		int choice;

        do {
			System.out.println();
            System.out.println("1. Push an element");
            System.out.println("2. Pop an element");
            System.out.println("3. Display all elements");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");
            
            choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the element : ");
                    String element = scan.nextLine();
                    stack.push(element);
                    System.out.println("Success");
                    break;

                case 2:
                    if (stack.isEmpty()) {
						System.out.println("Stack is empty");
                    } else {
                        String poppedElement = stack.pop();
                        System.out.println("Success");
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println(stack);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
					break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
			
        }
		while (choice != 4);
		scan.close();
    }
}