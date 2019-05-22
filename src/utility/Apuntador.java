package utility;

public class Apuntador {
    private Nodo puntero;
    private String ruta;

    public Apuntador(Nodo raiz) {
        this.puntero = raiz;
        this.ruta = "";
        this.ruta += this.puntero.getNombre() + "/";
    }

    public void setPuntero(Nodo puntero) {
        this.puntero = puntero;
    }

    public Nodo getPuntero() {
        return puntero;
    }

    public String getRuta() {
        return ruta;
    }
}
