package Serie41;

import Serie21.Article;
import Serie21.TablesDesArticles;

public class LigneDeCommande41 {
	
	private int Code;
	private int Quantite;

	public LigneDeCommande41 (){} 
	public LigneDeCommande41(int code, int quantite){
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
