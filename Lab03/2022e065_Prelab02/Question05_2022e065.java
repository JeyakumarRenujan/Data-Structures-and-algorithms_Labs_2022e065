//2022e065

import java.util.Stack;

public class Question05 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int element) {
        stack1.push(element);
        System.out.println(element + " enqueued to the queue.");
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty. Cannot dequeue.");
            }
            // Move elements from stack1 to stack2 to reverse the order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); // Pop the element from stack2 which holds the front of the queue
    }

    // Display the current state of the queue
    public void display() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements (front to back):");
            if (!stack2.isEmpty()) {
                for (int i = stack2.size() - 1; i >= 0; i--) {
                    System.out.print(stack2.get(i) + " ");
                }
            }
            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Question05 queue = new Question05();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        queue.enqueue(40);
        queue.display();
    }
}