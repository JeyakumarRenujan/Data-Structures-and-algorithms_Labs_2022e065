//2022e065
//Question_03
import java.util.Scanner;
public class Question_03{
	public static void countShifts(int[] array) {
		int count = 0;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
				count = count + 1;
            }

            array[j + 1] = key;
        }
		System.out.println("\nSorted Array in Ascending Order:");
        for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println(": "+ count);
    }
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number of test cases:");
		int n = scanner.nextInt();
		
		if (n == 0) {
            System.out.println("Error");
            return;
        }
		
		for (int i=0; i<n; i++){ // for test cases
			System.out.println("\nArray length: ");
			int m = scanner.nextInt();
			// Loop for getting integer
		    System.out.println("Enter " + m + " integers:");
		    int [] array = new int[m];
			
		    for(int j = 0; j < m; j++){ // for integers
				array[j] = scanner.nextInt();
			}
			int [] originalArray = array.clone();
			
			countShifts(array);
			
		}
	}
}