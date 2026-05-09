import java.util.ArrayList; 
import java.util.List;

// here children is variable 
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
            System.err.println(node.data + " is " + parent.data);
        }
        
        for (Node child : node.children){
            printParents(child, node);
        }
    }

}
