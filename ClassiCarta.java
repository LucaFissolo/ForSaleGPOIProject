import java.util.ArrayList;
import java.util.Random;

// Definizione dell'enumerazione TipoAbitazione per rappresentare i tipi di abitazione
enum TipoAbitazione {
    TENDA,
    ROULOTTE,
    STANZA_SINGOLA,
    MONOLOCALE,
    BILOCALE,
    TRIVANO,
    ATTICO,
    COTTAGE,
    VILLETTE_A_SCHIERA,
    BUNGALOW,
    CASCINA,
    APPARTAMENTO_CON_VISTA,
    VILLA_A_SCHIERA,
    CONDOMINIO,
    VILLA,
    CASTELLO,
    YACHT,
    PENTHOUSE,
    RANCH,
    VILLETTA,
    GRATTACIELO,
    CASA_SULL_ALBERO,
    BARCA_A_VELA,
    ISOLA_PRIVATA,
    MANSIONE,
    VILLA_CON_PARCO,
    CASTELLO_MEDIEVALE,
    YACHT_DI_LUSSO,
    GRATTACIELO_DI_VETRO,
    ISOLA_PRIVATA_CON_RESORT
}

// Definizione della classe Carta, che rappresenta una carta generica con un id
class Carta {
    private int id = 0;
    public Carta(int id) {
        this.id = id;
    }
    public int getId() { return this.id; }
}

// Definizione della classe Abitazione, che estende la classe Carta e rappresenta una carta che rappresenta un'abitazione
class Abitazione extends Carta {
    private String imageUrl; // URL dell'immagine dell'abitazione
    private TipoAbitazione tipo; // Tipo dell'abitazione

    // Costruttore della classe Abitazione
    public Abitazione(int id, String imageUrl, TipoAbitazione tipo) {
        super(id); // Chiamata al costruttore della classe Carta per inizializzare l'id della carta
        this.imageUrl = imageUrl;
        this.tipo = tipo;
    }

    // Metodo per ottenere il tipo dell'abitazione
    public TipoAbitazione getTipo() {
        return tipo;
    }

    // Metodo per ottenere l'URL dell'immagine dell'abitazione
    public String getImageUrl() {
        return imageUrl;
    }

    // Override del metodo toString() per ottenere una rappresentazione testuale dell'oggetto Abitazione
    @Override
    public String toString() {
        return "Abitazione{" +
                "imageUrl='" + imageUrl + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

// Definizione della classe MazzoAbitazioni, che rappresenta un mazzo di carte Abitazione
class MazzoAbitazioni {
    private ArrayList<Abitazione> carte; // Lista delle carte nel mazzo

    // Metodo per estrarre una carta dal mazzo
    public Abitazione estrai() {
        int qta = carte.size(); // Numero di carte nel mazzo
        Random random = new Random(); // Generatore di numeri casuali
        int estratta = random.nextInt(qta); // Indice della carta estratta
        Abitazione ret = carte.get(estratta); // Carta estratta
        carte.remove(estratta); // Rimozione della carta dal mazzo
        return ret;
    }
    public MazzoAbitazioni() {
        carte = new ArrayList<>();
        int i=1;
        for (TipoAbitazione tipo: TipoAbitazione.values())
            carte.add(new Abitazione(i++,null, tipo));
    }

}
class CarteInTavola {
    private ArrayList<Abitazione> carte; // L'insieme di carte in tavola

    public CarteInTavola(int quante, MazzoAbitazioni mazzo) { // Costruttore delle carte in tavola
        carte = new ArrayList<>(); // Inizializza la lista di carte in tavola
        for (int i=0; i<quante; i++) // Aggiunge al mazzo in tavola un numero di carte pari al valore di quante
            carte.add(mazzo.estrai()); // Estrae una carta dal mazzo e la aggiunge all'elenco delle carte in tavola
    }

    public ArrayList<Abitazione> getCarte() { // Restituisce l'elenco delle carte in tavola
        return carte;
    }
}

class Test {
    public static void main(String[] args) {
        MazzoAbitazioni mazzo = new MazzoAbitazioni();
        CarteInTavola inTavola = new CarteInTavola(5,mazzo);
        ArrayList<Abitazione> cc = inTavola.getCarte();
        for(Abitazione ab : cc) {
            System.out.println(ab);
        }

    }
}
