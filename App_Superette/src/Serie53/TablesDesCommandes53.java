package Serie53;
import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;

public class TablesDesCommandes53 implements InterfaceStructure < Commande53<String>, String>, Serializable{

 
	private Hashtable <String, Commande53<String>> tabCde = new  Hashtable <String, Commande53<String>>();


	
	public TablesDesCommandes53(){}
	
	public String toString(){
		String str = "\n*** Listes Des COMMANDES Passées ***\n";
		 
		if(taille()== 0)str = "\n**AUCUNE Commande est Actuellement en Cours**\n";
		
		else{
			for(Commande53<String>cde: tabCde.values()){
				str = str + cde.toString() + "\n";
			}
			
		}return str;
			
	}
	 
	public Commande53<String> retourner(String key){
		
	for(String A : tabCde.keySet())
	if(tabCde.containsKey(A)){
		return  tabCde.get(key);
	} 
	return null;
	}
		 
	
	 
	public int taille(){
	return tabCde.size();
	}
	
	
	
	public void ajouter(Commande53<String> cde ){
	 tabCde.put(cde.getNumCde(), cde);  
	} 
		
	public void supprimer(String cle){
		 
	  tabCde.remove(cle);
	} 
	
	
	
	
	public String getCLECommande(){
		String str = "";
		for(String A: tabCde.keySet() ){
			str =str+A+" **";
		}
		return str;
	}
	
	public String getNumeroCommande(){
		String num = "";
		
		for(String A: tabCde.keySet() ){
			num  = A;
		}
		return num;
	}
	 
	 
	public   String editerFactureTC( Commande53<String> cde ,TablesDesArticles53  tabart, String cle ) { 
	 if(tabCde.get(cle) == null){
		 return null;
	 }else
	    return cde.EditerFacture(   tabCde.get(cle),tabart);}
 


public void PURGE( int code){
	
	Enumeration <Commande53<String> > enumcde = tabCde.elements();
	while(enumcde.hasMoreElements()){
		Commande53<String>  cde  = enumcde.nextElement();
		if(cde.retourner(code)!=null){
			cde.supprimer(cde.retourner(code));
			 
		}
		if(cde.taille()==0)supprimer(cde.getNumCde());
	}}
public Set<String> cle(){
	return tabCde.keySet();
}
 
 
 public String cleNonFacture(){
	 String cle = "";
	 Enumeration <Commande53<String>> cdeEnum = tabCde.elements();
	 
	while(cdeEnum.hasMoreElements()){
		
		Commande53<String> cde = cdeEnum.nextElement();
		
		if( !(cde.getEtatFacture())){
		
		cle =cle+"***"+cde.getNumCde(); 
		
		}  
	 	
		}
	return cle;

	
}	 

 
 public String getCleFactSuppressionAuto(){
	 String cle = "";
	 Enumeration <Commande53<String>> cdeEnum = tabCde.elements();
	 
	while(cdeEnum.hasMoreElements()){
		
		Commande53<String> cde = cdeEnum.nextElement();
		
		if( !(cde.getEtatFacture())){
		
		cle =cle+"-"+cde.getNumCde(); 
		
		}  
	 	
		}
	return cle;

	 }

 
 public void suppressionCdeParIdentifiantClient(String codeClient){
	 
	 String cle = "";
	 Enumeration <Commande53<String>> cdeEnum = tabCde.elements();
	 
	while(cdeEnum.hasMoreElements()){
		
		Commande53<String> cde = cdeEnum.nextElement();
		System.out.println(cde.getNumCde());
		if(  (cde.getNumClient().equals(codeClient))){
		
		tabCde.remove(cde.getNumCde());
		
		
		}  
	 	
		}
 }
}
  

 


