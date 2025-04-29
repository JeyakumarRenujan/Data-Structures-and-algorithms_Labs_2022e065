//2022e065
//Question02

import java.util.Scanner;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Question02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n (1 ≤ n ≤ 1000) — the number of operations.
        sc.nextLine(); 

        Hashtable<String, Integer> inventory = new Hashtable<>();

        for (int i = 0; i < n; i++) {
			String[] parts = sc.nextLine().split(" "); // String into Array
            int command = Integer.parseInt(parts[0]); // String to Integer

            switch (command) {
                case 1: { // Add Item
                    String itemName = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    inventory.put(itemName, inventory.getOrDefault(itemName, 0) + quantity);
                    break;
                }
                case 2: { // Update Quantity
                    String itemName = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    if (inventory.containsKey(itemName)) {
                        inventory.put(itemName, quantity);
                    } else {
                        System.out.println(itemName + " not found.");
                    }
                    break;
                }
                case 3: { // Check Item
                    String itemName = parts[1];
                    if (inventory.containsKey(itemName)) {
                        System.out.println(inventory.get(itemName));
                    } else {
                        System.out.println(itemName + " is out of stock.");
                    }
                    break;
                }
                case 4: { // Display Inventory
                    List<String> sorted = new ArrayList<>(inventory.keySet());
                    Collections.sort(sorted); // Sort keys alphabetically using collection library
                    for (String key : sorted) {
                        System.out.println(key + ": " + inventory.get(key));
                    }
                    break;
                }
                default:
                    System.out.println("Invalid command.");
            }
        }
        sc.close();
    }
}
