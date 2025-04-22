//2022e065
//Question 01

import java.util.Scanner;

public class Question01{
	
	void merge(int arr[], int L, int mid, int R){
		int l = mid - L + 1;
		int r = R - mid;
		
		int LeftArray[] = new int[l];
		int RightArray[] = new int[r];
		
		for (int i=0; i<l; i++)
			LeftArray[i] = arr[L + i];
		
		for (int j=0; j<r; j++)
			RightArray[j] = arr[mid + 1 + j];
		
		int i = 0, j = 0;
		int k = L;
		while (i<l && j<r){
			if (LeftArray[i] <= RightArray[j]) {
				arr[k] = LeftArray[i];
				i++;
			} else {
				arr[k] = RightArray[j];
				j++;
			}
			k++;
		}
		while (i < l){
			arr[k] = LeftArray[i];
			i++;
			k++;
		}
		while (j < r){
			arr[k] = RightArray[j];
			j++;
			k++;
		}
	}
	
	void sort(int arr[], int L, int R){
		if (L < R) { //breaking contision for recursive
			int mid = (L + R) / 2;
			sort(arr, L, mid);
			sort(arr, mid+1, R);
			merge(arr, L, mid,R);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the array elements: ");
		for(int index = 0; index<size; index++){
			array[index] = sc.nextInt();
		}
		
		//print unsorted array
		System.out.println("\nInput Array:");
		for (int i :array){
			System.out.print(i + " ");
		}
		
		Question01 ob = new Question01();
		ob.sort(array, 0, array.length-1);
		
		//print sorted array
		System.out.println("\nSorted array");
		for (int i :array){
			System.out.print(i + " ");
		}
		
	}
}