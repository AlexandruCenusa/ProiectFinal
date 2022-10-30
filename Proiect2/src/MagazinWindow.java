import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Proiect2.*;
public class MagazinWindow {
    private static ContBancar cont;
    private static ArrayList<Auto> masini;
    private static ArrayList<Auto> garaj;
    private static JFrame frame = new JFrame();
    private JPanel panelMagazin;
    private JButton btnExit;
    private JLabel lblTitlu;
    private JButton btnCumparare;
    private JButton btnManage;
    private JList listMasini;
    private JButton btnRefresh;

    public void refreshList() {
        listMasini.setListData(masini.toArray());
    }
    public MagazinWindow() {
        refreshList();

        btnCumparare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = -1;
                index = listMasini.getSelectedIndex();
                if (index == -1)
                    JOptionPane.showMessageDialog(null, "Selectati o masina!");
                else if (cont.retragereNumerarC(masini.get(index).getPret())) {
                    cont.retragereNumerar(masini.get(index).getPret());
                    garaj.add(masini.get(index));
                    masini.remove(index);
                    refreshList();
                    JOptionPane.showMessageDialog(null, "Tranzactie efectuata!");
                } else
                    JOptionPane.showMessageDialog(null, "Fonduri insuficiente!");
            }
        });

        btnManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageWindow.open(masini);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshList();
            }
        });
    }


    public static void open(ArrayList<Auto> m, ArrayList<Auto> g) {
        masini = m;
        garaj = g;
        frame.setContentPane(new MagazinWindow().panelMagazin);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(900, 700));
        frame.setMinimumSize(new Dimension(900, 700));

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
