package com.agu1406.clasesjavaswing.ej1;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class DialogoSecundario extends JDialog {

    public DialogoSecundario(JFrame owner) {
        super(owner, "Diálogo", true);
        setSize(300, 150);
        setLocationRelativeTo(owner);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(botonVolver, BorderLayout.CENTER);
        setContentPane(panel);
    }
}


