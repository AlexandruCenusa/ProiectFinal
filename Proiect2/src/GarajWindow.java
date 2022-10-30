import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Proiect2.*;
public class GarajWindow {
    private static JFrame frame = new JFrame();
    private JPanel panelGaraj;
    private JPanel panelGarajInterface;
    private JButton btnExit;
    private JList listGaraj;
    private JButton btnRefresh;

    public void refreshList() {
       // listGaraj.setListData(garaj.toArray());
    }
    public GarajWindow() {
        refreshList();
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

    public static void open() {

        frame.setContentPane(new GarajWindow().panelGarajInterface);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(400, 500));
        frame.setMinimumSize(new Dimension(400, 500));

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
