package mx.uaemex.fi.basta.ServerFalso;

import com.google.gson.Gson;
import mx.uaemex.fi.basta.modelo.DatosEnvio;
import mx.uaemex.fi.basta.modelo.RespuestaServidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBasta {
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        new ServidorBasta().iniciarServidor();
    }

    private void iniciarServidor() {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor Basta iniciado. Esperando conexiones...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress().getHostAddress());

                // Manejar la conexión con el cliente en un hilo separado
                Thread hiloCliente = new Thread(() -> manejarConexionCliente(socketCliente));
                hiloCliente.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void manejarConexionCliente(Socket socketCliente) {
        try (
                BufferedReader lectorEntrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter escritorSalida = new PrintWriter(socketCliente.getOutputStream(), true)
        ) {
            // Leer el nombre de usuario del cliente
            String nombreUsuario = lectorEntrada.readLine();
            System.out.println("Nombre de usuario recibido: " + nombreUsuario);

            // Procesar el nombre de usuario y enviar una respuesta real al cliente
            enviarRespuestaAlCliente(escritorSalida, "LISTO", "A", 1, '0');

            // Esperar y leer las respuestas del cliente
            String respuestasJson = lectorEntrada.readLine();
            System.out.println("Respuestas recibidas del cliente: " + respuestasJson);

            // Deserializar las respuestas
            DatosEnvio.Respuestas respuestas = deserializarRespuestas(respuestasJson);

            // Simular determinar si las respuestas son correctas
            // Aquí simplemente asignamos un puntaje aleatorio
            int puntaje = (int) (Math.random() * 100);

            // Enviar el puntaje real al cliente
            enviarRespuestaAlCliente(escritorSalida, "PUNTAJE", "", 0, puntaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarRespuestaAlCliente(PrintWriter escritorSalida, String estado, String letra, int numeroRonda, int puntaje) {
        RespuestaServidor respuestaServidor = new RespuestaServidor();
        respuestaServidor.setEstado(estado);
        respuestaServidor.setLetra(letra);
        respuestaServidor.setNumeroRonda(numeroRonda);
        respuestaServidor.setPuntaje(puntaje);

        String respuestaJson = respuestaServidor.toJson();
        escritorSalida.println(respuestaJson);
    }

    private DatosEnvio.Respuestas deserializarRespuestas(String respuestasJson) {
        Gson gson = new Gson();
        return gson.fromJson(respuestasJson, DatosEnvio.Respuestas.class);
    }
}
