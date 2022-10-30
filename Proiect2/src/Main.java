import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.concurrent.ExecutionException;
import Proiect2.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "umfst2022");
           // Statement stm = con.createStatement();


            String nume = "Stefan";
            String parola = "umfst";

            DataBase.setConnection();
            //System.out.println(DataBase.selectLogin(nume, parola));

            //ResultSet res = stm.executeQuery("select * from cont");

           // while(res.next())
             //   System.out.println(res.getString("nume") + " " + res.getString("parola"));

            PreparedStatement stm = con.prepareStatement("UPDATE cont SET sold = 100 WHERE nume = 'Stefan';");
            stm.executeUpdate();

        }catch (Exception e) {

        }
    }
}
