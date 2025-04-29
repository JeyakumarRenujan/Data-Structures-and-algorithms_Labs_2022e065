// 2022e065
// Question 01

import java.util.Scanner;
import java.util.HashMap;

public class Q1{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // n hungry students waiting in line
		
		HashMap<Integer, Integer> orders = new HashMap<Integer, Integer>();
		
		for (int i = 1; i <= n; i++){ //Each unique order i
			int t = sc.nextInt(); //order placed by a student at time t
			int d = sc.nextInt(); //order takes d units of time to process
			int TotalTime = t + d;  // Total Time
			
			orders.put(TotalTime, i);
		}
		
		
		for (int i : orders.keySet()){
			System.out.print(orders.get(i) + " ");
		}
		
		
	}
}