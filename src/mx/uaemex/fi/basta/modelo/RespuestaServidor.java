package mx.uaemex.fi.basta.modelo;

import com.google.gson.Gson;

public class RespuestaServidor {
    private String estado;
    private String letra;
    private int numeroRonda;
    private int puntaje;

    // Constructores, getters y setters...

    // Método para convertir esta clase a una cadena JSON
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Getters y setters

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}


