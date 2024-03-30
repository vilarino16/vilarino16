package gui;

import javax.swing.*;
import java.awt.event.*;
import aplicacion.*;

public class VAutentificacion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField Usuariof;
    private JTextField ContrasenaF;
    private JLabel etiquetaFallo;
    private JLabel Usuario;
    private JLabel Contrasena;
    private Usuario u;

    FachadaAplicacion fa;

    public VAutentificacion(FachadaAplicacion fa) {
        setContentPane(contentPane);
        setModal(true);
        contentPane.setSize(600,600);
        getRootPane().setDefaultButton(buttonOK);
        etiquetaFallo.setVisible(false);
        this.fa=fa;
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        etiquetaFallo.setVisible(false);
        if (fa.comprobarAutentificacion(Usuariof.getText(), ContrasenaF.getText(), u)) {
            this.dispose();
            new VPrincipal(u);
        }
        else etiquetaFallo.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        System.exit(0);
    }


}
