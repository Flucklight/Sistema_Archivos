package utility;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
    private ArrayList<Nodo> hijos;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
