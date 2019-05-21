package utility;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("root");

        root.addChild("Documents");
        root.getChild(0).addChild("School");
        root.getChild(0).getChild(0).addChild("Stuff.png");
        root.getChild(0).getChild(0).addChild("CoolStuff.txt");

        root.addChild("Images");
        root.getChild(1).addChild("Wallpapers");
        root.getChild(1).getChild(0).addChild("NotHentai.png");
        root.getChild(1).addChild("Memes");
        root.getChild(1).getChild(1).addChild("Fun.png");
        root.getChild(1).getChild(1).addChild("Superfun.png");

        Node.print(root);

        System.out.printf("Postorden: [");
        ArrayList<Node> postorder = getPostorder(root);
        for(Node child : postorder){
            System.out.print(child.getName() + ", ");
        }
        System.out.printf("]");
    }

    public static ArrayList<Node> getPostorder(Node root){
        ArrayList<Node> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        for(Node child : root.getChildren()){
            res.addAll(getPostorder(child));
        }
        res.add(root);

        return res;
    }
}
