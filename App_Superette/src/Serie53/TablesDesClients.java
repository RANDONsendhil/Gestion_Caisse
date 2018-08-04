package Serie53;

import java.io.Serializable;
import java.util.TreeMap;

import MesInterfaces.InterfaceStructure;

public class TablesDesClients implements InterfaceStructure<Client , String>, Serializable {

	private TreeMap<String, Client > tabClient =   new TreeMap<String,Client >(); ;

 
	public TablesDesClients (){
		 
		Client c1 = new Client("ran1","RANDON-SENDHIL","LE PECQ");
		Client c2 = new Client("lil1","LILE-MARIE","SAINT-GERMAIN-EN-LAYE");
		Client c3 = new Client("ran2","RANDON-KEVIN","LE VESINET");
		
		tabClient.put("ran1", c1);
		tabClient.put("li11", c2);
		tabClient.put("ran2", c3);
		
		 
	}
	
	public String toString(){
		String str = "";
		if(taille()==0){
			str = "Table de CLIENT est Vide !";
		}else{
			for(Client c: tabClient.values()){
				str =str+c.toString();
			}
			
			return str;
		}
		return null;
		
	}
	 
	public Client retourner(String cle) {
	 
	 
			return tabClient.get(cle);
		 
	}
 
	public void ajouter(Client  client) {
		tabClient.put(client.getNumClient().toLowerCase(), client);
	}
 
	public void supprimer(String cle) {
		 
		tabClient.remove(cle);
	}

 
	public int taille() {
		 
		return tabClient.size();
	}
	
	
	public String getCodeClient(){
		
		String str ="";
		
		for(String A: tabClient.keySet()){
			
			str = str+A+"-";
		}
		return str;



		
		}

}
