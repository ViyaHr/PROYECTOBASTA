package mx.uaemex.fi.basta.vista;

import mx.uaemex.fi.basta.control.ControladorVentanaInicial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicial extends JFrame {
    private JTextField usernameField;
    private ControladorVentanaInicial controlador;

    public VentanaInicial() {
        // Configuración básica de la ventana
        setTitle("Registro de Usuario");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel label = new JLabel("Ingresa tu nombre aquí:");
        usernameField = new JTextField(20);
        JButton enviarButton = new JButton("Enviar");

        // Configurar el diseño de la ventana
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Agregar componentes al panel
        panel.add(label);
        panel.add(usernameField);
        panel.add(enviarButton);

        // Agregar el panel a la ventana
        add(panel, BorderLayout.CENTER);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = usernameField.getText().trim();

                // Validar que se haya ingresado un nombre de usuario
                if (!nombreUsuario.isEmpty()) {
                    // Enviar el nombre de usuario al controlador
                    controlador.enviarNombre(nombreUsuario);
                } else {
                    // Mostrar mensaje de error si no se ingresó un nombre de usuario
                    JOptionPane.showMessageDialog(VentanaInicial.this, "Ingresa un nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método para establecer el controlador
    public void setControlador(ControladorVentanaInicial controlador) {
        this.controlador = controlador;
    }
    }


