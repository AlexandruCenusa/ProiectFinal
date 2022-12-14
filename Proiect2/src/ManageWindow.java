import Proiect3.*;
import myLogging.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageWindow {
    private static ArrayList<Auto> masini;
    private static JFrame frame = new JFrame("Manage");
    private JPanel panelManager;
    private JButton btnExit;
    private JButton btnSubmit;
    private JLabel lblTitlu;
    private JTextField txtKm;
    private JLabel lblMarca;
    private JLabel lblModel;
    private JLabel lblKm;
    private JLabel lblPret;
    private JList listMasini;
    private JTextField txtMarca;
    private JTextField txtModel;
    private JTextField txtPret;
    private JButton btnFerVechi;
    private JButton btnWipe;

    public void refreshList() {
        listMasini.setListData(masini.toArray());
    }
    public ManageWindow() {
        refreshList();



        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnSubmit.getText()+"' din fereastra: 'ManageWindow'";
                Logger.setLog(str);

                try{
                    if(txtMarca.getText().isEmpty() || txtModel.getText().isEmpty() || txtKm.getText().isEmpty() || txtPret.getText().isEmpty())
                        JOptionPane.showMessageDialog(null, "Completati toate campurile!");
                    else {
                        String marca = txtMarca.getText();
                        String model = txtModel.getText();
                        int km = Integer.parseInt(txtKm.getText());
                        double pret = Double.parseDouble(txtPret.getText());

                        if(masini.size() <= Auto.NR_MAX) {
                            masini.add(new Auto(marca, model, km, pret));
                            refreshList();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Nu exista spatiu suficient!");

                        txtMarca.setText("");
                        txtModel.setText("");
                        txtKm.setText("");
                        txtPret.setText("");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Eroare. Ati introdus caractere care nu sunt cifre.");
                    System.out.println("Eorare. Ati introdus (o) litera/litere intr-un spatiu care accepta doar cifre.");
                    Logger.setLog("Eroare. Datele introduse sunt incorecte: acest camp necesita caractere cifra");
                }


            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnExit.getText()+"' din fereastra: 'ManageWindow'";
                Logger.setLog(str);

                frame.dispose();
            }
        });
        btnFerVechi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnFerVechi.getText()+"' din fereastra: 'ManageWindow'";
                Logger.setLog(str);

                int index = -1;
                index = listMasini.getSelectedIndex();
                if(index == -1)
                    JOptionPane.showMessageDialog(null, "Selectati o masina!");
                else {
                    //masini.remove(index);
                    refreshList();
                }
            }
        });
        btnWipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataBase.wipeDB();
                    JOptionPane.showMessageDialog(null, "Wipe cu succes!");
                }
                catch(SQLException ex) {
                    Logger.setLog("Error db wipe");
                    JOptionPane.showMessageDialog(null, "Nu s-a putut da wipe");
            }
            }
        });
    }


    public static void open(ArrayList<Auto> m) {
        masini = m;
        frame.setContentPane(new ManageWindow().panelManager);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(500, 700));
        frame.setMinimumSize(new Dimension(500, 700));

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
