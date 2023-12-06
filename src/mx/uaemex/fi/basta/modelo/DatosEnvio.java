package mx.uaemex.fi.basta.modelo;

import com.google.gson.Gson;

public class DatosEnvio {
    private String nombreUsuario;
    private Respuestas respuestas;

    // Constructores, getters y setters...

    // Método para convertir esta clase a una cadena JSON (solo el nombre de usuario)
    public String toJsonNombreUsuario() {
        Gson gson = new Gson();
        return gson.toJson(new NombreUsuario(nombreUsuario));
    }

    // Método para convertir esta clase a una cadena JSON (solo las respuestas)
    public String toJsonRespuestas() {
        Gson gson = new Gson();
        return gson.toJson(respuestas);
    }

    // Clase interna para representar solo el nombre de usuario
    private static class NombreUsuario {
        private final String nombreUsuario;

        public NombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    // Clase interna para representar las respuestas
    public static class Respuestas {
        private String respuestaNombre;
        private String respuestaColor;
        private String respuestaFlorFruto;
        private String respuestaAnimal;
        private String respuestaPais;

        // Constructores, getters y setters...
    }
}

