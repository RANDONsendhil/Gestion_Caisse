package Serie32;

public class LigneDeCommande {
	
	private int Code;
	private int Quantite;

	public LigneDeCommande (){} 
	public LigneDeCommande(int code, int quantite){
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
