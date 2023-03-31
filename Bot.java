//Alessandro Garino
//Classe Bot

import java.util.*;

public class Bot {
    private String nome = null;
    private ArrayList<CartaProprieta> mazzo = null;
    private Soldi denaro = new Soldi();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<CartaProprieta> getMazzo() {
        return mazzo;
    }

    public void setMazzo(ArrayList<CartaProprieta> mazzo) {
        this.mazzo = mazzo;
    }

    public Soldi getDenaro() {
        return denaro;
    }

    public void setDenaro(Soldi denaro) {
        this.denaro = denaro;
    }

    public Bot(String nome, ArrayList<CartaProprieta> mazzo, Soldi denaro) {
        this.nome = nome;
        this.mazzo = mazzo;
        this.denaro = denaro;
    }
    public Bot(){}

    public Bot(Bot b) {
        this.nome = b.nome;
        this.mazzo = b.mazzo;
        this.denaro = b.denaro;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "nome='" + nome + '\'' +
                ", mazzo=" + mazzo +
                ", denaro=" + denaro +
                '}';
    }

    //---------------------------------------------------------------------------
    //Aggiungo una proprietà al mazzo
    public void aggiungiProprieta(CartaProprieta proprieta){
        mazzo.add(proprieta);
    }

    //Rimuovo una proprietà dal mazzo
    public void rimuoviProprieta(CartaProprieta proprieta){
        mazzo.remove(proprieta);
    }

    //Aggiunge monete al portafoglio
    public void aggiungiDenaro(int monete){
        denaro.setValore(denaro.getValore() + monete);
    }

    //Rimuove monete dal portafoglio
    public void rimuoviDenaro(int monete){
        if(monete > denaro.getValore()) return;
        denaro.setValore(denaro.getValore() - monete);
    }

    //Aumenta il valore di una carta in modo casuale
    public int aumentoValoreCasuale(CartaProprieta carta, int min, int max){
        Random rand = new Random();         //Creo un oggetto Random
        int valore = carta.getValore();     //Quanti soldi vale quella carta

        int numeroCasuale = rand.nextInt((max - min) + 1) + min;
            //Numero casuale tra il minimo e il massimo passati come paramentro

        return valore + numeroCasuale;      //Aggiungo al valore della carta il numero casuale

    }

    //Vendere una proprietà restituetondola al gioco
    public CartaProprieta vendiProprieta(){
        //Guarda quanto costa la prima proprietà per poi metterla a confronto
        //con le altre trovare la carta con il valore minore e venderla
        int valoreMinore = mazzo.get(0).getValore();
        CartaProprieta cartaScelta = null;
        for(CartaProprieta carta: mazzo){       //Scorro il mazzo
            if(carta.getValore() < valoreMinore){       //Controllo il valore
                valoreMinore = carta.getValore();       //Se si lo imposto come valore minimo
                cartaScelta = carta;                    //La carta con il valore minimo
            }
        }
        //Rimuovo la carta dal mio mazzo
        rimuoviProprieta(cartaScelta);

        //Valore della carta aumentata casualmente
        int num = aumentoValoreCasuale(cartaScelta,     //La proprietà
                cartaScelta.getValore(),                //Il valore minimo
                cartaScelta.getValore() + 4);           //Il valore massimo per la random

        cartaScelta.setValore(num);

        //Se la richiesta viene accettata bisogna aggiungere i soldi al nostro portafoglio
        return cartaScelta;
    }

    //Acquisto una proprietà che ho vinto facendo l'offerta
    public void acquistaProprieta(CartaProprieta carta) {
        aggiungiProprieta(carta);       //Acquisto la proprietà

        rimuoviDenaro(carta.getValore());       //Pago

    }

    //Faccio un'offerta proponendo un valore leggermente più alto
    public int faiOfferta(CartaProprieta carta){
        if(denaro.getValore() < carta.getValore() + 2){
            return -1;      //Non può propporre un offerta perchè non ha abbastanza soldi
        }

        return aumentoValoreCasuale(carta, carta.getValore(), carta.getValore()+ 2);
    }


}
