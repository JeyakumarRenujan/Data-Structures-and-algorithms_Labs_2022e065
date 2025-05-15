// 2022/E/065
// lab06

public class lab06 {
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		
		// 1. Initial Setup:
        System.out.println("Task 01");
		tree.insert("apple");
		tree.insert("banana");
		tree.insert("grape");
		tree.insert("mango");
		tree.insert("peach");
		tree.insert("pear");
		tree.insert("pineapple");
		tree.insert("melon");
		tree.insert("plum");
		tree.insert("orange");
		
		System.out.println("Inorder traversal: ");
        tree.inorder();
		
		// 2. Basic Autocomplete Functionality:
		System.out.println("\n\nTask 02");
		System.out.print("For 'pe': ");
        tree.autocomplete("pe");
        System.out.println();
		System.out.print("For 'pi': ");
        tree.autocomplete("pi");
        System.out.println();
		System.out.print("For 'me': ");
        tree.autocomplete("me");
        System.out.println();
		
		// 3. Dynamic Updates:
		System.out.println("\nTask 03");
		tree.insert("peanut");
		tree.insert("mandarin");
		tree.insert("pistachio");
		
		System.out.println("Updated Inorder traversal: ");
        tree.inorder();
		
		System.out.print("\n\nFor 'pe': ");
        tree.autocomplete("pe");
        System.out.println();
		
		// 4. Advanced Prefix Matching:
		System.out.println("\nTask 04");
		System.out.print("For 'PE': ");
        tree.autocomplete("PE");
        System.out.println();
		System.out.print("For 'PI': ");
        tree.autocomplete("PI");
        System.out.println();
		System.out.print("For 'ME': ");
        tree.autocomplete("ME");
        System.out.println();
		
		// 5. Word Deletion:
		System.out.println("\nTask 05");
        tree.delete("pear");
		tree.delete("banana");
		tree.delete("melon");
		
		System.out.println("After deletion Updated Inorder traversal: ");
        tree.inorder();
		
		System.out.print("\n\nFor 'pe': ");
        tree.autocomplete("pe");
        System.out.println();
		
	}
	
}

//.......................................................................................................//
//Node Insertion class
class Node {
    String data;
    Node left, right;

    public Node(String item) {
        data = item;
        left = right = null;
    }
}

//..................................................................................................//
// Binary Tree Implementation class
class BinaryTree {
	Node root;

    public BinaryTree() { // Constructor
        root = null;
    }

    void insert(String data) { // Insert a new node 
        root = insertRec(root, data);
    }
	
    Node insertRec(Node root, String data) {
        if (root == null) {  // If the tree is empty, create a new node
            root = new Node(data);
            return root;
        }
		
        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }
	
	//..............................................Inorder Traversal..................................................//
	 void inorder() {
        inorderRec(root);
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
	//......................................................END........................................................//
	
	//.....................................................prefix and autocomplete..................................................//
	void autocomplete (String prefix){
		autocompleteRec(root, prefix.toLowerCase());
	}
	void autocompleteRec(Node root, String prefix){
		if (root == null)
			return;
		autocompleteRec(root.left, prefix);
		if (root.data.toLowerCase().startsWith(prefix))
			System.out.print(root.data + " ");	
		autocompleteRec(root.right, prefix);
	}
	//......................................................END........................................................//
	
	
	//.....................................................Word Deletion..................................................//
	void delete(String data) {
        root = deleteRec(root, data);
    }
	Node deleteRec(Node root, String data){
		if (root == null) {
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
			
            root.right = deleteRec(root.right, root.data);
        }

        return root;
	}
	String minValue(Node root){
		String minValue = root.data;
        while (root.left != null) {
            root = root.left;
            minValue = root.data;
        }
        return minValue;
	}
	
	//......................................................END........................................................//
	
}


