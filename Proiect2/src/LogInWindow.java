import Proiect2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInWindow {

    private static JFrame frame = new JFrame("AutoShop Saga 1.0");

    private JPanel logInPanel;
    private JPanel logInPanelInterface;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogIn;
    private JButton btnExit;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel LogInIcon;
    private JButton btnRegister;
    private JLabel lblRegister;

    public LogInWindow(){


        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = txtUsername.getText();
                char[] parolaC = txtPassword.getPassword();

                String parola = new String(parolaC);

                DataBase.setConnection();
                String result = DataBase.selectLogin(nume, parola);


                if(result == null)
                    JOptionPane.showMessageDialog(null, "Datele introduse nu sunt corecte!");
                else {
                    LoginState.setState(true);
                    LoginState.setNume(nume);
                    frame.dispose();
                    ContWindow.open();
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                RegisterWindow.open();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void open() {
        frame.setContentPane(new LogInWindow().logInPanel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(600,300));
        frame.setMinimumSize(new Dimension(600,300));

        frame.pack();
        frame.setVisible(true);
    }

}
