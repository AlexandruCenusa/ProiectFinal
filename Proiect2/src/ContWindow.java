import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Proiect3.*;
import myLogging.*;
public class ContWindow {
    private static JFrame frame = new JFrame();
    private JPanel panelCont;
    private JButton btnExit;
    private JLabel lblTitlu;
    private JLabel lblSold;
    private JLabel lblNume;
    private JButton btnDepunere;
    private JButton btnRetragere;
    private JButton btnName;
    private JLabel lblRetragere;
    private JLabel lblDepunere;
    private JTextField txtNume;
    private JTextField txtRetragere;
    private JTextField txtDepunere;
    private JButton btnRefresh;
    private JPanel panelContInterface;
    private JButton btnLogOut;

    public void refreshName() {
        DataBase.setConnection();
        String result = LoginState.getNume();
        lblNume.setText("Salut " + result);
    }

    public void refreshSold() {
        String sold = DataBase.selectFromDB(LoginState.getNume(), "sold");
        lblSold.setText(sold);
    }

    public ContWindow() {
        refreshName();
        refreshSold();

        btnRetragere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnRetragere.getText()+"' din fereastra: 'ContWindow'";
                Logger.setLog(str);

                try{
                    if(txtRetragere.getText().isEmpty())
                        JOptionPane.showMessageDialog(null, "Introduceti o suma pentru retragere!");
                    else {
                        double bani = Double.parseDouble(txtRetragere.getText());
                        ContBancar.retragereNumerar(bani);
                        refreshSold();
                        txtRetragere.setText("");
                    }
                }
                catch(NumberFormatException ex) //exceptie neverificata,dar folosita pentru a trata cazul in care s-au introdus caractere litera in loc de cifre
                {
                    JOptionPane.showMessageDialog(null,"Eroare. Ati introdus caractere care nu sunt cifre.");
                }

            }
        });

        btnDepunere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnDepunere.getText()+"' din fereastra: 'ContWindow'";
                Logger.setLog(str);

                try{
                    if(txtDepunere.getText().isEmpty())
                        JOptionPane.showMessageDialog(null, "Introduceti o suma pentru depunere!");
                    else {
                        double bani = Double.parseDouble(txtDepunere.getText());
                        ContBancar.depunereNumerar(bani);
                        refreshSold();
                        txtDepunere.setText("");
                    }
                }
                catch(NumberFormatException ex) //exceptie neverificata,dar folosita pentru a trata cazul in care s-au introdus caractere litera in loc de cifre
                {
                    JOptionPane.showMessageDialog(null,"Eroare. Ati introdus caractere care nu sunt cifre.");
                }

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnExit.getText()+"' din fereastra: 'ContWindow'";
                Logger.setLog(str);

                frame.dispose();
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnRefresh.getText()+"' din fereastra: 'ContWindow'";
                Logger.setLog(str);

                refreshSold();
                refreshName();
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "S-a apasat butonul: '" + btnLogOut.getText()+"' din fereastra: 'ContWindow'";
                Logger.setLog(str);

                LoginState.setState(false);
                LoginState.setNume(null);
                frame.dispose();
            }
        });
    }

    public static void open() {
        frame.setContentPane(new ContWindow().panelCont);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(800, 500));
        frame.setMinimumSize(new Dimension(800, 500));

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
