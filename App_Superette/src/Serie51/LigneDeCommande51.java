package Serie51;

import java.io.Serializable;

public class LigneDeCommande51 implements Serializable {
	
	private int Code;
	private int Quantite;

	public LigneDeCommande51 (){} 
	public LigneDeCommande51(int code, int quantite){
		this.Code = code;
		this.Quantite=quantite;
	 		
	}
	 
	
	public int getCode(){
		return Code;
	}
	
	public int getQuantite(){
		return Quantite;
		}
	
	public String toString(){
		
		return "\nCODE: "+ Code+ " QUANTITE: "+Quantite;
	}
	 
	 
	 
}
