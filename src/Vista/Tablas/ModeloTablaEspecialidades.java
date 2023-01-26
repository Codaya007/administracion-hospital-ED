/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Tablas;

import Modelo.Especialidad;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaEspecialidades extends AbstractTableModel{
    private Especialidad especialidades[] =  new Especialidad[]{};

    public Especialidad[] getUniones() {
        return especialidades;
    }

    public void setEspecialidades(Especialidad[] especialidades) {
        if(especialidades.length == 0) this.especialidades = new Especialidad[]{};
        else{
        Especialidad result[] = new Especialidad[Utilidades.Utilidades.ultimoElementoNoVacio(especialidades)];
        //System.out.println("Longitud de especialidades: " + result.length);
        
        for (int i = 0; i < result.length; i++) {
            //System.out.println("Elemento " + i + ": " + result[i]);
            result[i] = especialidades[i];
        }
        
        this.especialidades = result;
        }
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
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
        
        //System.out.println("Especialidad: " + esp);
        
        switch(i1) {
            case 0: 
                return (esp != null) ? esp.getId(): i+1;    
            case 1: 
                return (esp != null) ? esp.getNombre(): "INDEFINIDO";    

            case 2: 
                return (esp != null) ? esp.getDescripcion() : "INDEFINIDO";
            default: 
                return null;
        }
    }
}
