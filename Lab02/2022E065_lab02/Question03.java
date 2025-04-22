//2022e065
//Question 03

import java.util.Scanner;

public class Question03{
	
	public static int search(int[] arr, int num){
		int low = 0;
		int high = arr.length-1;
		while(high>=low && (low<arr.length)){
			int mid = (low + (high-low)/2);
			if(arr[mid] == num)
				return mid;
			else if (num > arr[mid])
				low = mid+1;
			else if (num < arr[mid])
				high = mid-1;
		}
		return -1;
	}
    

    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		System.out.println("Enter the number of queries: ");
		int Q = sc.nextInt();
		
		int[] array = new int[size];
		System.out.println("Enter the array elements in sorted order: ");
		for(int index = 0; index<size; index++){
			array[index] = sc.nextInt();
		}
		
		System.out.println("Enter the element to be searched: ");
		int[] elem = new int[Q];
		for(int i = 0; i<Q; i++){
			elem[i] = sc.nextInt();
		}
		System.out.println();
		for(int j = 0; j<Q; j++){
			int position = search(array,elem[j]);
			if(position == -1)
				System.out.println("No");
			else
				System.out.println("Yes");
		}

	}
}