//2022e065

import java.util.Scanner;

public class Question01 {
	
    static class CustomStack {
        private char[] stackArray;
        private int top;
        private int maxSize;

        public CustomStack(int size) {
            maxSize = size;
            stackArray = new char[size];
            top = -1;
        }

        // Function for push
        public void push(char ch) {
            if (top == maxSize - 1) {
                System.out.println("Stack Overflow");
            } else {
                stackArray[++top] = ch;
            }
        }

        // Function for pop
        public char pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return '\0'; 
            } else {
                return stackArray[top--];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static String isBalanced(String expression) {
        CustomStack stack = new CustomStack(expression.length());

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return "NO"; 
                }
                char top = stack.pop();
             
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		System.out.print("number of test cases: ");
        int t = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < t; i++) {
            String expression = scanner.nextLine();
            System.out.println(isBalanced(expression));
        }

        scanner.close();
    }
}
