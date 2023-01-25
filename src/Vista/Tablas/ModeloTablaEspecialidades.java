/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Tablas;

import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.Especialidad;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaEspecialidades extends AbstractTableModel{
    private Especialidad especialidades[];

    public Especialidad[] getUniones() {
        return especialidades;
    }

    public void setUniones(ListaEnlazada<Especialidad> especialidades) {
        this.especialidades = new Especialidad[especialidades.size()];
        
        for (int i = 0; i < especialidades.size(); i++) {
            try {
                this.especialidades[i] = especialidades.obtener(i);
            } catch(Exception ex) {
            System.out.println(ex);
            }
        }
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        System.out.println("Rows: " + (especialidades == null ? 0 : especialidades.length) );
        return especialidades == null ? 0 : especialidades.length;
    }
    
    //creacion de la tabla para la presentacion de las citas
    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Nro";
            case 1: return "Nombre";    
            case 2: return "Descripción"; 
            default: return null;
        }
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        Especialidad esp = null;
        
        if(especialidades != null){
            esp = especialidades[i];
            
        }
        
        System.out.println("Especialidad: " + esp);
        
        switch(i1) {
            case 0: 
                return (esp != null) ? esp.getId(): i;    
            case 1: 
                return (esp != null) ? esp.getNombre(): "INDEFINIDO";    

            case 2: 
                return (esp != null) ? esp.getDescripcion() : "INDEFINIDO";
            default: 
                return null;
        }
    }
}
