package utility.tree;

import java.util.ArrayList;

public class Raiz extends Nodo {

    public Raiz(String nombre) {
        super(nombre);
        this.setHijos(new ArrayList<Nodo>());
    }

    protected void agregarDirectorio(String nombre) {
        this.getHijos().add(new Directorio(this, nombre));
    }

    protected void agregarArchivo(String nombre) {
        this.getHijos().add(new Archivo(this, nombre));
    }

    protected void mostrarHijos() {
        for (Nodo n : this.getHijos()) {
            System.out.println(n.getNombre());
        }
    }

    protected void mostrarArbol() {
        mostrarArbolProceso(this, 0);
    }

    private void mostrarArbolProceso(Nodo nodo, int spacing) {
        for (int i = 0; i < spacing; ++i) {
            System.out.print("\t");
        }
        System.out.println(nodo.getNombre());
        if (nodo.getHijos() != null && !nodo.getHijos().isEmpty()) {
            for (Nodo hijo : nodo.getHijos()) {
                mostrarArbolProceso(hijo, spacing + 1);
            }
        }
    }
}
