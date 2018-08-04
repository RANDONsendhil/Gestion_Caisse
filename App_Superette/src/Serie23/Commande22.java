package Serie23;
import java.util.*;

import Serie21.LigneDeCommande;
import Utils.ClientJava;
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
		
	str = str+ldc.toString()+"\n"; }
 
	return str;
	}
	
	
	///Ajouter Une Ligne De Commande//
	public void Ajouter (LigneDeCommande ldc){
		Cde.addElement(ldc);
	}

	
	///Supprimer Une Ligne De Commande//
	
	public void Supprimer (int code){
	for(LigneDeCommande ldc: Cde){
		if(ldc.GetCode()== code){
			Cde.remove(ldc); } }
	}
	
	public void SupprimerIndice(int code) {
		 Cde.remove(code);
		
	}
	public void SupprimerLDC (int code){
		
		for (int i = 0; i<Taille(); i++){
			
			if(Cde.get(i).GetCode()==code){
				Cde.remove(i);}}
			}
	
	
		public void  Supprimer(LigneDeCommande ldc) {
		 Cde.remove(ldc);
	 
		}
	
public LigneDeCommande Retourner ( int indice){
		
		return Cde.get(indice);
	}
	
	 public int Taille(){
		 return Cde.size();
	 }
	 
	 
	 public LigneDeCommande RETOURNER (int code){
			
			for(  LigneDeCommande ldc: Cde ){
				if(ldc.GetCode()==code){
				return ldc;	
				}
			}
			return null;
		}
	 
	
	 public  void EditerFacture(Commande22<Integer> cde2, TablesDesArticles22  tabart) { 
		 
		 double TOTAL = 0;
		 double TVA ;
		 double  TOTALTOUTTAXE;
		    
	     
	     
		 for(int i =0; i<cde2.Taille(); i++){
		 TOTAL = TOTAL+tabart.Retourner(cde2.Retourner(i).GetCode()).GetPrix()*cde2.Retourner(i).GetQuantite() ;
		 }	
		 
		 TVA  =   TOTAL*19.6/100  ;
	     TOTALTOUTTAXE =   TVA+TOTAL ;
		 
		 
		 
	ClientJava.affiche("Date : "+datecde);
	ClientJava.affiche("CODE\tDESIGNATION\t\t\tQUANTITE\t\tPU(HT)\t\t\tTOTAL(HT)\n"
					+  "__________________________________________________________________________________________________\n");
	 
	 for(int i =0; i<cde2.Taille(); i++){
		 ;
	ClientJava.affiche(cde2.Retourner(i).GetCode()+
				   "\t**"+tabart.Retourner(cde2.Retourner(i).GetCode()).GetDesignation()+
				   "\t\t\t**"+cde2.Retourner(i).GetQuantite()+ 
				   "\t\t\t**"+tabart.Retourner(cde2.Retourner(i).GetCode()).GetPrix()+ 
				   "\t\t\t**"+(int)(tabart.Retourner(cde2.Retourner(i).GetCode()).GetPrix()*cde2.Retourner(i).GetQuantite()*100)/100f+"\n");
	 } ClientJava.affiche("__________________________________________________________________________________________________\n"
	 		+ "\n\t\t\t\t\t\t\t\t***TOTAL HORS TAXE   : "+(int)(TOTAL*100)/100f
	 		+ "\n\t\t\t\t\t\t\t\t***TVA (19.6%)       : "+(int)(TVA*100)/100f
	 		+ "\n\t\t\t\t\t\t\t\t***TOTAL TOUT TAXE   : "+(int)(TOTALTOUTTAXE*100)/100f);
	 
	 }
 



public void SetNumCde(TypeDeNumero numCde2) {
	 this.numcde = numCde2;
	
}

public   TypeDeNumero GetnumCde(){
	return numcde;
	
}




 
}
