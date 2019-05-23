package utility;

import java.util.ArrayList;

public class Raiz extends Nodo {

    public Raiz(String nombre) {
        super(nombre);
        this.setHijos(new ArrayList<Nodo>());
    }

    public void agregarDirectorio(String nombre) {
        this.getHijos().add(new Directorio(this, nombre));
    }

    public void agregarArchivo(String nombre) {
        this.getHijos().add(new Archivo(this, nombre));
    }

    public void mostrarHijos() {
        for (Nodo n : this.getHijos()) {
            System.out.println(n.getNombre());
        }
    }

    public void mostrarArbol() {
        mostrarArbolProceso(this.getHijos());
    }

    private void mostrarArbolProceso(ArrayList<Nodo> nodos) {
        if (nodos != null && !nodos.isEmpty()) {
            for (Nodo n : nodos) {
                System.out.println("\t" + n.getNombre());
                mostrarArbolProceso(n.getHijos());
            }
        }
    }
}
