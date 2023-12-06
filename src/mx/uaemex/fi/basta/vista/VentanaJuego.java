package mx.uaemex.fi.basta.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJuego extends JFrame {
    private JLabel letraLabel;
    private JLabel rondaLabel;
    private JTextField nombreField;
    private JTextField colorField;
    private JTextField florFrutoField;
    private JTextField animalField;
    private JTextField paisField;
    private JLabel puntajeLabel;

    public VentanaJuego() {
        // Configuración básica de la ventana
        setTitle("Juego de Basta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes
        letraLabel = new JLabel("Letra: ");
        rondaLabel = new JLabel("Número de Ronda: ");
        nombreField = new JTextField(20);
        colorField = new JTextField(20);
        florFrutoField = new JTextField(20);
        animalField = new JTextField(20);
        paisField = new JTextField(20);
        puntajeLabel = new JLabel("Puntaje: 0");

        JButton enviarRespuestasButton = new JButton("Enviar Respuestas");

        // Configurar el diseño de la ventana
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        // Agregar componentes al panel
        panel.add(letraLabel);
        panel.add(rondaLabel);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Flor o Fruto:"));
        panel.add(florFrutoField);
        panel.add(new JLabel("Animal:"));
        panel.add(animalField);
        panel.add(new JLabel("Pais:"));
        panel.add(paisField);
        panel.add(puntajeLabel);
        panel.add(enviarRespuestasButton);

        // Agregar el panel a la ventana
        add(panel, BorderLayout.CENTER);

        // Configurar el ActionListener para el botón
        enviarRespuestasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulación de envío de respuestas al servidor
                mostrarRespuestasEnviadas();
            }
        });
    }
    public void bloquearCamposRespuestas() {
        nombreField.setEditable(false);
        colorField.setEditable(false);
        florFrutoField.setEditable(false);
        animalField.setEditable(false);
        paisField.setEditable(false);
    }

    // Método para desbloquear los campos de respuestas
    public void desbloquearCamposRespuestas(String letra, int numeroRonda) {
        letraLabel.setText("Letra: " + letra);
        rondaLabel.setText("Número de Ronda: " + numeroRonda);

        nombreField.setEditable(true);
        colorField.setEditable(true);
        florFrutoField.setEditable(true);
        animalField.setEditable(true);
        paisField.setEditable(true);
    }

    // Método para actualizar el puntaje
    public void actualizarPuntaje(int puntaje) {
        puntajeLabel.setText("Puntaje: " + puntaje);
    }


    private void mostrarRespuestasEnviadas() {
        String letra = letraLabel.getText().substring(7);
        String ronda = rondaLabel.getText().substring(17);
        String nombre = nombreField.getText();
        String color = colorField.getText();
        String florFruto = florFrutoField.getText();
        String animal = animalField.getText();
        String pais = paisField.getText();

        JOptionPane.showMessageDialog(null, "Respuestas Enviadas:\n" +
                "Letra: " + letra + "\n" +
                "Número de Ronda: " + ronda + "\n" +
                "Nombre: " + nombre + "\n" +
                "Color: " + color + "\n" +
                "Flor o Fruto: " + florFruto + "\n" +
                "Animal: " + animal + "\n" +
                "Pais: " + pais);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }
}

