package utility;

public class Directorio extends Nodo {

    public Directorio(Nodo padre, String nombre) {
        super(nombre);
        this.setPadre(padre);
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
