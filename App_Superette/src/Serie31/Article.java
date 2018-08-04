package Serie31;

public class Article {

	private int Code;
	private String Designation;
	private float PU;
	
	public Article (int code, String designation, float pu){
		
		this.Code = code;
		this.Designation = designation;
		this.PU = pu;
		}
	
	public Article(){}
	public int getCode(){return Code;}
	public float getPrix(){return   PU;}
	public String getDesignation(){return Designation;}
	public String toString(){
		
		return "CODE: "+ Code +" DESIGNATION: "+Designation+   " PRIX: "+ PU     ;}
		
}
