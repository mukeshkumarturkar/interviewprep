package ds;

import java.util.Stack;

public class FlattenBinaryTree {
    public static void main(String[] args) {
     /*
              1
             / \
            2   5
           / \   \
          3   4   6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right= new Node(6);

        //flatten using recurresion
        //flatten(root);
        //flatten using stack

        /*flatten binary tree using stack*/
        printflattentree(root);
        flattenWithStack( root);
        printflattentree(root);
    }

    static void flattenWithStack(Node root){

        /*    1
             / \
            2   5
           / \   \
          3   4   6  */

        if(null==root) return;

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty())
        {
            System.out.println("###  Iteration start  ####");

            Node current = nodeStack.pop();

            if(current.right!=null){
                nodeStack.push(current.right);
            }

            if(current.left!=null){
                nodeStack.push(current.left);
            }

            if(!nodeStack.isEmpty()){
                current.right=nodeStack.peek();
            }

            current.left=null;

            printflattentree(root);
            System.out.println("End ");
        }


    }
    static void flatten(Node root){

        //flatten left & right subtree
        if(null==root) return;    // rule of recursive break

        flatten(root.left);
        flatten(root.right);

        //Store the left and right sub tree
        Node t_left = root.left;
        Node t_right =root.right;

        //move left to right sub tree;
        root.left =null;
        root.right =t_left;

        //traverse to the end of new right sub tree
        Node current =root;

        while(null!=current.right){
            current=current.right;
        }
        current.right =t_right;

        // attach original right sub tree

        //print flatten tree
      //  System.out.println("#######Round#########");
      //  printflattentree(root);
       // System.out.println("#######Round#########");
    }

    static void printflattentree(Node root){

        while(root!=null){
            System.out.println(root.value);
            root= root.right;
        }
    }
}

class Node{
    Node left,right;
    int value;
    Node (int value){
        this.value =value;
        left=null;
        right=null;
    }
}