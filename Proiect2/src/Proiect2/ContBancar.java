package Proiect2;

import javax.xml.crypto.Data;

public class ContBancar {

    private static final double COMISION_RETRAGERE = 0.5;

    public ContBancar() {

    }

    public static void depunereNumerar(double sold) {
        double soldCurent = Double.parseDouble(DataBase.selectFromDB(LoginState.getNume(), "sold"));
        soldCurent += sold;
        DataBase.updateSoldDB(LoginState.getNume(), soldCurent);
    }

    public static boolean retragereNumerarC(double sold) {
        double soldCurent = Double.parseDouble(DataBase.selectFromDB(LoginState.getNume(), "sold"));
        if(soldCurent >= sold+COMISION_RETRAGERE)
            return true;
        return false;
    }
    public static void retragereNumerar(double sold) {
        double soldCurent = Double.parseDouble(DataBase.selectFromDB(LoginState.getNume(), "sold"));
        if(retragereNumerarC(sold) == true) {
            soldCurent -= sold + COMISION_RETRAGERE;
            DataBase.updateSoldDB(LoginState.getNume(), soldCurent);
        }
    }
}
