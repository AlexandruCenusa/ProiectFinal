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

        //Numarul maxim de masini pe care le poate stoca AutoHouse-ul

        //Instantiere clasa ContBancar
        ContBancar cont = new ContBancar("Stefan", 6000);

        //Instantiere clasa Auto
        ArrayList<Auto> masini = new ArrayList<Auto>();
        ArrayList<Auto> garaj = new ArrayList<Auto>();

        masini.add(new Auto("Skoda", "Octavia II", 200000, 5500.0));
        masini.add(new Auto("Dacia", "Logan", 360000, 2000.0));
        masini.add(new Auto("Audi", "A4", 180000, 6200.0));
        masini.add(new Auto("BMW", "F10", 120000, 10000.0));
        masini.add(new Auto("Skoda", "Octavia III", 80000, 10000.0));

        btnContBancar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContWindow.open(cont);
            }
        });

        btnMagazin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MagazinWindow.open(masini, garaj, cont);
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
