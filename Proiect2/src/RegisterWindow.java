import Proiect3.*;
import myLogging.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterWindow {

    private static JFrame frame = new JFrame("Autoshop Saga 1.0");
    private JPanel registerPanel;
    private JPanel registerInterfacePanel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JLabel lblConfirmPassword;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JButton btnRegister;
    private JButton btnExit;
    private JLabel registerIcon;

    public RegisterWindow() {

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnRegister.getText()+"' din fereastra: RegisterWindow";
                Logger.setLog(str);

                String nume = txtUsername.getText();
                String parola1 = new String(txtPassword.getPassword());
                String parola2 = new String(txtConfirmPassword.getPassword());

                DataBase.setConnection();
                if(txtUsername.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti un nume!");
                else if(DataBase.selectFromDB(nume, "nume") != null)
                        JOptionPane.showMessageDialog(null, "Numele introdus apartine deja unui cont!");
                    else if(!(parola1.equals(parola2)) && !(parola1.equals(null)))
                            JOptionPane.showMessageDialog(null, "Parolele nu coincid!");
                        else
                            try {
                                DataBase.insertDB(nume, parola1);
                                JOptionPane.showMessageDialog(null, "Utilizatorul a fost inregistrat cu succes!");
                                frame.dispose();
                                LogInWindow.open();
                            } catch (SQLException ex) {
                                System.out.println("Error Insert to DB");
                            }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnExit.getText()+"' din fereastra: RegisterWindow";
                Logger.setLog(str);

                frame.dispose();
            }
        });
    }

    public static void open() {
        frame.setContentPane(new RegisterWindow().registerPanel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(500,400));
        frame.setMinimumSize(new Dimension(500,400));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        frame.setLocation(x, y-100);

        frame.pack();
        frame.setVisible(true);
    }
}
