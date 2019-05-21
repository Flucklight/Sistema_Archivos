package utility;

import java.util.ArrayList;

public class Node {
    private Node parent;
    private String name;
    private ArrayList<Node> children;

    public Node(String name, Node parentNode){
        this.name = name;
        this.parent = parentNode;
        this.children = new ArrayList<>();
    }

    public Node(String rootName){
        this(rootName, null);
    }

    public void addChild(String name){
        children.add(new Node(name, this));
    }

    public ArrayList<Node> getChildren(){
        return new ArrayList<>(children);
    }

    public Node getChild(int index){
        if (index < children.size())
            return children.get(index);

        return null;
    }

    public Node getNode(){
        return this;
    }

    public Node getParent() {
        return parent.getNode();
    }

    public String getName() {
        return this.name;
    }

    public static void print(Node node){
        printAux(node, 0);
    }

    public static void printAux(Node node, int spacing){
        for (int i = 0; i < spacing; ++i)
            System.out.print("      ");

        System.out.println(node.name);

        for (Node child : node.getChildren())
            printAux(child, spacing + 1);
    }


    @Override
    public String toString() {
        String nodeString = this.getName() + "(";

        for (Node child : this.getChildren())
            nodeString += child.getName();

        nodeString += ")";
        return nodeString;
    }
}