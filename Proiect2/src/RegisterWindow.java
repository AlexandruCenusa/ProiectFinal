import javax.swing.*;
import java.awt.*;

public class RegisterWindow {

    private static JFrame frame = new JFrame("Autoshop Saga 1.0");
    private JPanel registerPanel;
    private JPanel registerInterfacePanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordFieldPasswordConfirm;
    private JLabel lblConfirmPassword;
    private JLabel lblPassword;
    private JLabel lblUsername;
    private JButton btnRegister;
    private JButton btnExit;
    private JLabel registerIcon;

    public static void main(String[] args) {

        frame.setContentPane(new RegisterWindow().registerPanel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(500,400));
        frame.setMinimumSize(new Dimension(500,400));

        frame.pack();
        frame.setVisible(true);
    }
}
