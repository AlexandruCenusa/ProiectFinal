import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "umfst2022");
            Statement stm = con.createStatement();

            //String sql = "insert into cont values ('Stefan', 'slow4run', 10000)";

            //stm.executeUpdate(sql);


            ResultSet res = stm.executeQuery("select * from cont");

            while(res.next())
                System.out.println(res.getString("nume") + " " + res.getString("parola"));


        }catch (Exception e) {

        }
    }
}
