package utility;

import java.util.Stack;

public class Apuntador {
    Nodo puntero;
    Nodo raiz;
    String ruta;

    public Apuntador(Nodo raiz) {
        this.puntero = raiz;
        this.raiz = raiz;
        this.ruta = "";
        this.ruta += this.puntero.getNombre() + "/";
    }

    public void mover(Nodo posicion){
        this.puntero = posicion;
        this.ruta = "";

        Nodo aux = posicion;
        Stack<String> stack = new Stack<>();

        do {
            if (aux.equals(this.raiz)){
                ruta += aux.getNombre() + "/";
                do {
                    ruta += stack.pop() + "/";
                } while (stack.empty());
                break;
            } else {
                stack.push(aux.getNombre());
                aux = ((Directorio) aux).getPadre();
            }
        } while (true);
    }

    public Nodo getPuntero() {
        return puntero;
    }

    public String getRuta() {
        return ruta;
    }
}
