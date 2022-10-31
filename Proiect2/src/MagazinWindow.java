import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Proiect3.*;
import myLogging.*;
public class MagazinWindow {
    private static ContBancar cont;
    private static ArrayList<Auto> masini;
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
                //LOGGING
                String str = "S-a apasat butonul: '" + btnCumparare.getText()+"' din fereastra: MagazinWindow";
                Logger.setLog(str);

                if(LoginState.getState() == true) {
                    int index = -1;
                    index = listMasini.getSelectedIndex();
                    if (index == -1)
                        JOptionPane.showMessageDialog(null, "Selectati o masina!");
                    else if (cont.retragereNumerarC(masini.get(index).getPret())) {
                        double sold = masini.get(index).getPret();
                        cont.retragereNumerar(sold);

                        DataBase.updateSoldDB("admin", sold + DataBase.getAdminSold());

                        //Adaugare masina cumparata in baza de date garaj
                        String marca = masini.get(index).getMarca();
                        String model = masini.get(index).getModel();
                        int km = masini.get(index).getKm();
                        double pret = masini.get(index).getPret();
                        DataBase.insertIntoGaraj(LoginState.getNume(), marca, model, km);

                        masini.remove(index);
                        refreshList();
                        JOptionPane.showMessageDialog(null, "Tranzactie efectuata!");
                    } else
                        JOptionPane.showMessageDialog(null, "Fonduri insuficiente!");
                }
                else {
                    int result = JOptionPane.showConfirmDialog(null, "Trebuie sa te loghezi pentru a cumpara! Doresti sa te loghezi?");
                    if(result == JOptionPane.YES_OPTION){
                        frame.dispose();
                        LogInWindow.open();
                    }
                }
            }
        });

        btnManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnManage.getText()+"' din fereastra: MagazinWindow";
                Logger.setLog(str);

                try {
                    if (!LoginState.getNume().equals("admin"))
                        JOptionPane.showMessageDialog(null, "Acces restrictionat (admin)");
                    else
                        ManageWindow.open(masini);
                }catch(Exception ex) {
                    int result = JOptionPane.showConfirmDialog(null, "Trebuie sa te loghezi pentru a cumpara! Doresti sa te loghezi?");
                    if(result == JOptionPane.YES_OPTION){
                        frame.dispose();
                        LogInWindow.open();
                    }
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnExit.getText()+"' din fereastra: MagazinWindow";
                Logger.setLog(str);

                frame.dispose();
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnRefresh.getText()+"' din fereastra: MagazinWindow";
                Logger.setLog(str);

                refreshList();
            }
        });
    }


    public static void open(ArrayList<Auto> m) {
        masini = m;
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
