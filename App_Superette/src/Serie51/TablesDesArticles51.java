package Serie51;
import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;
public class TablesDesArticles51 implements InterfaceStructure<ArticleAbstrait51, Integer>, Serializable {
	private TreeMap <Integer, ArticleAbstrait51> Tabart;
	
	
	public TablesDesArticles51(TreeMap<Integer, ArticleAbstrait51> tabart){
		
		this.Tabart = tabart;              
	}
	
	public TablesDesArticles51(){
		Tabart = new TreeMap<Integer, ArticleAbstrait51>();
		ArticleAbstrait51 Art1 = new Article51(1, "DisqueDur", 50.23f );
		ArticleAbstrait51 Art2 = new Article51(2, "Processor", 50.65f);
		ArticleAbstrait51 Art3 = new Article51(3, "Clavier  ", 50.89f );
		ArticleAbstrait51 Art4 = new Article51(4, "Ram      ", 50.96f );
		ArticleAbstrait51 Art5 = new Article51(5, "CleUsb   ", 50.26f );
		ArticleAbstrait51 art6 = new ArticlePromo51(6, "PROMO 1", 100f, 10.3f,15 );
		ArticleAbstrait51 art7 = new ArticlePromo51(7, "PROMO 2", 50.10f, 30.4f,10 );
		ArticleAbstrait51 art8 = new ArticlePromo51(8, "PROMO 3", 60.5f, 20.0f,5 );
		
	 		
		
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
		
		for( ArticleAbstrait51 Art: Tabart.values()){ 
			
			str = str+Art.toString()+"\n";}
		 
		return    str;
	  
	}
	
	public int taille(){
	return Tabart.size();
	}
 
	public ArticleAbstrait51 retourner(Integer code){
		 return Tabart.get(code);
	}
	 

	 
	public void ajouter( ArticleAbstrait51 art){
		Tabart.put(art.getCode(), art);
		
	}
	public  void supprimer (Integer code){
		 		
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
		for(ArticleAbstrait51 art: Tabart.values()){
			
			if(art instanceof ArticlePromo51 )str = str+art.toString()+"\n";
			
		}return str;
		
	}

 

 

	 
 
	
}
	
	 
	
