//FinoMattia

//creazione classe Assegno

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class assegno {
    
    private int valore;
    
    // Costruttore
    public assegno(int valore) {
        this.valore = valore;
    }
    
    // Metodo per ottenere il valore dell'assegno
    public int getValore() {
        return valore;
    }
    
    // Metodo per creare una lista di carte Assegno 
    // con i valori specificati
    public static List<assegno> creaMazzo() {
        List<assegno> mazzo = new ArrayList<>();
        // Aggiungi le carte Assegno con i valori specificati
        for (int i = 0; i < 2; i++) {
            for (int j = 3; j <= 15; j++) {
                mazzo.add(new assegno(j));
            }
        }
        // Mescola il mazzo
        Collections.shuffle(mazzo);
        return mazzo;
    }
}
