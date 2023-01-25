/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Modelo.Rol;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JComboBox;

/**
 *
 * @author vivic
 */
public class Utilidades {

    private static final String DIRDATA = "data";
    public static final Integer INDEX_SUPERADMIN_ROLE = 0;
    public static final Integer INDEX_MEDICO_ROLE = 1;
    public static final Integer INDEX_ENFERMERA_ROLE = 2;
    public static final Integer INDEX_PACIENTE_ROLE = 3;

    public static Object cargarJson(Class clazz, String nombreArchivo) {
        return new FileJSON(nombreArchivo).cargar(clazz);
    }

    public static Object guardarJson(Object controlador, String nombreArchivo) {
        return new FileJSON(nombreArchivo).guardar(controlador);
    }

    public static Boolean guardarArray(Object array[], String nombreArchivo) {
        try {
            Gson json = new Gson();
            String jsons = json.toJson(array);
            FileWriter fw = new FileWriter(DIRDATA + File.separatorChar + nombreArchivo + ".json");
            fw.write(jsons);
            fw.flush();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public Rol[] cargarRoles(String nombreArchivo, Class clazz) {
//        try {
//            System.out.println("Cargando roles...");
//            Gson json = new Gson();
//            FileReader fr = new FileReader(DIRDATA + File.separatorChar + nombreArchivo + ".json");
//            StringBuilder jsons = new StringBuilder();
//            // boolean isComa;
//            int valor = fr.read();
//            while (valor != -1) {
//                jsons.append((char) valor);
//                valor = fr.read();
//            }
//            
//            return json.fromJson(jsons.toString(), Rol[].class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("No se encontraron objetos guardados en el json!");
//            inicializarRoles();
//        }
//        return null;
//    }
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

    public static Rol[] getRoles() {
        Rol rolMedico = new Rol();
        rolMedico.setNombre("Medico");
        rolMedico.setDescripcion("Médicos de todas las especialidades del hospital");

        Rol rolEnfermera = new Rol();
        rolEnfermera.setNombre("Enfermera");
        rolEnfermera.setDescripcion("Enfermeras del hospital");

        Rol rolPaciente = new Rol();
        rolPaciente.setNombre("Paciente");
        rolPaciente.setDescripcion("Pacientes del hospital");

        Rol rolSuperAdmin = new Rol();
        rolSuperAdmin.setNombre("SuperAdmin");
        rolSuperAdmin.setDescripcion("Tiene mayores privilegios para la administración del hospital");

        Rol roles[] = new Rol[4];

        roles[INDEX_MEDICO_ROLE] = rolMedico;
        roles[INDEX_ENFERMERA_ROLE] = rolEnfermera;
        roles[INDEX_SUPERADMIN_ROLE] = rolSuperAdmin;
        roles[INDEX_PACIENTE_ROLE] = rolPaciente;

        // guardarArray(roles, "roles");

        return roles;
    }

    public static void rellenarCombo(JComboBox cmb, Object array[]) {
        cmb.removeAllItems();
        Integer size = ultimoElementoNoVacio(array);
        if (size == null) {
            size = array.length;
        }

        for (int i = 0; i < size; i++) {
            cmb.addItem(array[i]);
        }
    }

    public static void eliminarElemento(Object array[], Integer index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }
}
