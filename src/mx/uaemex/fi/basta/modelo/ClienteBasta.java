package mx.uaemex.fi.basta.modelo;

import mx.uaemex.fi.basta.control.ControladorVentanaInicial;
import mx.uaemex.fi.basta.vista.VentanaInicial;

import java.io.*;
import java.net.Socket;

public class ClienteBasta {
    private static final String SERVIDOR_IP = "localhost";
    private static final int SERVIDOR_PUERTO = 12345;

    public static void main(String[] args) {
        new ClienteBasta().iniciarCliente();
    }

    public void iniciarCliente() {
        try (Socket socketCliente = new Socket(SERVIDOR_IP, SERVIDOR_PUERTO)) {
            VentanaInicial ventanaInicial = new VentanaInicial();
            ControladorVentanaInicial controladorVentanaInicial = new ControladorVentanaInicial(ventanaInicial, socketCliente);

            // Mostrar la ventana inicial para que el usuario ingrese su nombre
            ventanaInicial.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
