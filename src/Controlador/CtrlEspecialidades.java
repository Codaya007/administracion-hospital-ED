/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Especialidad;
import Utilidades.Utilidades;
import java.io.IOException;

/**
 *
 * @author vivi
 */
public class CtrlEspecialidades {

    // Limito la creacion de especialidades
    private final Integer MAXIMO_ESPECIALIDADES = 25;
    // private ListaEnlazada<Especialidad> listaEspecialidades;
    private Especialidad listaEspecialidades[] = new Especialidad[MAXIMO_ESPECIALIDADES];

    public Especialidad[] getEspecialidades() {
        return this.listaEspecialidades;
    }

    public CtrlEspecialidades() {
    }

    public void registrarEspecialidad(Especialidad nueva) throws Exception {
        // Determino si hay lugar para una nueva especialidad
        Integer index = Utilidades.ultimoElementoNoVacio(listaEspecialidades);
        
        if(index == null) throw new Exception("Ya no se pueden agregar más especialidades");
        
        listaEspecialidades[index] = nueva;
        // Actualizo el JSON con la información
        guardar();
    }

    //guarda los datos de las listaEspecialidades
    public void guardar() throws IOException {
        Utilidades.guardarJson(this, "ControladorEspecialidades");
    }
}
