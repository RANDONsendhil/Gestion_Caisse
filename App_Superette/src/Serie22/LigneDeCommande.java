package Serie22;
import java.util.*;
public class LigneDeCommande {
	
	private int Code;
	private int Quantite;

	 
	public LigneDeCommande(int code, int quantite){
		this.Code = code;
		this.Quantite=quantite;
	 		
	}
	public LigneDeCommande(){
	
	}
	
	public int GetCode(){
		return Code;
	}
	
	public int GetQuantite(){
		return Quantite;
		}
	
	public String toString(){
		
		return "\nCODE: "+ Code+ " QUANTITE: "+Quantite+"\n" ;
	}
	 
		
}
