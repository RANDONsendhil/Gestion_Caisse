package serie52;

import java.io.Serializable;

public class LigneDeCommande52 implements Serializable {
	
	private int Code;
	private int Quantite;

	public LigneDeCommande52 (){} 
	public LigneDeCommande52(int code, int quantite){
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
