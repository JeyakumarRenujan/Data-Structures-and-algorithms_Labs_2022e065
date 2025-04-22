//2022e065
//Question 02

import java.util.Arrays;
import java.util.Scanner;

public class Question02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.println("number of questions available: ");
		int N = sc.nextInt();
		System.out.println("number of queries: ");
		int Q = sc.nextInt();
		
		int size = N;
		System.out.println("Enter the time: ");
		int array[][] = new int[2][size];
		for(int i = 0; i<size; i++){
			array[0][i] = sc.nextInt();
		}
		
		System.out.println("Enter the scores: ");
		for(int j = 0; j<size; j++){
			array[1][j] = sc.nextInt();
		}
		
        mergeSort(array, 0, array.length - 1, 0);
		
		int[] K = new int[Q];
		System.out.println("Number of questions you wants to solve: ");
		for(int k = 0; k<Q; k++){
			K[k] = sc.nextInt();
			
			int sum = 0;
			for(int r=0; r<N; r++ ){
				sum = sum + array[0][r];
			}
			int subtract=0;
			for (int s=0; s<((N)-K[k]); s++){
				subtract = subtract + array[0][s];
			}
			int result = sum - subtract;
			System.out.print("Time is:");
			System.out.println(result);
		}
    }

    public static void mergeSort(int[][] array, int left, int right, int column) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid, column);
            mergeSort(array, mid + 1, right, column);

            merge(array, left, mid, right, column);
        }
    }

    public static void merge(int[][] array, int left, int mid, int right, int column) {
        int[][] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[][] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i][column] <= rightArray[j][column]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}
