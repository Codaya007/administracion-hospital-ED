/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ListaEnlazada;

/**
 *
 * @author Victor
 */
public class NodoLista<E> {
    
    private E dato;
    private NodoLista<E> siguiente;

    public NodoLista(E dato, NodoLista<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    //obtiene el dato
    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
    
    //se dirigue hacia el siguiente
    public NodoLista<E> getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoLista<E> siguiente) {
        this.siguiente = siguiente;
    }
    
    public NodoLista() {
    }
    
    //convierte en cadena
    @Override
    public String toString() {
        return dato.toString();
    }
}
