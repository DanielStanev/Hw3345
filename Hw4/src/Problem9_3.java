/************************************
 
 Author:         Daniel Stanev
 Course:         CS 3345.004
 Date:           1 Dec 2021
 Assignment:     Homework #04
 Version:        Java SE 11 (LTS)
 
 Description: Exercise 9.3

 Very simple implementation of a graph
 in order to show case the topological 
 sort method.
 
 *************************************/

public class Problem9_3 {

        //  Ultra barebones implementation of a graph.
        //  This is just to showcase the topological sort,
        //  since assignment is not to actually make a good graph
        private class GraphNode {
            public java.util.LinkedList<GraphNode> parents;
            public java.util.LinkedList<GraphNode> sucessors;

            public String name;

            // Constructor
            public GraphNode();
            public GraphNode(String name) { this.name = name; }
        }
    }




    public static void main() {

        // creates the graph from problem 9.1
        GraphNode S = new GraphNode("S");
        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");
        GraphNode T = new GraphNode("T");
        GraphNode G = new GraphNode("G");
        GraphNode H = new GraphNode("H");
        GraphNode I = new GraphNode("I");

        // initializes the graph manually
        S.sucessors.push(A);
        S.sucessors.push(D);
        S.sucessors.push(G);

        A.parents.push(S);
        A.parents.push(D);
        A.sucessors.push(B);
        A.sucessors.push(E);

        D.parents.push(S);
        D.parents.push(G);
        D.sucessors.push(A);
        D.sucessors.push(E);

        G.parents.push(S);
        G.sucessors.push(D);
        G.sucessors.push(E);
        G.sucessors.push(H);

        B.parents.push(A);
        B.sucessors.push(C);

        E.parents.push(A);
        E.parents.push(D);
        E.parents.push(G);
        E.parents.push(H);
        E.sucessors.push(C);
        E.sucessors.push(F);
        E.sucessors.push(I);

        H.parents.push(G);
        H.sucessors.push(E);
        H.sucessors.push(I);

        C.parents.push(B);
        C.parents.push(E);
        C.parents.push(F);
        C.sucessors.push(T);

        F.parents.push(E);
        F.parents.push(I);
        F.sucessors.push(C);
        F.sucessors.push(T);

        I.parents.push(E);
        I.parents.push(H);
        I.sucessors.push(F);
        I.sucessors.push(T);

        T.parents.push(C);
        T.parents.push(F);
        T.parents.push(I);

        sort(S);
        

    }

    public static void sort(GraphNode root) {
        Node current = root;
        java.util.LinkedList<GraphNode> Sorted = new java.util.LinkedList();
        
    }





}