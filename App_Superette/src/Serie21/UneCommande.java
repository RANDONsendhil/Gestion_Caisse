package Serie21;
import java.util.*;

import Utils.ClientJava;
public class UneCommande {
	
	private Vector <LigneDeCommande> Cde = new Vector<LigneDeCommande>();
	 
	
	public  UneCommande(Vector<LigneDeCommande> Cde){
		this.Cde = Cde;
		
	}

	public UneCommande(){
	 	
	}
	
	
	
	
	public String toString(){
		String str = "";
		if(Cde.size()==0){ClientJava.affiche("** Pas De Commande en Cours **");}
		else	for (LigneDeCommande LDC: Cde){
			
			str = str+LDC.toString()+"\n";
			 
		}
		return str;
		
	}
	public int Taille(){
		return Cde.size();
	}
	
	public LigneDeCommande Retourner ( int indice){
		
		return Cde.get(indice);
	}
	public void Ajouter (LigneDeCommande LDC){
		
		Cde.addElement(LDC);
	}
	
	public void SupprimerIndice(int indice){
		Cde.remove(indice);
	}
	

	public void  Supprimer(LigneDeCommande ldc) {
		 Cde.remove(ldc);
		  
		}
	
	public LigneDeCommande RETOURNER (int code){
		
		for(  LigneDeCommande ldc: Cde ){
			if(ldc.GetCode()==code){
			return ldc;	
			}
		}
		return null;
	}
	 
public LigneDeCommande Retourner1 ( int indice){
		
		
		if(Taille()==0) return null;
		 
 for(LigneDeCommande ldc: Cde){
	if (indice == ldc.GetCode())return ldc; 
 }
		
		return null;
	}



public void AddQuantite(int code, int quatite){
	 
	
	for (LigneDeCommande ldc : Cde){
		if(code==ldc.GetCode()){
			quatite=quatite+ ldc.GetQuantite() ;
			System.out.println(quatite);
		}	 
}
}       	
	
////Edition d'une Facture///	
public  void EditerFacture(UneCommande cde, TablesDesArticles  Tabart) { 

ClientJava.affiche("CODE\tDESIGNATION\t\t\tQUANTITE\t\tPU(HT)\t\t\tTOTAL(HT)\n"
				+  "__________________________________________________________________________________________________\n");
 
 for(int i =0; i<cde.Taille(); i++){
ClientJava.affiche(""+cde.Retourner(i).GetCode()+
			   "\t"+Tabart.Retourner(cde.Retourner(i).GetCode()).GetDesignation()+
			   "\t\t\t"+cde.Retourner(i).GetQuantite()+ 
			   "\t\t\t"+Tabart.Retourner(cde.Retourner(i).GetCode()).GetPrix()+ 
			   "\t\t\t"+Tabart.Retourner(cde.Retourner(i).GetCode()).GetPrix()*cde.Retourner(i).GetQuantite()+"\n");
 } ClientJava.affiche("__________________________________________________________________________________________________\n");
}


////Generer TVA partir d'un total de l'ensemble des articles///
public void AfficherTotalTVAetTTC(UneCommande cde, TablesDesArticles  Tabart){
	double TOTAL = 0;
		 
	 for(int i =0; i<cde.Taille(); i++){
			
		 TOTAL = TOTAL+Tabart.Retourner(cde.Retourner(i).GetCode()).GetPrix()*cde.Retourner(i).GetQuantite() ;
	 }
	 double TVA ;
	  TVA  =   TOTAL*19.6/100  ;
	  
	 double  TOTALTOUTTAXE =   TVA+TOTAL ;
	 
	 ClientJava.affiche("\n\t\t\t\t\t\t\t\t***TOTAL HORS TAXE   : "+(int)(TOTAL*100)/100f );
	 ClientJava.affiche("\t\t\t\t\t\t\t\t***TVA (19.6%)       : "+(int)(TVA*100)/100f );
 	 ClientJava.affiche("\t\t\t\t\t\t\t\t***TOTAL TOUT TAXE   : "+(int)(TOTALTOUTTAXE*100)/100f);
 	 
}}



	
 


	
	 
	
	
	
	
 




