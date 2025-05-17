package ds;

public class Gondaad{
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
        flatten(root);
        printflattentree(root);
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