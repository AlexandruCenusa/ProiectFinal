import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import Proiect3.*;
import myLogging.*;

public class MainWindow {
    private JPanel panelMeniu;
    private JButton btnContBancar;
    private JButton btnMagazin;
    private JButton btnGaraj;
    private JButton btnExit;
    private JPanel panelMeniuInterfata;

    private static ArrayList<Auto> masini = new ArrayList<Auto>();
    public MainWindow() {
        Scanner scan = new Scanner(System.in);

        btnContBancar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: " + btnContBancar.getText()+" din fereastra: 'MainWindow'";
                Logger.setLog(str);

                if(LoginState.getState() == false)
                    LogInWindow.open();
                else
                    ContWindow.open();
            }
        });

        btnMagazin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnMagazin.getText()+"' din fereastra: 'MainWindow'";
                Logger.setLog(str);

                MagazinWindow.open(masini);
            }
        });

        btnGaraj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnGaraj.getText()+"' din fereastra: 'MainWindow'";
                Logger.setLog(str);

                if(LoginState.getState() == true)
                    GarajWindow.open();
                else {
                    int result = JOptionPane.showConfirmDialog(null, "Trebuie sa te loghezi pentru a cumpara! Doresti sa te loghezi?");
                    if(result == JOptionPane.YES_OPTION)
                        LogInWindow.open();
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnExit.getText()+"' din fereastra: 'MainWindow'";
                Logger.setLog(str);

                System.exit(-1);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Proiect 2");
        frame.setContentPane(new MainWindow().panelMeniu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(600, 600));
        frame.setMinimumSize(new Dimension(600, 600));

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
