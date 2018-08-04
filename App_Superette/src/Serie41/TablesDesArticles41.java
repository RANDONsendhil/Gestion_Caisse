package Serie41;
import java.util.*;
public class TablesDesArticles41 {
	private TreeMap <Integer, Article41> Tabart;
	
	
	public TablesDesArticles41(TreeMap<Integer, Article41> tabart){
		
		this.Tabart = tabart;
	}
	
	public TablesDesArticles41(){
		Tabart = new TreeMap<Integer, Article41>();
		Article41 Art1 = new Article41(1, "DisqueDur", 50.23f );
		Article41 Art2 = new Article41(2, "Processor", 50.65f);
		Article41 Art3 = new Article41(3, "Clavier  ", 50.89f );
		Article41 Art4 = new Article41(4, "Ram      ", 50.96f );
		Article41 Art5 = new Article41(5, "CleUsb   ", 50.26f );
		Article41 art6 = new ArticlePromo(6, "PROMO 1", 100f, 10.3f,15 );
		Article41 art7 = new ArticlePromo(7, "PROMO 2", 50.10f, 30.4f,10 );
		Article41 art8 = new ArticlePromo(8, "PROMO 3", 60.5f, 20.0f,5 );
		
	 
		
		
		Tabart.put(1, Art1);
		Tabart.put(2, Art2);
		Tabart.put(3, Art3);
		Tabart.put(4, Art4);
		Tabart.put(5, Art5);
		Tabart.put(6, art6);
		Tabart.put(7, art7);
		Tabart.put(8, art8);
			}
	
	
	public  String toString(){
		
		
		String str= "";
		
		for( Article41 Art: Tabart.values()){ 
			
			str = str+Art.toString()+"\n";}
		 
		return    str;
	  
	}
	
	public int taille(){
	return Tabart.size();
	}
	
	public Article41 retourner(int code){
		 return Tabart.get(code);
	}
	 

	
	public void ajouter(int key,Article41 Art){
		Tabart.put(key, Art);
		
	}
	
	public void supprimer (int code){
		
		
		Tabart.remove(code);
		}
		 
	 
	public String afficherKEYtabart(){
		String str ="";
		for(Integer KEY: Tabart.keySet()){
			 str =str+KEY+" **";
	}
		return str;}
	
	
	public String toStringPromo(){
		
		String str = "";
		str ="\n***Articles en Promotion***\n\n";
		for(Article41 art: Tabart.values()){
			
			if(art instanceof ArticlePromo )str = str+art.toString()+"\n";
			
		}return str;
		
	}  
	
}
	
	 
	
