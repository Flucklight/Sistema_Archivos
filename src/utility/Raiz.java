package utility;

import java.util.ArrayList;

public class Raiz extends Nodo {

    public Raiz(String nombre) {
        super(nombre);
        this.setHijos(new ArrayList<Nodo>());
    }

    public void agregarNodo(String nombre) {
        this.getHijos().add(new Nodo(nombre));
    }

}
