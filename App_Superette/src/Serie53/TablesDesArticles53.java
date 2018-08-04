package Serie53;
import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;
import Utils.DateUser;
import serie52.ArticleAbstrait52;
public class TablesDesArticles53 implements InterfaceStructure<ArticleAbstrait53, Integer>, Serializable {
	private TreeMap <Integer, ArticleAbstrait53> tabart;
	
	
	public TablesDesArticles53(TreeMap<Integer, ArticleAbstrait53> tabart){
		
		this.tabart = tabart;              
	}
	
	public TablesDesArticles53(){
		DateUser dateActuelle = new DateUser();
		DateUser finDaterpromo =new DateUser ().ajouterNombrejours(10);
		
		
		tabart = new TreeMap<Integer, ArticleAbstrait53>();
		ArticleAbstrait53 Art1 = new Article53(1, "DisqueDur", 50.23f );
		ArticleAbstrait53 Art2 = new Article53(2, "Processor", 50.65f);
		ArticleAbstrait53 Art3 = new Article53(3, "Clavier  ", 50.89f );
		ArticleAbstrait53 Art4 = new Article53(4, "Ram      ", 50.96f );
		ArticleAbstrait53 Art5 = new Article53(5, "CleUsb   ", 50.26f );
		ArticleAbstrait53 art6 = new ArticlePromo53(6, "PROMO 1", 100f, 10.3f,15 );
		ArticleAbstrait53 art7 = new ArticlePromo53(7, "PROMO 2", 50.10f, 30.4f,10 );
		ArticleAbstrait53 art8 = new ArticlePromo53(8, "PROMO 3", 60.5f, 20.0f,5 );
		ArticleAbstrait53 art9 = new ArticleLot(9, "LOT A", 60.5f, 20.0f,5,dateActuelle,finDaterpromo);
		ArticleAbstrait53 art10 = new ArticleLot(10, "LOT B", 60.5f, 20.0f,5,dateActuelle,finDaterpromo);
		ArticleAbstrait53 art11 = new ArticleLot(11, "LOT C", 60.5f, 20.0f,5,dateActuelle,finDaterpromo);
		
	 	 
		
		tabart.put(1, Art1);
		tabart.put(2, Art2);
		tabart.put(3, Art3);
		tabart.put(4, Art4);
		tabart.put(5, Art5);
		tabart.put(6, art6);
		tabart.put(7, art7);
		tabart.put(8, art8);
		tabart.put(9, art9);
		tabart.put(10, art10);
	    tabart.put(11, art11);
		
		
			}
	
	
	public  String toString(){
		
		
		String str= "";
		
		for( ArticleAbstrait53 Art: tabart.values()){ 
			
			str = str+Art.toString()+"\n";}
		 
		return    str;
	  
	}
	
	public int taille(){
	return tabart.size();
	}
 
	public ArticleAbstrait53 retourner(Integer code){
		 return tabart.get(code);
	}
	 

	 
	public void ajouter( ArticleAbstrait53 art){
		tabart.put(art.getCode(), art);
		
	}
	public  void supprimer (Integer code){
		 		
		tabart.remove(code);
		}
		 
	 
	
	public String afficherKEYtabart(){
		String str ="";
		for(Integer KEY: tabart.keySet()){
			 str =str+KEY+" **";
	}
		return str;}
	
	
	public String toStringPromo(){
		
		String str = "";
		str ="\n***Articles en Promotion***\n\n";
		for(ArticleAbstrait53 art: tabart.values()){
			
			if(art instanceof ArticlePromo53 )str = str+art.toString()+"\n";
			
		}return str;
		
	}

public String toStringLot(){
		
		String str = "";
		str ="\n*** Articles en Promotion  en LOT ***\n\n";
		for(ArticleAbstrait53 art: tabart.values()){
			
			if(art instanceof ArticleLot )str = str+art.toString()+"\n";
			
		}return str;
		
	}

 
public String cleTabArtLot(){
	
	String str= "";
 
		for(ArticleAbstrait53 art: tabart.values()){
		if(art instanceof ArticleLot){
		 str =str+art.getCode()+"-";
		
		}

	}	return str;
		 
			 
		 
	
}	 

}
	
	 
	
