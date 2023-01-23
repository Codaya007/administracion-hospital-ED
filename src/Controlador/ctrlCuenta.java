/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuenta;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vivi
 */
public class ctrlCuenta {

    private final Integer MAXIMO_CUENTAS = 100;
    private Cuenta cuentas[] = new Cuenta[MAXIMO_CUENTAS];
    Integer ocupados = 0;

    public ctrlCuenta() {
        cargar();
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
        cargar();
        for (int i = 0; i < ocupados; i++) {
            Cuenta cuenta = cuentas[i];
            if (cuenta.getUsuario().equals(usuario)) {
                return cuenta.login(usuario, clave);
            }
        }

        return false;
    }
    
    //guarda los datos que ingreso el usuario
    public void guardar() throws IOException {
        Gson json = new Gson();

        Cuenta[] cuentasCompletas = new Cuenta[ocupados];
        System.arraycopy(cuentas, 0, cuentasCompletas, 0, cuentasCompletas.length);

        String jsons = json.toJson(cuentasCompletas);
        FileWriter fw = new FileWriter("Cuentas" + ".json");
        fw.write(jsons);
        fw.flush();
    }
    
    //carga el json con la inforamcion del login
    public void cargar() {
        int counter = 0;

        try {

            Gson json = new Gson();
            FileReader fr = new FileReader("Cuentas" + ".json");
            StringBuilder jsons = new StringBuilder();
            int valor = fr.read();

            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }

            Cuenta[] aux = json.fromJson(jsons.toString(), Cuenta[].class);

            for (int i = 0; i < aux.length; i++) {
                cuentas[i] = aux[i];
                counter += 1;
            }

            ocupados = counter;
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados en el json!");
        }
    }
}
