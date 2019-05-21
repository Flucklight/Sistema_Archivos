package utility;

public class Arbol {
    public static void main(String[] args) {
        Nodo raiz = new Nodo("root");

        raiz.addHijo("Documents");
        raiz.getHijo(0).addHijo("School");
        raiz.getHijo(0).getHijo(1).addHijo("Stuff.docx");
        raiz.getHijo(0).getHijo(1).addHijo("SomeOtherStuff.pptx");

        raiz.addHijo("Images");
        raiz.getHijo(1).addHijo("Wallpapers");
        raiz.getHijo(1).getHijo(0).addHijo("NotHentai.png");
        raiz.getHijo(1).addHijo("Memes");
        raiz.getHijo(1).getHijo(1).addHijo("Fun.png");
        raiz.getHijo(1).getHijo(1).addHijo("Superfun.png");

        Nodo.print(raiz);
    }
}