package utility;

public class Raiz extends Nodo {

    public Raiz(String nombre) {
        super(nombre);
    }

    public void agregarNodo(String nombre) {
        this.getHijos().add(new Nodo(nombre));
    }

    public void mostrarHijos() {
        for (Nodo n : this.getHijos()) {
            System.out.println(n.getNombre());
        }
    }

    @Override
    public void setPadre(Nodo padre) {
        super.setPadre(null);
    }

}
