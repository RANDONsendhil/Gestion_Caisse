package serie52;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;

import MesInterfaces.InterfaceStructure;

public class TablesDesFactures implements InterfaceStructure<  Facture<  String>,String> , Serializable  {
	
	 
	private TreeMap< String, Facture<  String>> tabFactures = new TreeMap < String, Facture<  String>>();
	 
	 
	
public  String toString()
{
	String  st ="";
	
	for(Facture< String>  fact : tabFactures.values()){
		st = st+fact.toString();
	}
	
	return st;
}	

public void ajouter(Facture< String>  fact){
	tabFactures.put(fact.getnumFacture(), fact);
}

public  Facture< String> retourner(String numFact){
	return tabFactures.get(numFact);
}

public void supprimer (String numFact){
	tabFactures.remove(numFact);
}

public int taille() {
	return tabFactures.size();
}
public String getCleFact(){
String str = "";

 for(String cle: tabFactures.keySet()){

str = str+cle+" **";

	 }
return str;
}

public String getCleFactSuppressionAuto(){
String str = "";

 for(String cle: tabFactures.keySet()){

str = str+cle+"-";

	 }
return str;
}

}

 
