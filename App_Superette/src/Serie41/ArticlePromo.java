package Serie41;

public class ArticlePromo extends Article41 {
	private float reduction;
	private int quantiteMini;
	public ArticlePromo(){}
	
	public ArticlePromo (int code, String designation, float pu, float reduction, int quantiteMini){
		super(code,designation,pu);
		
	this.reduction = reduction;
	this.quantiteMini = quantiteMini;
	
	}
	
	public float getReduction(){return reduction;}
	public int getQuantiteMini(){return quantiteMini;}
	
	public String toString(){
		 
		return  super.toString()+" ***PROMO Reduction "+reduction+"%"+ " ***Quantité Minimum "+quantiteMini ;
		 
	}
	 
	
	public float prixFacturer(int quantite){

		if(quantite<quantiteMini){
			     return super.prixFacturer(quantite) ;
		} return  super.prixFacturer(quantite)- super.prixFacturer(quantite)*(reduction/100) ;}
		
	 public String getInfoReduction(){
		 return "  -->(remise:"+ getReduction()+"% si qtite cdee >= "+ getQuantiteMini()+")  ";
	 }
	  	 
	
	
	
}
