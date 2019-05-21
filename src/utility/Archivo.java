package utility;

public class Archivo extends Nodo {
    private String extension;

    public Archivo(Nodo padre, String nombre) {
        super(nombre);
        this.setPadre(padre);
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

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre + "." + this.extension);
    }
}
