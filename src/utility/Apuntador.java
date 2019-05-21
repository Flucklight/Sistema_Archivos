package utility;

public class Apuntador {
    Nodo puntero;
    String ruta;

    public Apuntador(Nodo puntero) {
        this.puntero = puntero;
        this.ruta = "";
        this.ruta += this.puntero.getNombre();
    }

    public void mover(Nodo posicion){
        this.puntero = posicion;
        if (this.ruta.contains(this.puntero.getNombre())){
            //leo paro aqui con los subString mas o menos me imagino que
            //sabes que quiero hacer.
        } else {
            this.ruta += puntero.getNombre();
        }
    }

    public Nodo getPuntero() {
        return puntero;
    }

    public String getRuta() {
        return ruta;
    }
}
