import CustomException.LogInFailureException;
import Proiect3.*;
import myLogging.*;

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

    private void logInOperation() throws LogInFailureException
    {
        String str = "S-a apasat butonul: '" + btnLogIn.getText()+"' din fereastra: LogInWindow";
        Logger.setLog(str);

        String nume = txtUsername.getText();
        char[] parolaC = txtPassword.getPassword();

        String parola = new String(parolaC);

        DataBase.setConnection();
        String result = DataBase.selectLogin(nume, parola);

        if(nume.isEmpty() || parola.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "User-ul si parola introdusa sunt nule. Inceracati din nou.");
            throw new LogInFailureException("wrong");
        }

        if(result == null) {
            JOptionPane.showMessageDialog(null, "User sau parola incorecta! ");
        }
        else {
            LoginState.setState(true);
            LoginState.setNume(nume);
            frame.dispose();
            ContWindow.open();
        }
    }
    public LogInWindow(){


        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        logInOperation();
                }catch(LogInFailureException ex){
                    Logger.setLog("Error. Failed to log in: Empty parameters.");
                    System.out.println("Eorare. Datele introduse sunt nule.");
                }

            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnRegister.getText()+"' din fereastra: LogInWindow";
                Logger.setLog(str);

                frame.dispose();
                RegisterWindow.open();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnExit.getText()+"' din fereastra: LogInWindow";
                Logger.setLog(str);

                frame.dispose();
            }
        });
    }

    public static void open() {
        frame.setContentPane(new LogInWindow().logInPanel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(600,300));
        frame.setMinimumSize(new Dimension(600,300));

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
