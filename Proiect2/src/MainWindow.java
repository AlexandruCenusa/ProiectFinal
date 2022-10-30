import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import Proiect2.*;

public class MainWindow {
    private JPanel panelMeniu;
    private JButton btnContBancar;
    private JButton btnMagazin;
    private JButton btnGaraj;
    private JButton btnExit;
    private JPanel panelMeniuInterfata;

    public MainWindow() {
        Scanner scan = new Scanner(System.in);

        DataBase.setConnection();



        //Instantiere clasa Auto
        ArrayList<Auto> masini = new ArrayList<Auto>();
        ArrayList<Auto> garaj = new ArrayList<Auto>();

        btnContBancar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LoginState.getState() == false)
                    LogInWindow.open();
                else
                    ContWindow.open();
            }
        });

        btnMagazin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MagazinWindow.open(masini, garaj);
            }
        });

        btnGaraj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GarajWindow.open(garaj);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
