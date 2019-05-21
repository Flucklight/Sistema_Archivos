package utility;

public class Archivo extends Nodo {
    private String extension;
    private Nodo padre;

    public Archivo(Nodo padre, String nombre) {
        super(nombre);
        this.padre = padre;
        if (nombre.contains(".")) {
            String[] s = nombre.split(".");
            this.extension = s[1];
        }
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre + "." + this.extension);
    }
}
