package Proiect2;
public class ContBancar {

    private final double COMISION_RETRAGERE = 0.5;
    private double sold;
    private String nume;

    public ContBancar() {

    }

    public ContBancar(String nume, double sold) {
        this.nume = nume;
        this.sold = sold;
    }

    public void depunereNumerar(double sold) {
        this.sold += sold;
    }

    public boolean retragereNumerarC(double sold) {
        if(this.sold >= sold+COMISION_RETRAGERE)
            return true;
        return false;
    }
    public void retragereNumerar(double sold) {
        if(retragereNumerarC(sold) == true)
            this.sold -= sold+=COMISION_RETRAGERE;
    }

    public void setName(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public double getSold() {
        return sold;
    }

    public String toString() {
        String msg = "Nume cont: " + nume + " | Sold: " + sold;
        return msg;
    }
}
