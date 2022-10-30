package Proiect3;
public class Auto {
    public static final int NR_MAX = 10;
    private String marca;
    private String model;
    private int km;
    private double pret;

    //CONSTRUCTOR
    public Auto(String marca, String model, int km, double pret) {
        this.marca = marca;
        this.model = model;
        this.km = km;
        this.pret = pret;
    }

    //SETTERS
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    //GETTERS
    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getKm() {
        return km;
    }

    public double getPret() {
        return pret;
    }

    //TO STRING
    public String toString() {
        StringBuffer msg = new StringBuffer();
        msg.append(marca); msg.append(" "); msg.append(model);
        msg.append("  |  Km: "); msg.append(km); msg.append("  |  Pret: ");
        msg.append(pret);

        return msg.toString();
    }
}