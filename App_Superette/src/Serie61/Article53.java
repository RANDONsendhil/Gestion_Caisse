package Serie61;

public class Article53 extends ArticleAbstrait53 {
 
	private int code;
	private String Designation;
	public float pu;
	
	public Article53 (int code, String designation, float pu){
		
		this.code = code;
		this.Designation = designation;
		this.pu = pu;
		}
	
	public Article53(){}
	public int getCode(){return this.code;}
	public float getPU(){return  this.pu;}
	public String getDesignation(){return Designation;}
	public String toString(){
		
		return "CODE: "+ code +" DESIGNATION: "+Designation+   " PRIX: "+ pu     ;}
		
	public float prixFacturer(int quantite){
		
		
		return   pu*quantite;
	}
	 
	public String getInfoReduction() {
		 String str ="";
		return str;
	}
	 public String typeDePromotion(){
			String str ="";
			return str;
			
		}
		
}
