package utility;

import java.util.ArrayList;

public class Directorio extends Nodo {

    public Directorio(Nodo padre, String nombre) {
        super(nombre);
        this.setPadre(padre);
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
}
