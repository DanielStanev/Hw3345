/************************************
 
 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           25 Oct 2021
 Assignment:     Homework #02
 Version:        Java SE 11 (LTS)
 
 Description: An implementation of an
 AVL tree in order to show off the
 double rotation methods.
 
 *************************************/

public class Problem4_26 {
    public static class AVL {
        // The AVL only needs the root Node as a data field
        Node root;

        // Definition of the Node class
        public class Node {
            // Data Fields
            int data;
            int height;
            Node l;
            Node r;

            // Constructor
            private Node(int data) { 
                this.data = data;
                height = 1;
                r = null;
                l = null;
            }

        } // end class Node

        // Constructor
        public AVL() { root = null; }

        int max(int x, int y) { return (x > y) ? x : y; }
        int height(Node node) { return (node == null) ? 0 : node.height; }

        Node insert(Node node, int data) {
            if (node == null)
                return (new Node(key));
            
            if (data < node.data)
                node.l = insert(node.l, data)
            else if (data > node.data)
                node.setR = insert(node.r, data)
            else 
                return node;

            node.height = 1 + max(height(node.l), height(node.r));

            int balance = height(node.l) - height(node.r);
 
            // Single Right
            if (balance > 1 && data < node.left.data)
                return rotateRight(node);
    
            // Single Left
            if (balance < -1 && data > node.right.data)
                return rotateLeft(node);
    
            // Left Right
            if (balance > 1 && data > node.left.data) {
                return doubleRotateLeft(node)
            }
    
            // Right Left 
            if (balance < -1 && data < node.right.data) {
                return doubleRotateRight(node);
            }
    
            return node;
        }
        
        // Methods for single rotations
        Node rotateLeft(Node current) {
            Node t1 = current.l;
            Node t2 = t1.r;

            // rotation
            t1.l = current;
            current.r = t2;

            // fixing heights
            current.height = 1 + max(height(current.l), height(current.r));
            t1.height = 1 + max(height(t1.l), height(t1.r));

            return t1;
        }

        Node rotateRight(Node current) {
            Node t1 = current.left;
            Node t2 = t1.right;
    
            // rotation
            t1.right = y;
            current.left = t2;

            // fixing
            current.height = 1 + max(height(current.left), height(current.right));
            t1.height = 1 + max(height(t1.left), height(t1.right));
    
            return t1;
        }

        Node doubleRotateLeft(Node current) {
            // swapping left and right subtrees allows for a single rotation
            Node t0 = current.r;
            current.r = current.l
            current.l = t0;

            Node t1 = current.r;
            Node t2 = current.l;

            // rotation
            t1.l = current;
            current.r = t2;

            // fixing heights
            current.height = 1 + max(height(current.l), height(current.r));
            t1.height = 1 + max(height(t1.l), height(t1.r));

            return t1;
        }
        Node doubleRotateRight(Node current) {
            // swapping left and right subtrees allows for a single rotation
            Node t0 = current.r;
            current.r = current.l
            current.l = t0;

            Node t1 = current.left;
            Node t2 = t1.right;
    
            // rotation
            t1.right = y;
            current.left = t2;

            // fixing
            current.height = 1 + max(height(current.left), height(current.right));
            t1.height = 1 + max(height(t1.left), height(t1.right));
    
            return t1;
        }
    } // end class AVL
}
