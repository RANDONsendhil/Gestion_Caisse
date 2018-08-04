package Serie51;

public class ArticlePromo51  extends ArticleAbstrait51 {
	private float reduction;
	private int quantiteMini;
	public ArticlePromo51(){}
	
	public ArticlePromo51 (int code, String designation, float pu, float reduction, int quantiteMini){
		
	this.code = code;
	this.designation =designation;
	this.pu = pu;
	this.reduction = reduction;
	this.quantiteMini = quantiteMini;
	
	}
	
	public float getReduction(){return reduction;}
	public int getQuantiteMini(){return quantiteMini;}
	
	public String toString(){
		 
		return "CODE: "+ getCode() +" DESIGNATION: "+getDesignation()+ "PRIX: "+ getPU()+   "***PROMO Reduction "+reduction+"%"+ " ***Quantité Minimum "+quantiteMini ;
		 
	}
	 
	
	public float prixFacturer(int quantite){

		if(quantite<quantiteMini){
			     return getPU()*quantite ;
		} return  getPU()*quantite-  (getPU()*quantite)*(reduction/100) ;}
		
	 public String getInfoReduction(){
		 return "  -->(remise:"+ getReduction()+"% si qtite cdee >= "+ getQuantiteMini()+")  ";
	 }
	
}
