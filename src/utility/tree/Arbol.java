package utility.tree;

import javax.swing.*;
import java.io.*;

public class Arbol {
    private Raiz raiz;
    private Apuntador apuntador;
    private File archivoFuente;
    private BufferedReader cargar;
    private BufferedWriter guardar;

    public Arbol() {
        this.archivoFuente = new File(System.getProperty("user,dir")
                + "/src/items/archivoFuente.tree");
        this.cargar();
    }

    public void simulacion() {
        String s = "";
        boolean ciclo = true;
        while (ciclo) {
            System.out.println("\n");
            raiz.mostrarArbol();
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("\n" + this.apuntador.getRuta() + "\n");
            s = JOptionPane.showInputDialog("Dame una instruccion");
            switch (s) {
                case "mover" :
                    s = JOptionPane.showInputDialog("A donde quieres accerder");
                    if (!this.accederDirectorio(s)) {
                        System.out.println("Error");
                    }
                    break;

                case "moverA" :
                    s = JOptionPane.showInputDialog("A donde quieres accerder");
                    if (!this.accederDirectorioAbsoluto(s)) {
                        System.out.println("Error");
                    }
                    break;

                case "cd" :
                    this.retrocederDirectorio();
                    break;

                case "gtr" :
                    this.goToRaiz();
                    break;

                case "ls" :
                    this.mostrarContenido();
                    break;

                case "touch" :
                    s = JOptionPane.showInputDialog("Dame el nombre del archivo");
                    this.crearArchivo(s);
                    break;

                case "touchA" :
                    String r = JOptionPane.showInputDialog("Dame la ruta");
                    s = JOptionPane.showInputDialog("Dame el nombre del archivo");
                    if (!this.crearArchivoAbsoluto(r, s)) {
                        System.out.println("Error");
                    }
                    break;

                case "mkdir" :
                    s = JOptionPane.showInputDialog("Dame el nombre del directorio");
                    this.crearDirectorio(s);
                    break;

                case "mkdirA" :
                    String p = JOptionPane.showInputDialog("Dame la ruta");
                    s = JOptionPane.showInputDialog("Dame el nombre del archivo");
                    if (!this.crearDirectorioAbsoluto(p, s)) {
                        System.out.println("Error");
                    }
                    break;

                case "mv" :
                    String m = JOptionPane.showInputDialog("Que elemento deseas mover");
                    s = JOptionPane.showInputDialog("Dame la ruta a donde deseas moverlo");
                    this.mover(m, s);
                    break;

                case "cp" :
                    String c = JOptionPane.showInputDialog("Que elemento deseas copiar");
                    s = JOptionPane.showInputDialog("Dame la ruta a donde deseas copiarlo");
                    this.copiar(c, s);
                    break;

                case "rm" :
                    s = JOptionPane.showInputDialog("Dame el elemento a borrar");
                    this.borrar(s);
                    break;

                case "exit" :
                    ciclo = false;
                    break;

                default :
                    System.out.println("\n" + "Instruccion Erronea");
                    break;
            }
        }
    }

    private void cargar() {
        //this.cargar = new BufferedReader(new FileReader(this.archivoFuente));
        // No se como vamos a leer en el archivo fuente
        // Cesar aqui va lo de deserialize :P te toca este cacho
        // ademas de que aqui inicializas la raiz y el apuntador.
    }

    public void cargarSimulacion() {
        raiz = new Raiz("root");
        apuntador = new Apuntador(raiz);
        raiz.agregarArchivo("perrito.txt");
        raiz.agregarArchivo("gato.png");
        raiz.agregarDirectorio("Imagenes");
        raiz.agregarDirectorio("Documentos");
        raiz.agregarDirectorio("Porno-VR");
        this.simulacion();
    }

    private void guardar() {
        //this.guardar = new BufferedWriter(new FileWriter(this.archivoFuente));
        // No se como vamos a escribir en el archivo fuente
        // Cesar aqui va lo de serialize :P te toca este cacho.
    }

    //Navegacion

    public boolean accederDirectorio(String nombre) {
        for (Nodo n : this.apuntador.getPuntero().getHijos()) {
            if (n.getNombre().equals(nombre)) {
                this.apuntador.setPuntero(n);
                return true;
            }
        }
        return false;
    }

    public boolean accederDirectorioAbsoluto(String ruta) {
        Nodo aux = this.apuntador.getPuntero();
        this.goToRaiz();
        String[] dir = ruta.split("/");
        for (int i = 1; i < dir.length; i++) {
            if (!this.accederDirectorio(dir[i])) {
                this.apuntador.setPuntero(aux);
                return false;
            }
        }
        return true;
    }

    public void retrocederDirectorio() {
        if (this.apuntador.getPuntero().getPadre() != null) {
            this.apuntador.setPuntero(this.apuntador.getPuntero().getPadre());
        }
    }

    public void goToRaiz() {
        this.apuntador.setPuntero(this.raiz);
    }

    public void mostrarContenido() {
        if (this.apuntador.getPuntero().equals(this.raiz)) {
            ((Raiz) this.apuntador.getPuntero()).mostrarHijos();
        } else {
            ((Directorio) this.apuntador.getPuntero()).mostrarHijos();
        }
    }

    //Manejo de Archivos

    public void crearArchivo(String nombreArchivo) {
        if (this.apuntador.getPuntero().equals(this.raiz)) {
            ((Raiz) this.apuntador.getPuntero()).agregarArchivo(nombreArchivo);
        } else {
            ((Directorio) this.apuntador.getPuntero()).agregarArchivo(nombreArchivo);
        }
        this.guardar();
    }

    public boolean crearArchivoAbsoluto(String ruta, String nombreArchivo) {
        Nodo aux = this.apuntador.getPuntero();
        if (this.accederDirectorioAbsoluto(ruta)) {
            this.crearArchivo(nombreArchivo);
            this.apuntador.setPuntero(aux);
            return true;
        } else {
            return false;
        }
    }

    //Manejo de Directorios

    public void crearDirectorio(String nombreDirectorio) {
        if (this.apuntador.getPuntero().equals(this.raiz)) {
            ((Raiz) this.apuntador.getPuntero()).agregarDirectorio(nombreDirectorio);
        } else {
            ((Directorio) this.apuntador.getPuntero()).agregarDirectorio(nombreDirectorio);
        }
        this.guardar();
    }

    public boolean crearDirectorioAbsoluto(String ruta, String nombreDirectorio) {
        Nodo aux = this.apuntador.getPuntero();
        if (this.accederDirectorioAbsoluto(ruta)) {
            this.crearDirectorio(nombreDirectorio);
            this.apuntador.setPuntero(aux);
            return true;
        } else {
            return false;
        }
    }

    //Ordenes Globales

    public boolean mover(String elemeto, String destino) {
        if (this.accederDirectorio(elemeto)) {
            Nodo aux = this.apuntador.getPuntero();
            if (this.accederDirectorioAbsoluto(destino)) {
                aux.setPadre(this.apuntador.getPuntero());
                this.guardar();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean copiar(String elemento, String destino) {
        if (this.accederDirectorio(elemento)) {
            Nodo aux = new Nodo(this.apuntador.getPuntero());
            if (this.accederDirectorioAbsoluto(destino)) {
                this.apuntador.getPuntero().getHijos().add(aux);
                this.guardar();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void borrar(String elemento) {
        if (this.accederDirectorio(elemento)) {
            Nodo aux = this.apuntador.getPuntero();
            this.retrocederDirectorio();
            this.apuntador.getPuntero().getHijos().remove(aux);
            aux.setPadre(null);
            this.guardar();
        }
    }

}
