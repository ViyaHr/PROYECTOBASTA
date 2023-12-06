package mx.uaemex.fi.basta.control;

import mx.uaemex.fi.basta.vista.VentanaInicial;
import mx.uaemex.fi.basta.vista.VentanaJuego;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ControladorVentanaInicial {
    private VentanaInicial ventanaInicial;
    private Socket socketCliente;

    public ControladorVentanaInicial(VentanaInicial ventanaInicial, Socket socketCliente) {
        this.ventanaInicial = ventanaInicial;
        this.socketCliente = socketCliente;

        this.ventanaInicial.setControlador(this);
    }

    // Método para manejar el evento de enviar nombre desde la ventana inicial
    public void enviarNombre(String nombreUsuario) {
        try (BufferedWriter escritorSalida = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()))) {
            // Enviar el nombre de usuario al servidor
            System.out.println("Enviando nombre de usuario: " + nombreUsuario);
            escritorSalida.write(nombreUsuario);
            escritorSalida.newLine();
            escritorSalida.flush();



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el socket en este bloque finally
            try {
                socketCliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

