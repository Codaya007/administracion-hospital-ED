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

    public static Integer ultimoElementoNoVacio(Object[] array) {  // 2 de 2 [a, b]
        Integer index = 0;

        while (index < array.length) {      // while index < 2  // index = 0
            Object aux = array[index];      // a    b
            if (aux == null) {
                break;
            }

            index += 1;                     // index = 1        // -> 2
        }

        return index == array.length ? null : index;
    }
}
