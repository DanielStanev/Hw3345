public class Problem4-37 {

    //  This is a very small implementation of a BST, it is only meant
    //  to demonstrate the printInRange method for Exercise 4.37
    static class BST {
        // The BST only needs the root Node as a data field
        Node root;

        // Definition of the Node class
        private class Node {
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
                        r = new Node(keyword);
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
            if (root == null) {
                root = new Node(data);
            else
                root.insert(data);
        }

    } // end class BST


    public static void main(String[] x) {

    } // end main

}