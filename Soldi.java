public class Soldi {
    private int valore;

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    Soldi(){}

    public Soldi(int valore) {
        this.valore = valore;
    }

    @Override
    public String toString() {
        return "Soldi{" +
                "valore=" + valore +
                '}';
    }
}
