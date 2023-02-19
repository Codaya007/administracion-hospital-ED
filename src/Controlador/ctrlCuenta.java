/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.Pbkdf2;
import Modelo.Rol;
import Modelo.Roles;
import Utilidades.Utilidades;
import java.io.IOException;

/**
 *
 * @author vivi
 */
public class ctrlCuenta {

    private final Integer MAXIMO_CUENTAS = 100;
    private Cuenta cuentas[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasMedicos[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasEnfermeros[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasSuperAdmins[] = new Cuenta[MAXIMO_CUENTAS];
    private Integer ocupados = 0;
    private byte[] salt;

    public ctrlCuenta() {
    }

    //verifica si la cuenta existe
    public void registrarUsuario(Cuenta nuevaCuenta) throws IOException {
        if (!usuarioValido(nuevaCuenta.getUsuario())) {
            throw new Error("El usuario ya está en uso, intente con otro usuario");
        }

        if (MAXIMO_CUENTAS - 1 == ocupados) {
            throw new Error("NO se pueden registrar más usuarios");
        }

        cuentas[ocupados] = nuevaCuenta;

        // Si es médico o enfermera se debe añadir a las otras listas
        if (nuevaCuenta.getPersona().getRol().getNombre().equals(Roles.Medico.toString())) {
            cuentasMedicos[Utilidades.ultimoElementoNoVacio(cuentasMedicos)] = nuevaCuenta;
        } else if (nuevaCuenta.getPersona().getRol().getNombre().equals(Roles.Enfermera.toString())) {
            cuentasEnfermeros[Utilidades.ultimoElementoNoVacio(cuentasEnfermeros)] = nuevaCuenta;
        }

        ocupados += 1;
        guardar();
    }

    //verifica la informacion que ingresa el usuario
    public boolean usuarioValido(String usuario) {
        Integer lastIndex = Utilidades.ultimoElementoNoVacio(cuentas);
        if (lastIndex == null) {
            lastIndex = cuentas.length;
        }

        for (int i = 0; i < lastIndex; i++) {
            Cuenta cuenta = cuentas[i];

            if (cuenta.getUsuario() == null ? (usuario) == null : cuenta.getUsuario().equals(usuario)) {
                return false;
            }
        }

        return true;
    }

    //Ingresa al sistema
    public boolean login(String usuario, String clave) {
        for (int i = 0; i < ocupados; i++) {
            Cuenta cuenta = cuentas[i];
            if (cuenta.getUsuario().equals(usuario)) {
                try {
                    return cuenta.login(usuario, clave, salt);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        return false;
    }

    //guarda los datos que ingreso el usuario
    public void guardar() throws IOException {
        System.out.println("Guardando ControladorCuenta....");

        Utilidades.guardarJson(this, "ControladorCuenta");
    }

    public byte[] getSalt() {
        if (salt == null) {
            try {
                salt = Pbkdf2.generateSalt();
                this.guardar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return salt;
    }
/**
 * Getters y Setters de las cuentas
 */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Integer getOcupados() {
        return ocupados;
    }

    public void setOcupados(Integer ocupados) {
        this.ocupados = ocupados;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }


/**
 * Metodo para actualizar el rol de cuenta
 * @param cuenta a actualizar
 * @throws Exception por si surge un error
 */
    public void actualizarRolCuenta(Cuenta cuenta) throws Exception {
        // Si voy a actualizar el rol de una persona que está en la lista, primero confirmo que esté
        Integer findInIndex = Utilidades.buscarCuentaLinealPorCedula(cuentas, cuenta.getPersona().getIdentificacion());

        if (findInIndex == -1) {
            throw new Exception(cuenta.toString() + " no encontrado");
        }

        // Obtengo el nuevo rol de la persona
        Rol nuevoRol = cuenta.getPersona().getRol();

        // elimino la cuenta de todas las listasa
        eliminarCuenta(cuenta.getPersona().getIdentificacion());
        // Depende del nuevo rol, vuelvo a agregar la persona en la lista del rol que corresponda
        if (nuevoRol.getNombre() == Roles.Medico.getNombre()) {
            Integer lastEmptyIndex = Utilidades.ultimoElementoNoVacio(cuentasMedicos);

            cuentasMedicos[lastEmptyIndex] = cuenta;
        } else if (nuevoRol.getNombre() == Roles.Enfermera.getNombre()) {
            Integer lastEmptyIndex = Utilidades.ultimoElementoNoVacio(cuentasEnfermeros);

            cuentasEnfermeros[lastEmptyIndex] = cuenta;
        } else if (nuevoRol.getNombre() == Roles.SuperAdmin.getNombre()) {
            Integer lastEmptyIndex = Utilidades.ultimoElementoNoVacio(cuentasSuperAdmins);

            cuentasSuperAdmins[lastEmptyIndex] = cuenta;
        }

        // Y la vuelvo a guardar en la lista general, de todos los roles.
        Integer lastIndexCuentas = Utilidades.ultimoElementoNoVacio(cuentas);
        if (lastIndexCuentas == null) {
            lastIndexCuentas = cuentas.length;
        }

        cuentas[lastIndexCuentas] = cuenta;
        ocupados += 1;
        // Actualizo el JSON
        this.guardar();
    }
    
    /**
     * Metodo para eliminar cuenta
     * @param cedula a eliminar
     */

    public void eliminarCuenta(String cedula) {
        try {
            // Cuando envío a eliminar una cuenta, no sé qué indice ocupa, así que la busco por cédula, que es un atributo único
            // en las cuentas. La elimino de toda las listas en las que esté la persona
            Integer indexCuentas = Utilidades.buscarCuentaLinealPorCedula(cuentas, cedula);
            Integer indexCuentasMedicos = Utilidades.buscarCuentaLinealPorCedula(cuentasMedicos, cedula);
            Integer indexCuentasEnfermeros = Utilidades.buscarCuentaLinealPorCedula(cuentasEnfermeros, cedula);
            Integer indexCuentasSuperAdmin = Utilidades.buscarCuentaLinealPorCedula(cuentasSuperAdmins, cedula);

            // Si la cuenta ha sido hallada en alguna lista, las elimino de ahí
            if (indexCuentas != -1) {
                Utilidades.eliminarElemento(cuentas, indexCuentas);
                ocupados -= 1;
            }
            if (indexCuentasMedicos != -1) {
                Utilidades.eliminarElemento(cuentasMedicos, indexCuentasMedicos);
            }
            if (indexCuentasEnfermeros != -1) {
                Utilidades.eliminarElemento(cuentasEnfermeros, indexCuentasEnfermeros);
            }
            if (indexCuentasSuperAdmin != -1) {
                Utilidades.eliminarElemento(cuentasSuperAdmins, indexCuentasSuperAdmin);
            }

            this.guardar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
