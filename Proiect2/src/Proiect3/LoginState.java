package Proiect3;

public class LoginState {
    private static String nume = null;
    private static boolean state = false;

    public static String getNume() {
        return nume;
    }

    public static boolean getState() {
        return state;
    }

    public static void setState(boolean s) {
        state = s;
    }

    public static void setNume(String n) {
        nume = n;
    }
}
