
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
public class CtrlCuenta {

    private final Integer MAXIMO_CUENTAS = 100;
    private Cuenta cuentas[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasMedicos[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasEnfermeros[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasSuperAdmins[] = new Cuenta[MAXIMO_CUENTAS];
    private Integer ocupados = 0;
    private byte[] salt;

    public CtrlCuenta() {
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
        System.out.println("Gurdando....");

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

    public void registrarMedico(Cuenta cuenta) throws Exception {
        Integer lastEmptyIndexCuentas = Utilidades.ultimoElementoNoVacio(cuentas);
        Integer lastEmptyIndex = Utilidades.ultimoElementoNoVacio(cuentasMedicos);

        if (lastEmptyIndex == null) {
            throw new Exception("Ya no se pueden registrar más médicos");
        }

        // Si es posible añadir más cuentas, primero elimino al médico de los arrays
        eliminarCuenta(cuenta.getPersona().getIdentificacion());
        // Y lo añado a la lista de cuentas y de médicos
        cuentasMedicos[lastEmptyIndex] = cuenta;
        cuentas[lastEmptyIndexCuentas] = cuenta;
        this.guardar();
    }

    public void registrarEnfermera(Cuenta cuenta) throws Exception {
        Integer lastEmptyIndexCuentas = Utilidades.ultimoElementoNoVacio(cuentas);
        Integer lastEmptyIndex = Utilidades.ultimoElementoNoVacio(cuentasEnfermeros);

        if (lastEmptyIndex == null) {
            throw new Exception("Ya no se pueden registrar más enfermeros");
        }

        // Si es posible añadir más cuentas, primero elimino al enfermero de los arrays
        eliminarCuenta(cuenta.getPersona().getIdentificacion());
        // Y lo añado a la lista de cuentas y de médicos
        cuentasEnfermeros[lastEmptyIndex] = cuenta;
        cuentas[lastEmptyIndexCuentas] = cuenta;

        this.guardar();
    }

    public void actualizarRolCuenta(Cuenta cuenta) throws Exception {
        Integer findInIndex = Utilidades.buscarCuentaLinealPorCedula(cuentas, cuenta.getPersona().getIdentificacion());

        if (findInIndex == -1) {
            throw new Exception(cuenta.toString() + " no encontrado");
        }

        Rol nuevoRol = cuenta.getPersona().getRol();

        eliminarCuenta(cuenta.getPersona().getIdentificacion());
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

        Integer lastIndexCuentas = Utilidades.ultimoElementoNoVacio(cuentas);
        if (lastIndexCuentas == null) {
            lastIndexCuentas = cuentas.length;
        }

        cuentas[lastIndexCuentas] = cuenta;
        ocupados += 1;
        this.guardar();
    }

    public void eliminarCuenta(String cedula) {
        try {
            Integer indexCuentas = Utilidades.buscarCuentaLinealPorCedula(cuentas, cedula);
            Integer indexCuentasMedicos = Utilidades.buscarCuentaLinealPorCedula(cuentasMedicos, cedula);
            Integer indexCuentasEnfermeros = Utilidades.buscarCuentaLinealPorCedula(cuentasEnfermeros, cedula);
            Integer indexCuentasSuperAdmin = Utilidades.buscarCuentaLinealPorCedula(cuentasSuperAdmins, cedula);

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
