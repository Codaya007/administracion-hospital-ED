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

    public boolean ExisteEnTabla(JTable tblCitasSinAtender, String cedula, int col) {
        boolean Existe = false;
        for (int i = 0; i < tblCitasSinAtender.getRowCount(); i++) {
            if (tblCitasSinAtender.getValueAt(0, col).equals(cedula)) {
                Existe = true;
            }
        }
        return Existe;
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
