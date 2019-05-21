package utility;

public class Apuntador {
    Nodo puntero;
    String ruta;

    public Apuntador(Nodo puntero) {
        this.puntero = puntero;
        this.ruta = "";
        this.ruta += this.puntero.getNombre()+"/";
    }

    public void mover(Nodo posicion){
        this.puntero = posicion;
        if (this.ruta.contains(this.puntero.getNombre())){
            int index = ruta.length()-1;
            while(ruta.charAt(index) != '/') {
			    index--;
		    }
		    ruta = ruta.substring(0, index);
        } else {
            this.ruta += puntero.getNombre()+"/";
        }
    }

    public Nodo getPuntero() {
        return puntero;
    }

    public String getRuta() {
        return ruta;
    }
}
