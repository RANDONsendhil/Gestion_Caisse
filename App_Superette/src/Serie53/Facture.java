package Serie53;

import java.io.Serializable;

import Utils.DateUser;

public class Facture<TypeDeNumero> implements Serializable  {
	
	private TypeDeNumero numFacture;
	private DateUser dateFacture;
	private String numClient;
	private String facture;
	
	 public Facture(TypeDeNumero numFacture,DateUser dateFacture, String numClient,String facture ){
		this.numFacture = numFacture;
		this.dateFacture =  dateFacture;
		this.numClient = numClient;
		this.facture = facture;
	}
public Facture(){}


public String toString(){
	
	return "** CLIENT : "+numClient+ "\n** DATE DE FACTURATION :"+ dateFacture+"** NUMERO DE FACTURE :  "+numFacture+"\n"+facture+""
			+ "\n***********************************************************************************************************************"
			+ "****************\n\n";
	
}
///SETTERS///
public void setnumFacture(TypeDeNumero numFacture ){
	this.numFacture = numFacture;
	
	
}

public void setDateFacture  (DateUser dateFacture ){
	this.dateFacture =  dateFacture;
	
	
}
public void setnumClient(String numClient ){
	this.numClient = numClient;
	
	
}
public void setfacture(String facture ){
	this.facture = facture;
	
	
}
//GETTERS////
public DateUser getdateFacture(){
	return dateFacture;
}



public TypeDeNumero getnumFacture(){
	return numFacture;
} 

public String getNumClient(){
	
	return numClient;
}
public String getFacture(){
	return facture;
}


}
