/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author vivic
 */
public enum Roles {
    Medico(0, "Médico", "Médicos de todas las especialidades del hospital"),
    Enfermera(1, "Enfermera", "Enfermeras del hospital"),
    Paciente(2, "Paciente", "Pacientes del hospital"),
    SuperAdmin(3, "Super administrador", "Tiene mayores privilegios para la administración del hospital");

    private Integer index;
    private String nombre;
    private String descripcion;

    //Añadir un onstructor
    Roles(Integer i, String name, String desc) {
        index = i;
        nombre = name;
        descripcion = desc;
    }

    public Integer getIndex() {
        return index;
    }
    
    public String getNombre(){
        return nombre;
    }
   
    public String getDescripcion(){
        return descripcion;
    }

    public static Roles getRolByIndex(int index) {
        switch (index) {
            case 0:
                return Roles.Medico;
            case 1:
                return Roles.Enfermera;
            case 2:
                return Roles.Paciente;
            case 3:
                return Roles.SuperAdmin;
            default:
                return null;
        }
    }
    
    public static Roles fromName(String nombre) {
        for (Roles b : Roles.values()) {
            if (b.nombre.equalsIgnoreCase(nombre)) {
                return b;
            }
        }
        return null;
    }

    //Añadir un método
    @Override
    public String toString() {
        return nombre;
    }
}
