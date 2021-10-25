public class Problem4_37 {

    //  This is a very small implementation of a BST, it is only meant
    //  to demonstrate the printRange method for Exercise 4.37
    static class BST {
        // The BST only needs the root Node as a data field
        Node root;

        // Definition of the Node class
        public class Node {
            // Data Fields
            int data;
            Node l;
            Node r;

            // Constructor
            private Node(int data) { 
                this.data = data; 
                r = null;
                l = null;
            }

            // Accessors
            private int getData() { return data; }
            private Node getL() { return l; }
            private Node getR() { return r; }

            // Mutators
            private void setData(int data) { this.data = data; }
            private void setL (Node l) { this.l = l; }
            private void setR (Node r) { this.r = r; }

            // insert Method (ignores duplicates)
            private void insert(int data) {
                // if data belongs in right subtree
                if (data < this.data) {
                    if (l == null)
                        l = new Node(data);
                    else
                        l.insert(data); // recursive call
                }

                // if data belongs in left subtree
                else if (data > this.data) {
                    if (r == null) 
                        r = new Node(data);
                    else
                        r.insert(data); // recursive call
                }
            }
        } // end class Node

        // Constructor
        public BST() { root = null; }

        public Node getRoot() { return root; }

        // insert method
        public void insert(int data) {
            if (root == null)
                root = new Node(data);
            else
                root.insert(data);
        }

        public static void printRange(Node head, int lower, int upper) {
            if (head.l != null)
                printRange(head.getL(), lower, upper);
            if (head.getData() >= lower && head.getData() <= upper)
                System.out.printf("%d ", head.getData());
            if (head.r != null)
                printRange(head.getR(), lower, upper);
        }
    } // end class BST


    public static void main(String[] x) {
        int info, lower, upper;
        BST tree = new BST();
        java.util.Scanner input = new java.util.Scanner(System.in);

        do {
            System.out.print("Enter a positive integer to insert into tree or negative to quit: ");
            info = input.nextInt();
            if (info >= 0)
                tree.insert(info);
        } while (info >= 0);

        System.out.print("Enter a lower bound: ");
        lower = input.nextInt();
        System.out.print("Enter an upper bound: ");
        upper = input.nextInt();

        tree.printRange(tree.getRoot(), lower, upper);

    } // end main
}