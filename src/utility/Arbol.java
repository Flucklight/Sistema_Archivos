package utility;

import java.io.*;

public class Arbol {
    private Raiz raiz;
    private Apuntador apuntador;
    private File archivoFuente;
    private BufferedReader cargar;
    private BufferedWriter guardar;

    public Arbol() throws FileNotFoundException{
        this.archivoFuente = new File(System.getProperty("user,dir")
                + "/src/items/archivoFuente.tree");
        this.cargar();
    }

    public void cargar() throws FileNotFoundException {
        this.cargar = new BufferedReader(new FileReader(this.archivoFuente));
        // No se como vamos a leer en el archivo fuente
        // Cesar aqui va lo de deserialize :P te toca este cacho
        // ademas de que aqui inicializas la raiz y el apuntador.
    }

    public void guardar() throws IOException {
        this.guardar = new BufferedWriter(new FileWriter(this.archivoFuente));
        // No se como vamos a escribir en el archivo fuente
        // Cesar aqui va lo de serialize :P te toca este cacho.
    }

    //Navegacion

    public boolean accederDirectorioRelativo(String nombre) {
        for (Nodo n : this.apuntador.getPuntero().getHijos()) {
            if (n.getNombre().equals(nombre)) {
                this.apuntador.mover(n);
                return true;
            }
        }
        return false;
    }

    public boolean accederDirectorioAbsoluto(String ruta) {
        Nodo aux = this.apuntador.getPuntero();
        this.apuntador.goToRaiz();
        String[] dir = ruta.split("/");
        for (int i = 1; i < dir.length; i++) {
            if (!this.accederDirectorioRelativo(dir[i])) {
                this.apuntador.mover(aux);
                return false;
            }
        }
        return true;
    }

    public void retrocederDirectorio() {
        this.apuntador.mover(this.apuntador.getPuntero().getPadre());
    }

    public void goToRaiz() {
        this.apuntador.goToRaiz();
    }

    public void mostrarContenido() {
        ((Directorio) this.apuntador.getPuntero()).mostrarHijos();
    }

    //Manejo de Archivos

    public void crearArchivoRelativo(String nombreArchivo) {
        ((Directorio) this.apuntador.getPuntero()).agregarArchivo(nombreArchivo);
    }

    public boolean crearArchivoAbsoluto(String ruta, String nombreArchivo) {
        Nodo aux = this.apuntador.getPuntero();
        if (this.accederDirectorioAbsoluto(ruta)) {
            ((Directorio) this.apuntador.getPuntero()).agregarArchivo(nombreArchivo);
            this.apuntador.mover(aux);
            return true;
        } else {
            return false;
        }
    }

    //Manejo de Directorios

    public void crearDirectorio(String nombreDirectorio) {
        ((Directorio) this.apuntador.getPuntero()).agregarDirectorio(nombreDirectorio);
    }

    public boolean crearDirectorioAbsoluto(String ruta, String nombreDirectorio) {
        Nodo aux = this.apuntador.getPuntero();
        if (this.accederDirectorioAbsoluto(ruta)) {
            ((Directorio) this.apuntador.getPuntero()).agregarDirectorio(nombreDirectorio);
            this.apuntador.mover(aux);
            return true;
        } else {
            return false;
        }
    }

    //Ordenes Globales

    public boolean mover(String origen, String destino) {
        if (this.accederDirectorioRelativo(origen)) {
            Nodo aux = this.apuntador.getPuntero();
            if (this.accederDirectorioAbsoluto(destino)) {
                aux.setPadre(this.apuntador.getPuntero());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean copiar(String origen, String destino) {
        if (this.accederDirectorioRelativo(origen)) {
            Nodo aux = new Nodo(this.apuntador.getPuntero());
            if (this.accederDirectorioAbsoluto(destino)) {
                this.apuntador.getPuntero().getHijos().add(aux);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean borrar(String origen) {
        if (this.accederDirectorioRelativo(origen)) {
            Nodo aux = this.apuntador.getPuntero();
            this.retrocederDirectorio();
            this.apuntador.getPuntero().getHijos().remove(aux);
            aux = null;
            return true;
        } else {
            return false;
        }
    }

}
