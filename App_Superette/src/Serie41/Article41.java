package Serie41;

public class Article41 {

	private int Code;
	private String Designation;
	protected float PU;
	
	public Article41 (int code, String designation, float pu){
		
		this.Code = code;
		this.Designation = designation;
		this.PU = pu;
		}
	
	public Article41(){}
	public int getCode(){return Code;}
	public float getPrix(){return   PU;}
	public String getDesignation(){return Designation;}
	public String toString(){
		
		return "CODE: "+ Code +" DESIGNATION: "+Designation+   " PRIX: "+ PU     ;}
		
	public float prixFacturer(int quantite){
		
		
		return PU*quantite;
	}
	 

	public String getInfoReduction() {
		 String str ="";
		return str;
	}
	
	
	
}
