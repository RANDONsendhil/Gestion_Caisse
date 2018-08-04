package Serie51;
import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;

public class TablesDesCommandes51 implements InterfaceStructure < Commande51<String>, String>, Serializable{

 
	private Hashtable <String, Commande51<String>> TabCde = new  Hashtable <String, Commande51<String>>();


	
	public TablesDesCommandes51(){}
	
	public String toString(){
		String str = "\n*** Listes Des COMMANDES Passées ***\n";
		 
		if(taille()== 0)str = "\n**AUCUNE Commande est Actuellement en Cours**\n";
		
		else{
			for(Commande51<String>cde: TabCde.values()){
				str = str + cde.toString() + "\n";
			}
			
		}return str;
			
	}
	 
	public Commande51<String> retourner(String key){
		
	for(String A : TabCde.keySet())
	if(TabCde.containsKey(A)){
		return  TabCde.get(key);
	} 
	return null;
	}
		 
	
	 
	public int taille(){
	return TabCde.size();
	}
	
	
	
	public void ajouter(Commande51<String> cde ){
	 TabCde.put(cde.GetnumCde(), cde);  
	} 
		
	public void supprimer(String cle){
		 
	  TabCde.remove(cle);
	} 
	
	
	
	
	public String getCLECommande(){
		String str = "";
		for(String A: TabCde.keySet() ){
			str =str+A+" **";
		}
		return str;
	}
	
	public String getNumeroCommande(){
		String num = "";
		
		for(String A: TabCde.keySet() ){
			num  = A;
		}
		return num;
	}
	 
	 
	public   String editerFactureTC( Commande51<String> cde ,TablesDesArticles51  tabart, String cle ) { 
	 if(TabCde.get(cle) == null){
		 return null;
	 }else
	    return cde.EditerFacture(   TabCde.get(cle),tabart);}
 


public void PURGE( int code){
	
	Enumeration <Commande51<String> > enumcde = TabCde.elements();
	while(enumcde.hasMoreElements()){
		Commande51<String>  cde  = enumcde.nextElement();
		if(cde.retourner(code)!=null){
			cde.supprimer(cde.retourner(code));
			 
		}
		if(cde.taille()==0)supprimer(cde.GetnumCde());
	}}
public Set<String> cle(){
	return TabCde.keySet();
}

 
 
 
 


}


 


