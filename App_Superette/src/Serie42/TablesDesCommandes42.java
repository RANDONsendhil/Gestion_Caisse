package Serie42;
import java.util.*;

import MesInterfaces.InterfaceStructure;

public class TablesDesCommandes42 implements InterfaceStructure < Commande42<Integer>, Integer>{

 
	private Hashtable <Integer, Commande42<Integer>> TabCde = new  Hashtable <Integer, Commande42<Integer>>();


	
	public TablesDesCommandes42(){}
	
	public String toString(){
		String str = "\n*** Listes Des COMMANDES Passées ***\n";
		 
		if(taille()== 0)str = "\n**AUCUNE Commande est Actuellement en Cours**\n";
		
		else{
			for(Commande42<Integer>cde: TabCde.values()){
				str = str + cde.toString() + "\n";
			}
			
		}return str;
			
	}
	 
	public Commande42<Integer> retourner(Integer key){
		
		for(Integer A: TabCde.keySet()){
			
			if(A==key){
				return TabCde.get(A);}
			}
		return null;
		}
	
	
	public int taille(){
	return TabCde.size();
	}
	
	
	
	public void ajouter(Commande42<Integer> cde ){
	 TabCde.put(cde.GetnumCde(), cde);  
	} 
		
	public void supprimer(Integer cle){
		 
		  TabCde.remove(cle);
	} 
	
	
	
	
	public String getCLECommande(){
		String str = "";
		for(Integer A: TabCde.keySet() ){
			str =str+A+" **";
		}
		return str;
	}
	
	public int getNumeroCommande(){
		int i = 0;
		
		for(Integer A: TabCde.keySet() ){
			i =i+A;
		}
		return i;
	}
	 
	 
	public   String editerFactureTC( Commande42<Integer> cde ,TablesDesArticles42  tabart, int key) { 
		 
	   return cde.EditerFacture(TabCde.get(key), tabart);  }
 


public void PURGE( int code){
	
	Enumeration <Commande42<Integer> > enumcde = TabCde.elements();
	while(enumcde.hasMoreElements()){
		Commande42<Integer>  cde1 = enumcde.nextElement();
		if(cde1.retourner(code)!=null){
			cde1.supprimer(cde1.retourner(code));
			 
		}
		if(cde1.taille()==0)supprimer(cde1.GetnumCde());
	}}
public Set<Integer>cle(){
	return TabCde.keySet();
}

 
 


}


 


