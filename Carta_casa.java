import java.util.HashMap;

public class Carta_casa {
    private String tipo;
    private int valore;
    private static HashMap<String, Integer> valori;

    static {
        valori = new HashMap<>();
        valori.put("cartone", 1);
        valori.put("tombino", 2);
        valori.put("caverna", 3);
        valori.put("capanna", 4);
        valori.put("baracca", 5);
        valori.put("cuccia", 6);
        valori.put("cane", 7);
        valori.put("appartamento", 8);
        valori.put("villetta_a_schiera", 9);
        valori.put("villa", 10);
        valori.put("baita", 11);
        valori.put("mansarda", 12);
        valori.put("castello", 13);
        valori.put("fattoria", 14);
        valori.put("cascina", 15);
        valori.put("casale", 16);
        valori.put("condominio", 17);
        valori.put("trullo", 18);
        valori.put("attico", 19);
        valori.put("grattacielo", 20);
        valori.put("tenda", 21);
        valori.put("igloo", 22);
        valori.put("camper", 23);
        valori.put("roulotte", 24);
        valori.put("isola", 25);
        valori.put("nave_spaziale", 26);
        valori.put("yacht", 27);
        valori.put("imperial_villa", 28);
        valori.put("torretta", 29);
        valori.put("faro", 30);
        valori.put("casa_sull_albero", 31);
    }

    public Carta_casa(String tipo) {
        this.tipo = tipo;
        this.valore = valori.get(tipo);
    }


    public String getTipo() {
        return tipo;
    }

    public int getValore() {
        return valore;
    }

    public static void main(String[] args) {
        Carta_casa carta1 = new Carta_casa("baracca");
        Carta_casa carta2 = new Carta_casa("casa_sull_albero");

        System.out.println("La carta 1 è di tipo: " + carta1.getTipo());
        System.out.println("Ha valore: " + carta1.getValore());

        System.out.println("La carta 2 è di tipo: " + carta2.getTipo());
        System.out.println("Ha valore: " + carta2.getValore());
    }
}