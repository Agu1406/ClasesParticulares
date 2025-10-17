package com.agu1406.clasesjavaswing.ej2;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class PantallaSecundaria extends JDialog {
    private final JTextField campoNombre;

    public PantallaSecundaria(PantallaPrincipal owner) {
        super(owner, "Pantalla Secundaria", true);
        setSize(400, 160);
        setLocationRelativeTo(owner);

        JLabel etiqueta = new JLabel("Introduzca su nombre:");
        campoNombre = new JTextField(20);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> {
            owner.actualizarSaludo(campoNombre.getText());
            dispose();
        });

        JPanel centro = new JPanel();
        centro.add(etiqueta);
        centro.add(campoNombre);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(centro, BorderLayout.CENTER);
        panel.add(botonVolver, BorderLayout.SOUTH);
        setContentPane(panel);
    }
}


