//2022e065
//Question_01

import java.util.Scanner;

public class Question_01{
	public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        // Return -1 if the target is not found in the array
        return -1;
    }
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of integers: ");
		int size = scanner.nextInt();
		
		 if (size == 0) {
            System.out.println("Error");
            return;
        }
		
		// Loop for getting integer
		System.out.println("Enter " + size + " integers:");
		int [] arr = new int[size];
		for (int i = 0; i < size; i++){
			arr[i] = scanner.nextInt();
		}
		System.out.println("Enter the target:");
		int Target = scanner.nextInt();
		
		int result = linearSearch(arr, Target);
        if (result != -1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
	}
}




