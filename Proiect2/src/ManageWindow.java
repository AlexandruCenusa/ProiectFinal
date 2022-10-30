import Proiect2.Auto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManageWindow {
    private static ArrayList<Auto> masini;
    private static JFrame frame = new JFrame();
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

    public void refreshList() {
        listMasini.setListData(masini.toArray());
    }
    public ManageWindow() {
        refreshList();



        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnFerVechi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = -1;
                index = listMasini.getSelectedIndex();
                if(index == -1)
                    JOptionPane.showMessageDialog(null, "Selectati o masina!");
                else {
                    masini.remove(index);
                    refreshList();
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
