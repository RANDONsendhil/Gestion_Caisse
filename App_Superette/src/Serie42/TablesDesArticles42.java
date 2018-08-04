package Serie42;
import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;
public class TablesDesArticles42 implements InterfaceStructure<ArticleAbstrait, Integer>  {
 
	 private TreeMap <Integer, ArticleAbstrait> Tabart;
	
	
	public TablesDesArticles42(TreeMap<Integer, ArticleAbstrait> tabart){
		
		this.Tabart = tabart;              
	}
	
	public TablesDesArticles42(){
		Tabart = new TreeMap<Integer, ArticleAbstrait>();
		ArticleAbstrait Art1 = new Article42(1, "DisqueDur", 50.23f );
		ArticleAbstrait Art2 = new Article42(2, "Processor", 50.65f);
		ArticleAbstrait Art3 = new Article42(3, "Clavier  ", 50.89f );
		ArticleAbstrait Art4 = new Article42(4, "Ram      ", 50.96f );
		ArticleAbstrait Art5 = new Article42(5, "CleUsb   ", 50.26f );
		ArticleAbstrait art6 = new ArticlePromo(6, "PROMO 1", 100f, 10.3f,15 );
		ArticleAbstrait art7 = new ArticlePromo(7, "PROMO 2", 50.10f, 30.4f,10 );
		ArticleAbstrait art8 = new ArticlePromo(8, "PROMO 3", 60.5f, 20.0f,5 );
		
	 		
		
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
		
		for( ArticleAbstrait Art: Tabart.values()){ 
			
			str = str+Art.toString()+"\n";}
		 
		return    str;
	  
	}
	
	public int taille(){
	return Tabart.size();
	}
 
	public ArticleAbstrait retourner(Integer code){
		 return Tabart.get(code);
	}
	 

	 
	public void ajouter( ArticleAbstrait art){
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
		for(ArticleAbstrait art: Tabart.values()){
			
			if(art instanceof ArticlePromo )str = str+art.toString()+"\n";
			
		}return str;
		
	}

 

	 
 
	
}
	
	 
	
