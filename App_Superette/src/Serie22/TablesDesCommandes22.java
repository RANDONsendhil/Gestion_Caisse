package Serie22;
import java.util.*;
import java.util.Map.Entry;

import Utils.ClientJava;

public class TablesDesCommandes22 {

 
	private Hashtable <Integer, Commande22<Integer>> TabCde = new  Hashtable <Integer, Commande22<Integer>>();
	int numCde = 1;
	
	public TablesDesCommandes22(){}
	
	public String toString(){
		String str = "\n*** Listes Des COMMANDES Passées ***\n";
		 
		if(Taille()== 0)str = "\n**AUCUNE Commande est Actuellement en Cours**\n";
		
		else{
			for(Commande22<Integer>cde: TabCde.values()){
				str = str + cde.toString() + "\n";
			}
			
		}return str;
			
	}
	 
	public int Taille(){
	return TabCde.size();
	}
	
	public void Ajouter(Commande22<Integer> cde ){
	 TabCde.put(cde.GetnumCde(), cde);  
	} 
		
	
	public Commande22<Integer> Retourner(int key){
	if(Taille()==0)System.out.println("Pas de Commande en cours");	 
	for(Integer A: TabCde.keySet()){
		
		if(A==key){
			return TabCde.get(A);}
		}
	return null;
	}
	
	public String GetCLECommande(){
		String str = "";
		for(Integer A: TabCde.keySet() ){
			str =str+A+" **";
		}
		return str;
	}
	
	public   boolean SupprimerUneCommande(int key){
	 
		 return TabCde.remove(key) != null;
	} 
	 

				
				
		
	 
	
	 
	public   void EditerFactureTC( Commande22<Integer> cde ,TablesDesArticles22  tabart, int key) { 
		 
	   cde.EditerFacture(TabCde.get(key), tabart);  }
 


public void PURGE( int code){
	
	Enumeration <Commande22<Integer> > enumcde = TabCde.elements();
	while(enumcde.hasMoreElements()){
		Commande22<Integer>  cde1 = enumcde.nextElement();
		if(cde1.RETOURNER(code)!=null){
			cde1.Supprimer(cde1.RETOURNER(code));
			 
		}
		if(cde1.Taille()==0)SupprimerUneCommande(cde1.GetnumCde());
	}
	
	
	
}

/////Supprimer les lignes de commande en supprimant un article////
/*public void SupprimerLigneDeCommandeUneCommande(int code){
			for(Commande22<Integer> cde: TabCde.values()){
			if(cde.RETOURNER(code)!=null){
				cde.Supprimer(cde.RETOURNER(code));
			if(cde.Taille()==0)	 SupprimerUneCommande(cde.GetnumCde());
			}
		}
	}*/
	}


 


