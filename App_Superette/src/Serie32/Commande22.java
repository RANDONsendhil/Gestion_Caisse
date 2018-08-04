package Serie32;

import java.util.*;

 
 
import Utils.DateUser;
 
public class Commande22<TypeDeNumero> {
	
 
	
	private Vector<LigneDeCommande> Cde = new Vector<LigneDeCommande>();
	 
	TypeDeNumero numcde;
	DateUser  datecde= new DateUser();

	public Commande22(){}
	
	public Commande22(Vector<LigneDeCommande>cde, TypeDeNumero numcde,DateUser datecde ){
	this.Cde=cde;
	this.numcde=numcde;
	this.datecde=datecde;
	
	}

	///Afficher Une Ligne De ///
	public String toString(){
	
	String str = "";
	
	str = "\nCommande n°: "+numcde+ " Date de Commande: "+datecde+ ""; 
	
	if(Taille()==0) return null;
	for(LigneDeCommande ldc: Cde){
		
	str = str+ldc.toString(); }
 
	return str;
	}
	
	
	///Ajouter Une Ligne De Commande//
	public void ajouter (LigneDeCommande ldc){
		Cde.addElement(ldc);
	}

	
	///Supprimer Une Ligne De Commande//
	
	public void supprimer (int code){
	for(LigneDeCommande ldc: Cde){
		if(ldc.getCode()== code){
			Cde.remove(ldc); } }
	}
	
	public void supprimerIndice(int code) {
		 Cde.remove(code);
		
	}
	public void supprimerLDC (int code){
		
		for (int i = 0; i<Taille(); i++){
			
			if(Cde.get(i).getCode()==code){
				Cde.remove(i);}}
			}
	
	
		public void  supprimer(LigneDeCommande ldc) {
		 Cde.remove(ldc);
	 
		}
	
public LigneDeCommande retournerI ( int indice){
		
		return Cde.get(indice);
	}
	
	 public int Taille(){
		 return Cde.size();
	 }
	 
	 
	 public LigneDeCommande retourner (int code){
			
			for(  LigneDeCommande ldc: Cde ){
				if(ldc.getCode()==code){
				return ldc;	
				}
			}
			return null;
		}
	 
	
	 public  String EditerFacture(Commande22<Integer> cde2, TablesDesArticles22  tabart) { 
		 
		 
		 double TOTAL = 0;
		 double TVA ;
		 double  TOTALTOUTTAXE;
		    
		 String date;
		 String entete;
		 String body = "";
		 String bas;
	     
	     
		 for(int i =0; i<cde2.Taille(); i++){
		 TOTAL = TOTAL+tabart.retourner(cde2.retournerI(i).getCode()).getPrix()*cde2.retournerI(i).getQuantite() ;
		 }	
		 
		 TVA  =   TOTAL*19.6/100  ;
	     TOTALTOUTTAXE =   TVA+TOTAL ;
		 
		 
		 
	date="Date : "+datecde+"\n";
	entete="CODE\tDESIGNATION\t\tQUANTITE\t\tPU(HT)\t\tTOTAL(HT)\n"
					+  "________________________________________________________________________________________________\n";
	 
	 for(int i =0; i<cde2.Taille(); i++){
		
body =body+cde2.retournerI(i).getCode()+
				   "\t**"+tabart.retourner(cde2.retournerI(i).getCode()).getDesignation()+
				   "\t\t**"+cde2.retournerI(i).getQuantite()+ 
				   "\t\t**"+tabart.retourner(cde2.retournerI(i).getCode()).getPrix()+ 
				   "\t\t**"+(int)(tabart.retourner(cde2.retournerI(i).getCode()).getPrix()*cde2.retournerI(i).getQuantite()*100)/100f+"\n";
	 			} bas="________________________________________________________________________________________________\n"
	 		+ "\n\t\t\t\t\t***TOTAL HORS TAXE   : "+(int)(TOTAL*100)/100f
	 		+ "\n\t\t\t\t\t***TVA (19.6%)       : "+(int)(TVA*100)/100f
	 		+ "\n\t\t\t\t\t***TOTAL TOUT TAXE   : "+(int)(TOTALTOUTTAXE*100)/100f;
	 
	 
String factureComplet = date+entete+body+bas;	 
 
 
return factureComplet;

	 }
 



public void SetNumCde(TypeDeNumero numCde2) {
	 this.numcde = numCde2;
	
}

public   TypeDeNumero GetnumCde(){
	return numcde;
	
}


 
}
