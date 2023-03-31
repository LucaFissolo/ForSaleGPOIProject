//Alessandro Garino
//Classe CartaProprietà per la classe Bot

public class CartaProprieta {
    private int valore;

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public CartaProprieta(int valore) {
        this.valore = valore;
    }

    @Override
    public String toString() {
        return "CartaProprieta{" +
                "valore=" + valore +
                '}';
    }
}
