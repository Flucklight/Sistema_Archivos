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

    public void crearDirectorio(String nombreDirectorio) {
        ((Directorio) this.apuntador.getPuntero()).agregarDirectorio(nombreDirectorio);
    }

    public void crearArchivo(String nombreArchivo) {
        ((Directorio) this.apuntador.getPuntero()).agregarArchivo(nombreArchivo);
    }

    public void mover(Nodo origen, Nodo destino) {
        this.apuntador.mover(origen);
        this.apuntador.getPuntero().setPadre(destino);
    }

    public void copiar(Nodo origen, Nodo destino) {
        Apuntador aux = new Apuntador(origen);
        this.apuntador.mover(destino);
    }

    public void guardar() throws IOException {
        this.guardar = new BufferedWriter(new FileWriter(this.archivoFuente));
        // No se como vamos a escribir en el archivo fuente
        // Cesar aqui va lo de serialize :P te toca este cacho.
    }

}
