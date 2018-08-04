package Serie42;

public class LigneDeCommande42 {
	
	private int Code;
	private int Quantite;

	public LigneDeCommande42 (){} 
	public LigneDeCommande42(int code, int quantite){
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
