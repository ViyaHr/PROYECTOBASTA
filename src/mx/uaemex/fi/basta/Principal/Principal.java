package mx.uaemex.fi.basta.Principal;

import mx.uaemex.fi.basta.modelo.ClienteBasta;

import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniciarAplicacion();
            }
        });
    }

    private static void iniciarAplicacion() {
        // Iniciar el cliente
        ClienteBasta clienteBasta = new ClienteBasta();
        clienteBasta.iniciarCliente();
    }
}

