/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Rol;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Utilidades extends Vista.frmUsuarioIngresarDatos {

//    //obtener el valor de la clase enum GeneroComboBox
//    public static JComboBox cargarComboGenero(JComboBox cbx){
//        cbx.removeAllItems();
//        for(GeneroComboBox tipo: GeneroComboBox.values()) {
//            cbx.addItem(tipo);
//        }
//        return cbx;
//    }
//    
//    public static GeneroComboBox getComboGenero(JComboBox  cbx){
//        return (GeneroComboBox)cbx.getSelectedItem();
//    }
    //verificar si el numero de cedula es valido
    public static String Cedula() {
        String NumeroCedula = txtNumeroCedula.getText();
        if (NumeroCedula.length() == 10) {

        } else {
            JOptionPane.showMessageDialog(null, "El numero de cedula esta mal establecido", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        return NumeroCedula;
    }

    //verificacion si existe en el arreglo
    public static <T> boolean contains(final T[] array, final T v) {
        for (final T e : array) {
            if (e == v || v != null && v.equals(e)) {
                return true;
            }
        }

        return false;
    }

    //cargar combos de fechas
    public static void cargarCombosFecha(JComboBox dia, JComboBox mes, JComboBox anio) {
        dia.removeAllItems();
        mes.removeAllItems();
        anio.removeAllItems();

        // Lleno el combo de dias del 1 al 31
        for (int i = 1; i <= 31; i++) {
            dia.addItem(i);
        }

        // Lleno el combo de mes del 1 al 12
        for (int i = 1; i <= 12; i++) {
            mes.addItem(i);
        }

        // Lleno el combo de año desde los 100 años anteriores
        Integer anio_actual = new Date().getYear() + 1900;
        for (int i = anio_actual; i >= (anio_actual - 100); i--) {
            anio.addItem(i);
        }
    }

    //cargar combo de roles
    public static JComboBox cargarComboRoles(JComboBox cbx, Rol roles[]) {
        cbx.removeAllItems();

        for (Rol rol : roles) {
            cbx.addItem(rol.getNombre());
        }

        return cbx;
    }

    //ocupado
    public static int ultimoIndiceOcupado(Object array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("i -> " + i);
            if (array[i] == null) {
                return i;
            }
        }

        return array.length;
    }
}
