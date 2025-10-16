package com.agu1406.clasesjavaswing.ej1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        super("Ejercicio 1 - JFrame y JDialog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JButton botonAbrirDialogo = new JButton("Ir a diálogo");
        botonAbrirDialogo.addActionListener(e -> abrirDialogo());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(botonAbrirDialogo, BorderLayout.CENTER);
        setContentPane(panel);
    }

    private void abrirDialogo() {
        DialogoSecundario dialogo = new DialogoSecundario(this);
        dialogo.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}


