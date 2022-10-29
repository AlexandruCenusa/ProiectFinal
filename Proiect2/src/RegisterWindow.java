import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void open() {
        frame.setContentPane(new RegisterWindow().registerPanel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(500,400));
        frame.setMinimumSize(new Dimension(500,400));

        frame.pack();
        frame.setVisible(true);
    }
}
