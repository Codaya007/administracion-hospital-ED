/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author vivic
 */
public class Utilidades {

    public static Object cargarJson(Class clazz, String nombreArchivo) {
        return new FileJSON(nombreArchivo).cargar(clazz);
    }

    public static Object guardarJson(Object controlador, String nombreArchivo) {
        return new FileJSON(nombreArchivo).guardar(controlador);
    }
}
