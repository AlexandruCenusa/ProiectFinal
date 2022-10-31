package Proiect3;
import myLogging.Logger;

import java.sql.*;
import java.util.ArrayList;

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

    public static void insertIntoGaraj(String proprietar, String marca, String model, int km) {
        try {
            setConnection();
            Statement stm = con.createStatement();
            String sql = "insert into garaj (proprietar, marca, model, km) values ('" + proprietar + "', '" + marca + "', '" + model + "', '" + km+"');";
            stm.executeUpdate(sql);
        }catch(SQLException ex) {
            System.out.println("Error insert GARAJ");
            Logger.setLog("Error insert into database");
        }
    }

    public static void selectAllFromGaraj(String proprietar, ArrayList<Auto> garaj) {
        try {
            setConnection();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("select * from garaj where proprietar like '" + proprietar + "';");

            while(res.next()) {
                String marca = res.getString("marca");
                String model = res.getString("model");
                int km = Integer.parseInt(res.getString("km"));
                garaj.add(new Auto(marca,model,km));
            }


        }catch(SQLException ex) {
            System.out.println("Error select GARAJ");
            Logger.setLog("Error select into database");
        }
    }

    public static double getAdminSold() {
        setConnection();
        double result = 0;
        try {
            PreparedStatement statement = con.prepareStatement("SELECT sold FROM cont WHERE nume like 'admin';");
            ResultSet res = statement.executeQuery();

            if(res.next())
                result = Double.parseDouble(res.getString("sold"));

        }catch (SQLException ex) {
            System.out.println("Error Select From DB");
        }
        return result;
    }
}
