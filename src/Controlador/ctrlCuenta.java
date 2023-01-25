/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuenta;
import Utilidades.Utilidades;
import Modelo.Pbkdf2;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author vivi
 */
public class CtrlCuenta {

    private final Integer MAXIMO_CUENTAS = 100;
    private Cuenta cuentas[] = new Cuenta[MAXIMO_CUENTAS];
    Integer ocupados = 0;
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
        ocupados += 1;
        guardar();
    }

    //verifica la informacion que ingresa el usuario
    public boolean usuarioValido(String usuario) {
        for (int i = 0; i < ocupados; i++) {
            Cuenta cuenta = cuentas[i];

            if (cuenta.getUsuario().equals(usuario)) {
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
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
