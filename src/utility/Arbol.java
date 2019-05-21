package utility;

import java.util.ArrayList;

public class Arbol {
    public static void main(String[] args) {
        Nodo raiz = new Nodo("root");

        raiz.addHijo("Documents");
        raiz.getHijo(0).addHijo("School");
        raiz.getHijo(0).getHijo(0).addHijo("Stuff.docx");
        raiz.getHijo(0).getHijo(0).addHijo("SomeOtherStuff.pptx");

        raiz.addHijo("Images");
        raiz.getHijo(1).addHijo("Wallpapers");
        raiz.getHijo(1).getHijo(0).addHijo("NotHentai.png");
        raiz.getHijo(1).addHijo("Memes");
        raiz.getHijo(1).getHijo(1).addHijo("Fun.png");
        raiz.getHijo(1).getHijo(1).addHijo("Superfun.png");

        Nodo.print(raiz);

        System.out.printf("Postorden: [");
        ArrayList<Nodo> postorder = getPostorder(raiz);
        for(Nodo hijo : postorder){
            System.out.print(hijo.getNombre() + ", ");
        }
        System.out.printf("]");
    }

    public static ArrayList<Nodo> getPostorder(Nodo raiz){
        ArrayList<Nodo> res = new ArrayList<>();
        if(raiz == null){
            return res;
        }

        for(Nodo hijo : raiz.getHijos()){
            res.addAll(getPostorder(hijo));
        }
        res.add(raiz);

        return res;
    }
}