package Serie42;

import java.util.*;

import MesInterfaces.InterfaceStructure;
import Utils.DateUser;
 
public class Commande42<TypeDeNumero> implements InterfaceStructure < LigneDeCommande42, Integer> {
	
 
	
	private Vector<LigneDeCommande42> Cde = new Vector<LigneDeCommande42>();
	 
	TypeDeNumero numcde;
	DateUser  datecde= new DateUser();
 

	 

	public Commande42(){}
	
	public Commande42(Vector<LigneDeCommande42>cde, TypeDeNumero numcde,DateUser datecde ){
	this.Cde=cde;
	this.numcde=numcde;
	this.datecde=datecde;
	
	}

	///Afficher Une Ligne De ///
	public String toString(){
	
	String str = "";
	
	str = "\nCommande n°: "+numcde+ " Date de Commande: "+datecde+ ""; 
	
	if(taille()==0) return null;
	for(LigneDeCommande42 ldc: Cde){
		
	str = str+ldc.toString(); }
 
	return str;
	}
	
	
	///Ajouter Une Ligne De Commande//
	public void ajouter (LigneDeCommande42 ldc){
		Cde.addElement(ldc);
	}

	
	///Supprimer Une Ligne De Commande//
	
	public void supprimer (Integer code){
	for(LigneDeCommande42 ldc: Cde){
		if(ldc.getCode()== code){
			Cde.remove(ldc); } }
	}
	

	public void supprimerLDC (int code){
		
		for (int i = 0; i<taille(); i++){
			
			if(Cde.get(i).getCode()==code){
				Cde.remove(i);}}	}
	
	
	
		public void  supprimer(LigneDeCommande42 ldc) {
		 Cde.remove(ldc);	}
	
		
		
		
		public LigneDeCommande42 retournerI ( int indice){
		
		return Cde.get(indice); }
	
				
		
	
		public int taille(){
			return Cde.size(); }
	 
	 
		
		public LigneDeCommande42  retourner(Integer code){
			
			for(  LigneDeCommande42 ldc: Cde ){
				if(ldc.getCode()==code){
				return ldc;	
				}}
			return null;   }
	 
	
	 
	 public void SetNumCde(TypeDeNumero numCde2) {
	 	 this.numcde = numCde2;}

	 
	 
	 public   TypeDeNumero GetnumCde(){
	 	return numcde; }
	 
	 
	 
	 public  String EditerFacture(Commande42<Integer> cde, TablesDesArticles42  tabart) { 
		 
	 
		 float TOTAL = 0;
		 
	
		 String date;
		 String entete;
		 String body = "";
		 String bas;
		 
		 
		 
	date="Date : "+datecde+"\n";
	entete="CODE\tDESIGNATION\t\tQUANTITE\t\tPU(HT)\t\tTOTAL(HT)\n"
					+  "________________________________________________________________________________________________\n";
	 
	 for(int i =0; i<cde.taille(); i++){
		 
		 ArticleAbstrait art = tabart.retourner(cde.retournerI(i).getCode());
	 	  if(art!=null){
	 		 
	 		 
	 		  		body =body+"\n"+cde.retournerI(i).getCode()+
				   "\t**"+tabart.retourner(cde.retournerI(i).getCode()).getDesignation()+
				   "\t\t**"+cde.retournerI(i).getQuantite()+ 
				   "\t\t**"+tabart.retourner(cde.retournerI(i).getCode()).getPU()+ 
				   "\t\t**"+ (int)( art).prixFacturer((cde.retournerI(i).getQuantite())*100)/100f+  art.getInfoReduction();}
	 		  	 
	 	 

	 		  		TOTAL = TOTAL+( art).prixFacturer((cde.retournerI(i).getQuantite())); }
	  
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
	
 
}
