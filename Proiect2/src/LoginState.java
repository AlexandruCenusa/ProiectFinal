public class LoginState {
    private static LoginState instance;

    private String nume;
    private boolean state;


    private LoginState() {
        nume = null;
        state = false;
    }

    public static LoginState getInstance() {
        if(null == instance)
            instance = new LoginState();
        return instance;
    }

    public String getNume() {
        return this.nume;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String toString() {
        StringBuffer msg = new StringBuffer("Nume cont: ");
        msg.append(nume);

        return msg.toString();
    }
}
