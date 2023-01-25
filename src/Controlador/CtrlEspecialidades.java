/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.Especialidad;
import Utilidades.Utilidades;
import java.io.IOException;

/**
 *
 * @author vivi
 */
public class CtrlEspecialidades {

    // private final Integer MAXIMO_CUENTAS = 25;
    private ListaEnlazada<Especialidad> listaEspecialidades;
    
    public ListaEnlazada<Especialidad> getEspecialidades(){
        return this.listaEspecialidades;
    }

    public CtrlEspecialidades() {
        listaEspecialidades = new ListaEnlazada<>();
    }

    //verifica si la cuenta existe
    public void registrarEspecialidad(Especialidad nueva) throws Exception {
        listaEspecialidades.add(nueva);
        
        guardar();
    }
    
    //guarda los datos de las especialidades
    public void guardar() throws IOException {
        System.out.println("Guadando especialidades....");

        Utilidades.guardarJson(this, "ControladorEspecialidades");
    }
}
