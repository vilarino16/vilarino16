package gui;

import javax.swing.*;
import java.awt.event.*;
import aplicacion.*;

public class VPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton Host;
    private JButton Cliente;
    private JLabel Texto;
    private Usuario usuario;

    public VPrincipal(Usuario u) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(Host);
        this.usuario=u;

        Host.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                servidor();
            }
        });

        Cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cliente();
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

    private void servidor() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void cliente() {
        // add your code here if necessary
        dispose();
    }

}
