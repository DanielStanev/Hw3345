public class Problem4_26 {
    class AVL {
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
        int height(Node node) { return node.height; }

        Node insert(Node node, int data) {
            if (node == null)
                return (new Node(key));
            
            if (data < node.data)
                node.l = insert(node.l, data)
            else if (data > node.data)
                node.setR = insert(node.r, data)
            else 
                return node;

            node.height = 1 + max(node.l.height, node.r.height);
        }
        
        Node rotateLeft(Node current) {
            Node t1 = current.l;
            Node t2 = current.r;

            // rotation
            t1.l = current;
            current.r = t2;

            current.height = 1 + max(current.l.height, current.r.height);
            t1.height = 1 + max(t1.l.height, t1.r.height);

            return t1;
        }
        Node doubleRotateLeft(Node current) {
            Node t0 = current.l;

            Node t1 = t0.l;
            Node t2 = t0.r;

            t1.l = t0;
            t0.r = t2;

            t0.height = 1 + max(t0.l.height, )
        }
        Node rotateRight(Node current) {}
        Node doubleRotateRight(Node current) {}


    } // end class AVL
}
