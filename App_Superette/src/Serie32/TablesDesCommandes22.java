package Serie32;
import java.util.*;

public class TablesDesCommandes22 {

 
	private Hashtable <Integer, Commande22<Integer>> TabCde = new  Hashtable <Integer, Commande22<Integer>>();


	
	public TablesDesCommandes22(){}
	
	public String toString(){
		String str = "\n*** Listes Des COMMANDES Passées ***\n";
		 
		if(taille()== 0)str = "\n**AUCUNE Commande est Actuellement en Cours**\n";
		
		else{
			for(Commande22<Integer>cde: TabCde.values()){
				str = str + cde.toString() + "\n";
			}
			
		}return str;
			
	}
	 
	public int taille(){
	return TabCde.size();
	}
	
	public void ajouter(Commande22<Integer> cde ){
	 TabCde.put(cde.GetnumCde(), cde);  
	} 
		
	
	public Commande22<Integer> Retourner(int key){
	
	for(Integer A: TabCde.keySet()){
		
		if(A==key){
			return TabCde.get(A);}
		}
	return null;
	}
	
	public String getCLECommande(){
		String str = "";
		for(Integer A: TabCde.keySet() ){
			str =str+A+" **";
		}
		return str;
	}
	
	public   boolean supprimerUneCommande(int key){
	 
		 return TabCde.remove(key) != null;
	} 
	 
	 
	public   String editerFactureTC( Commande22<Integer> cde ,TablesDesArticles22  tabart, int key) { 
		 
	   return cde.EditerFacture(TabCde.get(key), tabart);  }
 


public void PURGE( int code){
	
	Enumeration <Commande22<Integer> > enumcde = TabCde.elements();
	while(enumcde.hasMoreElements()){
		Commande22<Integer>  cde1 = enumcde.nextElement();
		if(cde1.retourner(code)!=null){
			cde1.supprimer(cde1.retourner(code));
			 
		}
		if(cde1.Taille()==0)supprimerUneCommande(cde1.GetnumCde());
	}}
public Set<Integer>cle(){
	return TabCde.keySet();
}


}


 


