package Proiect2;
import java.sql.*;

public class DataBase {
    private static Connection con;

    public static void setConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect", "root", "umfst2022");
        }catch(SQLException ex) {
            System.out.println("Connection error");
        }
    }

    public static String selectLogin(String nume, String parola) {
        setConnection();
        String result = null;
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM cont WHERE nume like '"+nume+"' AND parola like '"+parola+"';");
            ResultSet res = statement.executeQuery();

            if(res.next())
                result = res.getString("nume");

        }catch (SQLException ex) {
            System.out.println("Error Select From DB");
        }
        return result;
    }

    public static String selectFromDB(String nume, String camp) {
        setConnection();
        String result = null;
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM cont WHERE nume like '"+nume+"';");
            ResultSet res = statement.executeQuery();

            if(res.next())
                result = res.getString(camp);

        }catch (SQLException ex) {
            System.out.println("Error Select From DB");
        }
        return result;
    }

    public static void insertDB(String nume, String parola) throws SQLException {
        setConnection();
        Statement stm = con.createStatement();
        String sql = "insert into cont values ('"+nume+"', '"+parola+"', 0);";
        stm.executeUpdate(sql);
    }

    public static void updateSoldDB(String nume, double sold) {
        setConnection();
        try {
            PreparedStatement stm = con.prepareStatement("UPDATE cont SET sold =" + sold + " WHERE nume LIKE '" + nume + "';");
            stm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error update");
        }
    }
}
