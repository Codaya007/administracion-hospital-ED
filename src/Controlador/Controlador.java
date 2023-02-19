/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vista.frmUsuarioConsultarCita;
import javax.swing.JTable;

/**
 *
 * @author Victor
 */
public class Controlador extends frmUsuarioConsultarCita{
    
    //busqueda lineal
    public int busquedaLineal(int[] arr, int elemento) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elemento) {
                return i;
            }
        }
        return -1;
    }
    
    //verificar si un valor esta dentro de una tabla
    @Override
    public boolean ExisteEnLista(JTable tblCitasSinAtender, String cedula, int col) {
        boolean Existe = false;
        for (int i = 0; i < tblCitasSinAtender.getRowCount(); i++) {
            if (tblCitasSinAtender.getValueAt(0, col).equals(cedula)) {
                Existe = true;
            }
        }
        return Existe;
    }
    
    //metodo quicksort
    public static void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pivot = partition(array, inicio, fin);
            quickSort(array, inicio, pivot);
            quickSort(array, pivot + 1, fin);
        }
    }
    //busqueda binaria 
    private static int partition(int[] array, int inicio, int fin) {
        int pivot = array[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;
        return i;
    }
    
    


//    public static String NombreVacio = "Vacio";
//    public Paciente cadenaPaciente;
//    private Paciente[] pacienteEnlazado;
//    public Paciente getCadenaPaciente() {
//        if(cadenaPaciente == null)
//            cadenaPaciente = new Paciente(NombreVacio, NombreVacio, NombreVacio, NombreVacio, NombreVacio, NombreVacio, NombreVacio, NombreVacio, NombreVacio);
//        return cadenaPaciente;
//    }
//
//    public void setCadenaPaciente(Paciente cadenaPaciente) {
//        this.cadenaPaciente = cadenaPaciente;
//    }
//
//    public Paciente[] getPacienteEnlazado() {
//        return pacienteEnlazado;
//    }
//
//    public void setPacienteEnlazado(Paciente[] pacienteEnlazado) {
//        this.pacienteEnlazado = pacienteEnlazado;
//    }
}
