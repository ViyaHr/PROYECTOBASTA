package mx.uaemex.fi.basta.control;

import com.google.gson.Gson;
import mx.uaemex.fi.basta.vista.VentanaJuego;
import mx.uaemex.fi.basta.modelo.RespuestaServidor;
import com.google.gson.Gson;

public class ControladorVentanaJuego {
    private VentanaJuego ventanaJuego;

    public ControladorVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    // Método para procesar la respuesta del servidor
    public void procesarRespuestaServidor(String respuestaJson) {
        Gson gson = new Gson();
        RespuestaServidor respuestaServidor = gson.fromJson(respuestaJson, RespuestaServidor.class);

        // Procesar la respuesta del servidor según el estado
        switch (respuestaServidor.getEstado()) {
            case "INICIAL":
                // Configurar la ventana para el estado inicial
                ventanaJuego.bloquearCamposRespuestas();
                break;
            case "LISTO":
                // Configurar la ventana para el estado listo
                ventanaJuego.desbloquearCamposRespuestas(respuestaServidor.getLetra(), respuestaServidor.getNumeroRonda());
                break;
            // Otros casos según sea necesario
        }
    }

    // Método para procesar la respuesta del servidor después de enviar respuestas
    public void procesarRespuestaServidorDespuesEnvio(String respuestaJson) {
        Gson gson = new Gson();
        RespuestaServidor respuestaServidor = gson.fromJson(respuestaJson, RespuestaServidor.class);

        // Procesar la respuesta del servidor después de enviar respuestas
        // (puede incluir la actualización del puntaje, etc.)
        int puntaje = respuestaServidor.getPuntaje();
        ventanaJuego.actualizarPuntaje(puntaje);
        ventanaJuego.bloquearCamposRespuestas();
    }
}


