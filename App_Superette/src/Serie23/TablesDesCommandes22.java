package Serie23;
import java.util.*;

public class TablesDesCommandes22 {

 
	private Hashtable <Integer, Commande22<Integer>> TabCde = new  Hashtable <Integer, Commande22<Integer>>();


	
	public TablesDesCommandes22(){}
	
	public String toString(){
		String str = "\n*** Listes Des COMMANDES Pass�es ***\n";
		 
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
	}}
public Set<Integer>cle(){
	return TabCde.keySet();
}


}


 


