package Serie51;
import java.io.*;
public abstract class ArticleAbstrait51 implements Serializable{
	int code;
	String designation;
	float pu;
	public ArticleAbstrait51(){}
	public ArticleAbstrait51(int code, String designation, int pu){
		this.code=code;
		this.designation =designation;
		this.pu=pu;
	}
	
	public int getCode (){return code;}
	public String getDesignation(){return designation;}
	public float getPU(){return pu;}
	
	
	public  abstract String toString();
	public abstract float prixFacturer(int quantite);
	public abstract String getInfoReduction();
		 
	
}
