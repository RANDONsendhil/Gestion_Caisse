package Serie53;

public class ArticlePromo53  extends ArticleAbstrait53 {
	private float reduction;
	private int quantiteMini;
	public ArticlePromo53(){}
	
	public ArticlePromo53 (int code, String designation, float pu, float reduction, int quantiteMini){
		
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
	 
	 public String typeDePromotion(){
			String str = "\t\t***** ARTICLE EN PROMO !*****\n Si la quantite Commandee >="+ getQuantiteMini()+"\n ";
			return str;
			
		}
	
}
