package serie52;
import java.io.*;
public abstract class ArticleAbstrait52 implements Serializable{
	protected int code;
	protected String designation;
	protected float pu;
	public ArticleAbstrait52(){}
	public ArticleAbstrait52(int code, String designation, int pu){
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
