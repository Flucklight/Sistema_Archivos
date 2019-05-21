package utility;

import java.util.ArrayList;

public class Nodo {
    private String nombre;
    private ArrayList<Nodo> hijos;

    public Nodo(String nombre){
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    public void addHijo(String nombre){
        hijos.add(new Nodo(nombre));
    }

    public ArrayList<Nodo> getHijos(){
        return new ArrayList<>(hijos);
    }

    public Nodo getHijo(int indice){
        if (indice < hijos.size())
            return hijos.get(indice);

        return null;
    }

    public static void print(Nodo raiz){
        printAux(raiz, 0);
    }

    public static void printAux(Nodo nodo, int espaciado){
        for (int i = 0; i < espaciado; ++i)
            System.out.print("      ");

        System.out.println(nodo.nombre);

        for (Nodo hijo : nodo.getHijos())
            printAux(hijo, espaciado + 1);
    }
}
