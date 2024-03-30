import javax.swing.*;
import java.awt.event.*;

public class VAviso extends JDialog {
    private JPanel contentPane;
    private JLabel textExcepcion;

    public VAviso(String txtExcepcion) {
        setContentPane(contentPane);
        setModal(true);
        contentPane.setSize(600,600);
        textExcepcion.setText(txtExcepcion);

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

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
