package utility;

public class Archivo extends Nodo {

    public Archivo(Nodo padre, String nombre) {
        super(nombre);
        this.setPadre(padre);
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
}
