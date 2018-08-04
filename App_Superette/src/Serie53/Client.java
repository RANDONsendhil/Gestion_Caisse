package Serie53;

import java.io.Serializable;

import Utils.DateUser;

public class Client  implements Serializable {

String numClient;
float valeurTotale ;
int nbCdes =0;
String nomPrenom;
String localite;
DateUser dateCreation = new DateUser();
 
	
public Client(){}	

public Client(String numCl,   String nP , String localite  ){
	this.numClient= numCl; 
  	this.nomPrenom = nP;
	this.localite = localite;
	 
	 
	 
}


public String toString(){
	
	String str = "\nCODE CLIENT: "+numClient+"**   NOM PRENOM: "+ nomPrenom+"**   DATE DE CREATION: "+dateCreation+"**   LOCALITE: "+localite+"** NB Commandes:"+nbCdes+" **CA Reslise "+valeurTotale+"";
	return str;
}

 
public String getNumClient() {
	
	return numClient ;
}

public void setNumClient(String numClient) {
	this.numClient = numClient;
}

public float getValeurTotale() {
	return valeurTotale;
}

public void setValeurTotale(float valeurTotale) {
	this.valeurTotale = valeurTotale;
}

public int getNbrCde() {
	return nbCdes;
}

public void setNbrCde(int nbrCde) {
	this.nbCdes = nbrCde;
}

public String getNomPrenom() {
	return nomPrenom;
}

public void setNomPrenom(String nomPrenom) {
	this.nomPrenom = nomPrenom;
}

public String getLocalite() {
	return localite;
}

public void setNomDpt(String nomDpt) {
	this.localite = nomDpt;
}
 

}
