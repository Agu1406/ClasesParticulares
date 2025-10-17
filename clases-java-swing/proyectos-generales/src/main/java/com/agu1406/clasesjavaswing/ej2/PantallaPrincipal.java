package com.agu1406.clasesjavaswing.ej2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

public class PantallaPrincipal extends JFrame {
    private final JLabel etiquetaSaludo;

    public PantallaPrincipal() {
        super("Ejercicio 2 - Paso de datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);

        etiquetaSaludo = new JLabel("Bienvenido a mi primera aplicación", JLabel.CENTER);

        JButton botonSiguiente = new JButton("Siguiente");
        botonSiguiente.addActionListener(e -> abrirSecundaria());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(etiquetaSaludo, BorderLayout.CENTER);
        panel.add(botonSiguiente, BorderLayout.SOUTH);
        setContentPane(panel);
    }

    private void abrirSecundaria() {
        PantallaSecundaria dialog = new PantallaSecundaria(this);
        dialog.setVisible(true);
    }

    public void actualizarSaludo(String nombre) {
        String texto = "Bienvenido a mi primera aplicación" + (nombre == null || nombre.isBlank() ? "" : " " + nombre);
        etiquetaSaludo.setText(texto);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }
}


