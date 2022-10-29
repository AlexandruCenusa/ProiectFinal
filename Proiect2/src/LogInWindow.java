import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.concurrent.ExecutionException;

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
                char[] parola = txtPassword.getPassword();

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "umfst2022");
                    Statement stm = con.createStatement();

                    //String sql = "insert into cont values ('Stefan', 'slow4run', 10000)";

                    //stm.executeUpdate(sql);

                    ResultSet res = stm.executeQuery("select * from cont");

                    if(res.next())
                        System.out.println(res.getString("nume") + " " + res.getString("parola"));

                } catch (SQLException ex) {
                    System.out.println("ERROR");
                }







            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
