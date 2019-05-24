package utility.tree;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
    private Nodo padre;
    private ArrayList<Nodo> hijos;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.hijos = null;
        this.padre = null;
    }

    public Nodo(Nodo origen) {
        this.nombre = origen.getNombre();
        this.hijos = origen.getHijos();
        this.padre = origen.getPadre();
    }

    protected Nodo getPadre() {
        return padre;
    }

    protected void setPadre(Nodo padre) {
        this.padre = padre;
    }

    protected void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    protected ArrayList<Nodo> getHijos() {
        return hijos;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
