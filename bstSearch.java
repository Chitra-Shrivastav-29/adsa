import java.util.Scanner;
class Node
{
    int key;
    Node left, right;
    Node (int key)
    {
        this.key = key;
        left = right = null;
    }
}
class BST
{
    Node root;
    Node insert(Node node, int key) 
    {
        if(node == null) 
        return new Node(key);
        if(key < node.key)
        node.left = insert(node.left, key);
        else
        node.right = insert(node.right, key);
        return node;
    }
    boolean search(Node node, int key)
    {
        if(node == null)
        return false;
        if(node.key == key)
        return true;
        if(key < node.key)
        return search(node.left, key);
        else
        return search(node.right, key);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();
        int choice,key;
        do
        {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = sc.nextInt();
                    tree.root = tree.insert(tree.root, key);
                    System.out.println(key + " inserted into the BST");
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    key = sc.nextInt();
                    if(tree.search(tree.root, key))
                    System.out.println(key + " is found in the BST");
                    else
                    System.out.println(key + " is not found in the BST");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");              
            }
        }while(choice != 3);
        sc.close();
    }
}