// 2022/e/065
// Lab 05

import java.util.Scanner;

public class Q1{
	public static void main(String[] args){
		System.out.println("How many element do you want insert: ");
		Scanner scannerObject = new Scanner(System.in);
		int n = scannerObject.nextInt();
		
		BinaryTreeImplementation bti = new BinaryTreeImplementation();
		// Insert elements
		for(int i=0; i<n; i++){
			Scanner sc = new Scanner(System.in);
			bti.insert(sc.nextInt());
		}
		System.out.println("_______________________________________");
		System.out.print("Inorder traversal:     ");
        bti.inorder();
		System.out.print("\nPreorder traversal:   ");
        bti.preorder();
		System.out.print("\nPostorder traversal: ");
        bti.postorder();
		System.out.println("\n_______________________________________");
		
		// height of the tree
		System.out.println("\nHeight of the tree: " + bti.height());
		
		// total number of leaf nodes
		System.out.println("\nTotal number of leaf nodes: " + bti.countLeafNodes());
		
		// Print the tree structure
		System.out.println("\nTree structure:");
		bti.printTree();
		
		// Search for a key
		System.out.println("\nEnter the Search key: ");
		Scanner SearchKey = new Scanner(System.in);
        int keyToSearch = SearchKey.nextInt();
		if (bti.search(keyToSearch))
			System.out.println("\nSearch for key " + keyToSearch + ": Found");
		else
			System.out.println("\nSearch for key " + keyToSearch + ": Not Found");

		// Delete a key
		System.out.println("\nEnter the Delete key: ");
		Scanner DeleteKey = new Scanner(System.in);
        int keyToDelete = DeleteKey.nextInt();
        System.out.println("\nDelete key " + keyToDelete);
        bti.delete(keyToDelete);

        System.out.println("Inorder traversal after deletion:");
        bti.inorder();
		
		// Print the tree structure after delete
		System.out.println("\nTree structure:");
		bti.printTree();
	}
}
//.......................................................................................................//
//Node Insertion class
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
//..................................................................................................//
// Binary Tree Implementation class
class BinaryTreeImplementation {
	 Node root;
	 
	 public BinaryTreeImplementation() { // Constructor
        root = null;
    }
	
	 // Insert a new key into the BTI
    void insert(int key) {
        root = insertRec(root, key);
    }
	
	
	 Node insertRec(Node root, int key) {
        if (root == null) {           // If the tree is empty, create a new node
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }
	//.............................................................................//
	
	//....................Traversals: Implement the following traversal algorithms...................//
	// Inorder Traversal (Left, Root, Right)
    void inorder() {
        inorderRec(root);
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
	// Preorder Traversal (Left, Root, Right)
	void preorder(){
		preorderRec(root);
	}
	void preorderRec(Node root){
		 if (root != null) {
			 System.out.print(root.key + " ");
			 preorderRec(root.left);
			 preorderRec(root.right);
        }
	}
	// Postorder Traversal (Left, Root, Right)
	void postorder(){
		postorderRec(root);
	}
	void postorderRec(Node root){
		 if (root != null) {
			 postorderRec(root.left);
			 postorderRec(root.right);
			 System.out.print(root.key + " ");
        }
	}
	//.....................................END........................................//
	
	//...........Search Functionality: Search for a value in the tree and return whether it exists or not.................//
    boolean search(int key) {
        return searchRec(root, key);
    }
    boolean searchRec(Node root, int key) {
        if (root == null || root.key == key) // root is null or the key is present at the root
            return root != null;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }
	//....................................END.........................................//
	
	//............Height Calculation: Compute and display the height of the Binary Tree..............................//
	int height(){
		return heightRec(root);
	}
	int heightRec(Node root){
		if (root == null)
			return -1;
		int leftHeight = heightRec(root.left);
		int rightHeight = heightRec(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	//....................................END.........................................//
	
	//............Leaf Node Count: Count and display the total number of leaf nodes in the tree.........................//
	int countLeafNodes(){
		return countLeafNodesRec(root);
	}
	int countLeafNodesRec(Node root){
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return countLeafNodesRec(root.left) + countLeafNodesRec(root.right);
	}
	//....................................END.........................................//
	
	//............Deletion of a Node: Delete a node from the Binary Tree while maintaining its structure..................//
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key
    Node deleteRec(Node root, int key) {
        if (root == null) // The tree is empty
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root) { // find the minimum value in a tree
        int minValue = root.key;
        while (root.left != null) {
            root = root.left;
            minValue = root.key;
        }
        return minValue;
    }
	//....................................END.........................................//
	
	//............Tree Visualization: Print the Binary Tree structure in a user-friendly format ..................//
	void printTree(){
		printTreeRec(root, 0);
	}
	void printTreeRec(Node node, int level){
		 if (node != null){
			 printTreeRec(node.right, level + 1);
			 
			 for (int i = 0; i < level; i++){
				 System.out.print("       ");
			 }
			 System.out.println(node.key);
			 printTreeRec(node.left, level + 1);
		 }
	}
	//....................................END.........................................//
}