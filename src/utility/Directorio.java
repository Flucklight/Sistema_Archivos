package utility;

public class Directorio extends Nodo {
    private Nodo padre;

    public Directorio(Nodo padre, String nombre) {
        super(nombre);
        this.padre = padre;
    }

    public void agregarNodo(String nombre) {
        this.getHijos().add(new Nodo(nombre));
    }

    public void mostrarHijos() {
        for (Nodo n : this.getHijos()) {
            System.out.println(n.getNombre());
        }
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
}
