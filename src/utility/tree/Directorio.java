package utility.tree;

import java.util.ArrayList;

public class Directorio extends Nodo {

    public Directorio(Nodo padre, String nombre) {
        super(nombre);
        this.setPadre(padre);
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
}
