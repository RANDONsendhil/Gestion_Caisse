package Serie41;

import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

import IConsole.ES;
import Utils.DateUser;
 
public class Commande41<TypeDeNumero> {
	
 
	
	private Vector<LigneDeCommande41> Cde = new Vector<LigneDeCommande41>();
	 
	TypeDeNumero numcde;
	DateUser  datecde= new DateUser();
 

	 

	public Commande41(){}
	
	public Commande41(Vector<LigneDeCommande41>cde, TypeDeNumero numcde,DateUser datecde ){
	this.Cde=cde;
	this.numcde=numcde;
	this.datecde=datecde;
	
	}

	///Afficher Une Ligne De ///
	public String toString(){
	
	String str = "";
	
	str = "\nCommande n°: "+numcde+ " Date de Commande: "+datecde+ ""; 
	
	if(Taille()==0) return null;
	for(LigneDeCommande41 ldc: Cde){
		
	str = str+ldc.toString(); }
 
	return str;
	}
	
	
	///Ajouter Une Ligne De Commande//
	public void ajouter (LigneDeCommande41 ldc){
		Cde.addElement(ldc);
	}

	
	///Supprimer Une Ligne De Commande//
	
	public void supprimer (int code){
	for(LigneDeCommande41 ldc: Cde){
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
	
	
		public void  supprimer(LigneDeCommande41 ldc) {
		 Cde.remove(ldc);
	 
		}
	
public LigneDeCommande41 retournerI ( int indice){
		
		return Cde.get(indice);
	}
	
	 public int Taille(){
		 return Cde.size();
	 }
	 
	 
	 public LigneDeCommande41 retourner (int code){
			
			for(  LigneDeCommande41 ldc: Cde ){
				if(ldc.getCode()==code){
				return ldc;	
				}
			}
			return null;
		}
	 
	
	 public  String EditerFacture(Commande41<Integer> cde2, TablesDesArticles41  tabart) { 
		 
		 float TOTAL = 0;
		 
	
		 String date;
		 String entete;
		 String body = "";
		 String bas;
		 
		 
		 
	date="Date : "+datecde+"\n";
	entete="CODE\tDESIGNATION\t\tQUANTITE\t\tPU(HT)\t\tTOTAL(HT)\n"
					+  "________________________________________________________________________________________________\n";
	 
	 for(int i =0; i<cde2.Taille(); i++){
		 
		 Article41 art = tabart.retourner(cde2.retournerI(i).getCode());
	 	  if(art!=null){
	 		 
	 		 
	 		  		body =body+"\n"+cde2.retournerI(i).getCode()+
				   "\t**"+tabart.retourner(cde2.retournerI(i).getCode()).getDesignation()+
				   "\t\t**"+cde2.retournerI(i).getQuantite()+ 
				   "\t\t**"+tabart.retourner(cde2.retournerI(i).getCode()).getPrix()+ 
				   "\t\t**"+ (int)( art).prixFacturer((cde2.retournerI(i).getQuantite())*100)/100f+  art.getInfoReduction();}
	 		  	 
	 	 

	 		  		TOTAL = TOTAL+( art).prixFacturer((cde2.retournerI(i).getQuantite())); }
	  
		 		double TVA ;
		 		double  TOTALTOUTTAXE;
		 		TVA  = TOTAL*19.6/100  ; 
		 		TOTALTOUTTAXE =   TVA+TOTAL ;
				bas="\n________________________________________________________________________________________________\n"
	 					
	 			+ "\n\t\t\t\t\t***TOTAL HORS TAXE   : "+(int)(TOTAL*100)/100f+" ***"
	 			+ "\n\t\t\t\t\t***TVA (19.6%)                : "+(int)(TVA*100)/100f+" ***"
	 			+ "\n\t\t\t\t\t***TOTAL TOUT TAXE    : "+(int)(TOTALTOUTTAXE*100)/100f+" ***";
	 
	 
	 			String factureComplet = date+entete+body+bas;	 
 
 
	 			return factureComplet; }
	 
public void SetNumCde(TypeDeNumero numCde2) {
	 this.numcde = numCde2;
	
}

public   TypeDeNumero GetnumCde(){
	return numcde;
	
}


 
}
