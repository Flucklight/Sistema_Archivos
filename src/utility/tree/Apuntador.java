package utility.tree;

import java.util.Stack;

public class Apuntador {
    private Nodo puntero;
    private String ruta;

    public Apuntador(Nodo raiz) {
        this.puntero = raiz;
        enrutar();
    }

    public void enrutar() {
        Nodo tmp = this.puntero;
        Stack<String> stack = new Stack<>();
        this.ruta = "";
        do {
            stack.push(tmp.getNombre());
            tmp = tmp.getPadre();
        } while (tmp != null);
        while (!stack.empty()) {
            this.ruta += stack.pop() + "/";
        }
    }

    public void setPuntero(Nodo puntero) {
        this.puntero = puntero;
        enrutar();
    }

    protected Nodo getPuntero() {
        return puntero;
    }

    protected String getRuta() {
        return ruta;
    }


}
