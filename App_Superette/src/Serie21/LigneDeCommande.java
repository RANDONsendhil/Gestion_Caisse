package Serie21;

public class LigneDeCommande {
	
	private int Code;
	private int Quantite;

	 
	public LigneDeCommande(int code, int quantite){
		this.Code = code;
		this.Quantite=quantite;
	 		
	}
	public LigneDeCommande(){}
	
	public int GetCode(){
		return Code;
	}
	
	public int GetQuantite(){
		return Quantite;
		}
	
	public String toString(){
		
		return "CODE: "+ Code+ " QUANTITE: "+Quantite ;
	}
	public void SetQuantite(int Quantite ){
		this.Quantite = Quantite;
	}

	 
	 
	
}
