import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Moneta m = new Moneta(0, 0);

        m.setValore(1000);
        System.out.println(m.getValore());

        m.setOfferta(5);
        System.out.println(m.getOfferta());

        ArrayList<Moneta> monete = new ArrayList<>(0);
        

        m.setOfferta(7);


        m.CaricaMonete(monete);

    
        System.out.println(m.getOffer());

    }
}
