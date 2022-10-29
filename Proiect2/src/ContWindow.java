import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Proiect2.*;
public class ContWindow {
    private static ContBancar cont;
    private static JFrame frame = new JFrame();
    private JPanel panelCont;
    private JButton btnExit;
    private JLabel lblTitlu;
    private JLabel lblSold;
    private JLabel lblNume;
    private JButton btnDepunere;
    private JButton btnRetragere;
    private JButton btnName;
    private JLabel lblEditName;
    private JLabel lblRetragere;
    private JLabel lblDepunere;
    private JTextField txtNume;
    private JTextField txtRetragere;
    private JTextField txtDepunere;
    private JButton btnRefresh;
    private JPanel panelContInterface;
    private JButton btnLogOut;

    public void refreshName() {
        lblNume.setText("Salut " + cont.getNume());
    }

    public void refreshSold() {
        String sold = "Sold: "+cont.getSold()+" euro";
        lblSold.setText(sold);
    }

    public ContWindow() {
        refreshName();
        refreshSold();

        btnName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtNume.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti un nume nou!");
                else {
                    String text = txtNume.getText();
                    cont.setName(text);
                    refreshName();
                    txtNume.setText("");
                }
            }
        });

        btnRetragere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtRetragere.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti o suma pentru retragere!");
                else {
                    int bani = Integer.parseInt(txtRetragere.getText());
                    cont.retragereNumerar(bani);
                    refreshSold();
                    txtRetragere.setText("");
                }
            }
        });

        btnDepunere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtDepunere.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduceti o suma pentru depunere!");
                else {
                    int bani = Integer.parseInt(txtDepunere.getText());
                    cont.depunereNumerar(bani);
                    refreshSold();
                    txtDepunere.setText("");
                }
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
                refreshSold();
                refreshName();
            }
        });
    }

    public static void open(ContBancar c) {
        cont = c;

        frame.setContentPane(new ContWindow().panelCont);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(800, 400));
        frame.setMinimumSize(new Dimension(800, 400));

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
