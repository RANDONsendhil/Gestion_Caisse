package Serie31;
import java.util.*;
public class TablesDesArticles22 {
	private TreeMap <Integer, Article> Tabart;
	
	
	public TablesDesArticles22(TreeMap<Integer, Article> tabart){
		
		this.Tabart = tabart;
	}
	
	public TablesDesArticles22(){
		Tabart = new TreeMap<Integer, Article>();
		Article Art1 = new Article(1, "DisqueDur", 50.25f );
		Article Art2 = new Article(2, "Processor", 50.65f);
		Article Art3 = new Article(3, "Clavier  ", 50.89f );
		Article Art4 = new Article(4, "Ram      ", 50.96f );
		Article Art5 = new Article(5, "CleUsb   ", 50.26f );
		
		Tabart.put(1, Art1);
		Tabart.put(2, Art2);
		Tabart.put(3, Art3);
		Tabart.put(4, Art4);
		Tabart.put(5, Art5);
			}
	
	
	public  String toString(){
		
		
		String str= "";
		
		for( Article Art: Tabart.values()){ 
			
			str = str+Art.toString()+"\n";}
		 
		return    str;
	  
	}
	
	public int taille(){
	return Tabart.size();
	}
	
	public Article retourner(int code){
		 return Tabart.get(code);
	}

	
	public void ajouter(int key,Article Art){
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
}
	
	 
	
