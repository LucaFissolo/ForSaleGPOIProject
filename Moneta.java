import java.util.ArrayList;


public class Moneta{

	private int valore = 1000;
	//private int size = 14;
	private ArrayList<Moneta> monete = new ArrayList<>(0);

	private int offerta = 0;

	public Moneta(int valore, int offerta){
	this.valore = valore;
	this.offerta = offerta;
	}


	//GET & SET
	public int getValore(){
	return valore; 
	}

	public void setValore(int newValue){this.valore = newValue;}

	/*
	public int getSize(){
	return size; 
	}

	public void setSize(int newSize){
	this.size = newSize;
	}                           
	*/

	public int getOfferta(){
	return offerta; 
	}

	public void setOfferta(int newOfferta){
	this.offerta = newOfferta;
	}




	public ArrayList<Moneta> CaricaMonete(ArrayList<Moneta> monete){  //Trovare il modo per aggiungere monete

		monete.ensureCapacity(14); //setta la grandezza dell'arraylist a 14, il numero iniziale delle monete

		if(monete.isEmpty()){ //controlla che l'arraylist sia vuoto

			for(int i=0; i<monete.size(); i++){ //riempie l'arraylist di monete

				monete.add(new Moneta(1000, getOfferta())); //aggiunge monete con valore 1000 e tiene traccia del numero di monete offerte

			}

		}

		return monete;

	}




	public ArrayList<Moneta> getOffer(){



		if(offerta > 0 && offerta <= monete.size() ){ //controlla che l'offerta sia di almeno una moneta e 

			for(int j=0; j<offerta; j++){
				monete.remove(1); //Rimuove le monete offerte a partire dall'indice 1
			}

		}

		monete.trimToSize(); // adatta l'arraylist alla dimensione finale, dopo la sottrazione delle monete offerte

		return monete;

	}


	public String toString(){

		return "Monete{" +
			   "valore=" + valore + "}";
 

	}

}










