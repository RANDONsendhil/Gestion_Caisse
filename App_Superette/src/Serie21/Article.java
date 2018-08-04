package Serie21;

public class Article {

	private int Code;
	private String Designation;
	private float PU;
	
	public Article (int code, String designation, double pu){
		
		this.Code = code;
		this.Designation = designation;
		this.PU =  (float) pu;
		}
	
	public Article(){}
	public int GetCode(){return Code;}
	public float GetPrix(){return   PU;}
	public String GetDesignation(){return Designation;}
	public String toString(){
		
		return "CODE: "+ Code +" DESIGNATION: "+Designation+" PRIX: "+ PU ;}
	
	
	
}
