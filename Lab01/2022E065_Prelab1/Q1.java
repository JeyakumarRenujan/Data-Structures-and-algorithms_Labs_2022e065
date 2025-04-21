// 2022e065
// Question 1

import java.util.Scanner;

public class Q1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Ask the number of integers from user
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Error");
            return;
        }

        // Loop for getting integer & calculations
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            sum += num;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        // Calculate average
        double average = (double) sum / n;

        //Display the results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        scanner.close();
    }
}