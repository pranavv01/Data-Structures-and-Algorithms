import java.util.ArrayList; 
import java.util.List;


 class Node {
    int data;
    List<Node> children;

    Node(int x) {
        data = x;
        children = new ArrayList<>();
    }
 }

class Pranav {
    static void addChild(Node parent, Node child) {
        parent.children.add(child);
    }

    static void printParents(Node node, Node parent) {
        if(parent == null){
            System.out.println(node.data + "is NULL");
        }
        else {
            System.out.println(node.data + " is " + parent.data);
        }
        
        for (Node child : node.children){
            printParents(child, node);
        }
    }

    static void printChildren(Node node) {
        System.out.println(node.data + " is ");
        for (Node child : node.children){
            System.out.println(child.data + " ");
        }
        
        System.out.println();

        for (Node child : node.children) {
            printChildren(child);
        }
    }

    static void printLeafNodes(Node node) {
        if(node.children.isEmpty()) {
            System.out.println(node.data + " ");
            return;
        }

        for (Node child : node.children) {
            printLeafNodes(child);
        }
    }

    static void printDegrees(Node node , Node parent) {
        int degree = node.children.size();
        if(parent != null) {
            degree++;
        }
             System.out.println(node.data + " is " + degree);

        for (Node child : node.children)
        {
            printDegrees(child, node);

        }
    }

    public static void main (String [] args) {
        //  Creating nodes

        Node root  = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);


        // Constructing tree
        addChild(root, n2);
        addChild(root, n3);
        addChild(n2, n4);
        addChild(n2, n5);

        System.out.println("Parent of each node: ");
        printParents(root, null);
        
        System.out.println("Children of each node: ");
        printChildren(root);
        
        System.out.println("Leaf Nodes: " );
        printLeafNodes(root);
        System.out.println();

        System.out.println("Degrees of nodes: ");
        printDegrees(root, null);

    }

}
