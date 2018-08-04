package serie52;
import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;
public class TablesDesArticles52 implements InterfaceStructure<ArticleAbstrait52, Integer>, Serializable {
	private TreeMap <Integer, ArticleAbstrait52> Tabart;
	
	
	public TablesDesArticles52(TreeMap<Integer, ArticleAbstrait52> tabart){
		
		this.Tabart = tabart;              
	}
	
	public TablesDesArticles52(){
		Tabart = new TreeMap<Integer, ArticleAbstrait52>();
		ArticleAbstrait52 Art1 = new Article52(1, "DisqueDur", 50.23f );
		ArticleAbstrait52 Art2 = new Article52(2, "Processor", 50.65f);
		ArticleAbstrait52 Art3 = new Article52(3, "Clavier  ", 50.89f );
		ArticleAbstrait52 Art4 = new Article52(4, "Ram      ", 50.96f );
		ArticleAbstrait52 Art5 = new Article52(5, "CleUsb   ", 50.26f );
		ArticleAbstrait52 art6 = new ArticlePromo52(6, "PROMO 1", 100f, 10.3f,15 );
		ArticleAbstrait52 art7 = new ArticlePromo52(7, "PROMO 2", 50.10f, 30.4f,10 );
		ArticleAbstrait52 art8 = new ArticlePromo52(8, "PROMO 3", 60.5f, 20.0f,5 );
		
	 		
		
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
		
		for( ArticleAbstrait52 Art: Tabart.values()){ 
			
			str = str+Art.toString()+"\n";}
		 
		return    str;
	  
	}
	
	public int taille(){
	return Tabart.size();
	}
 
	public ArticleAbstrait52 retourner(Integer code){
		 return Tabart.get(code);
	}
	 

	 
	public void ajouter( ArticleAbstrait52 art){
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
		for(ArticleAbstrait52 art: Tabart.values()){
			
			if(art instanceof ArticlePromo52 )str = str+art.toString()+"\n";
			
		}return str;
		
	}

 

 

	 
 
	
}
	
	 
	
