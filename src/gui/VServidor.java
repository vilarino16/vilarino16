package gui;

import javax.swing.*;
import java.awt.event.*;
import aplicacion.*;

import java.io.IOException;
import java.net.*;

public class VServidor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField Puerto;
    private JLabel puertoLabel;

    FachadaAplicacion fa;
    Usuario u;
    public VServidor(Usuario usuario) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        u=usuario;

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
        String ip = IPLocal();
        if(!ip.equals("Fallo")){
            fa.crearPartida(u, Puerto.getText(), IPLocal());
            try {
                // Creamos un socket de servidor en el puerto especificado
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Puerto.getText()));

            } catch (IOException e) {
                e.printStackTrace();
            }
            } else {
            fa.muestraExcepcion("No se pudo obtener la IP Local");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private String IPLocal(){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Fallo";
    }

}
