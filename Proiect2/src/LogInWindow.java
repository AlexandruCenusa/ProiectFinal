import javax.swing.*;
import java.awt.*;

public class LogInWindow {

    private static JFrame frame = new JFrame("AutoShop Saga 1.0");

    private JPanel logInPanel;
    private JPanel logInPanelInterface;
    private JTextField usernameTxtField;
    private JPasswordField passwordFieldLogInUser;
    private JButton btnLogIn;
    private JButton btnExit;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel LogInIcon;
    private JButton btnRegister;
    private JLabel lblRegister;

    public LogInWindow(){

    }

    public static void main(String[] args) {

        frame.setContentPane(new LogInWindow().logInPanel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(600,300));
        frame.setMinimumSize(new Dimension(600,300));

        frame.pack();
        frame.setVisible(true);
    }

}
