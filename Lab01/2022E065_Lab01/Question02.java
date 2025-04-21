//2022e065
//Question_02
import java.util.Scanner;
public class Question02{
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
		int [] array = new int[size];
		for (int i = 0; i < size; i++){
			array[i] = scanner.nextInt();
		}
		// print the unsorted array
		System.out.println("\nUnsorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
		// BubbleSort....
		int count = 0;
        for (int i = 0; i<array.length-1; i++){
			for (int j=0; j<array.length-1; j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					count = count+1;
				}
			}
		}
		// print the sorted array
		System.out.println("\nSorted Array in Ascending Order:");
        for (int num : array) {
            System.out.print(num + " ");
        }
		System.out.println("\n\nTotal number of swaps: "+ count);
		System.out.println("First element in the sorted array: "+ array[0]);
		System.out.println("Last element in the sorted array: "+ array[array.length-1]);
	}
}