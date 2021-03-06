package Serie51;

import java.io.Serializable;
import java.util.*;

import MesInterfaces.InterfaceStructure;
import Utils.DateUser;
 
public class Commande51<TypeDeCle> implements InterfaceStructure < LigneDeCommande51, Integer>, Serializable {
	
 
	
	private Vector<LigneDeCommande51> cde = new Vector<LigneDeCommande51>();
	 
	private String numcde;
	DateUser  datecde= new DateUser();
	private boolean etatFacture =false;
	private float valeurTotale= 0f;
	private String numClient;
	private DateUser dateFacture;

	 

	public Commande51(){}
	
	public void setEtatFacture(boolean etat){
		this.etatFacture = etat;
		}
	
	public void setValeurTotale(float valeur){
		this.valeurTotale = valeur;
	}
	
	public DateUser getDateFacture(){
		return this.dateFacture;
		
	}
	
	public boolean getEtatFacture(){ 
		return this.etatFacture;
	}
	
	public DateUser setDateFacture(DateUser dat){
		return this.dateFacture = dat;
	}
	
	
	
		public float prixTotalHR(TablesDesArticles51 tabArt, Commande51<String> cde){
		float total =0;
		for(int i = 0; i<cde.taille(); i++){
			ArticleAbstrait51 art = tabArt.retourner(cde.retournerI(i).getCode());
		 	  if(art!=null){
			total = total+( art).prixFacturer(cde.retournerI(i).getQuantite());
		 	  }
		}
		return (int)(total*100)/100f;
		
	}
	
	
	
	public Commande51(Vector<LigneDeCommande51>cde, String numcde,DateUser datecde ){
	this.cde=cde;
	this.numcde=numcde;
	this.datecde=datecde;
	
	}

	///Afficher Une Ligne De Commande///
	public String toString(){
	
	String str = "";
	String facture="";
	
	
	if(taille()==0) return null;
	if(etatFacture)facture= " *** FACTUREE LE "+ dateFacture+ " ";
	if(!etatFacture) facture = "  *** PAS ENCORE FACTUREE ****";
	
	str = "--------------------------------------------------------------------------"
			+ "\n\nCommande n�: "+numcde+ " Date de Commande: "+datecde+ "\n *** Valeur Totale: "+this.valeurTotale+" � \n" +facture; 
	
	for(LigneDeCommande51 ldc: cde){
		
	str = str+ldc.toString()+""; }
 
	return str;
	}
	
	public LigneDeCommande51  retourner(Integer code){
		
		for(  LigneDeCommande51 ldc: cde ){
			if(ldc.getCode()==code){
			return ldc;	
			}}
		return null;   }
	
	///Ajouter Une Ligne De Commande//
	public void ajouter (LigneDeCommande51 ldc){
		cde.addElement(ldc);
	}

	
	///Supprimer Une Ligne De Commande//
	
	public void supprimer (Integer code){
	for(LigneDeCommande51 ldc: cde){
		if(ldc.getCode()== code){
			cde.remove(ldc); } }
	}
	

	public void supprimerLDC (int code){
		
		for (int i = 0; i<taille(); i++){
			
			if(cde.get(i).getCode()==code){
				cde.remove(i);}}	}
	
		
		public void  supprimer(LigneDeCommande51 ldc) {
		 cde.remove(ldc);	}
	
				
		public LigneDeCommande51 retournerI ( int indice){
		
		return cde.get(indice); }
	
		public int taille(){
			return cde.size(); }
	 
	 
	 public void SetNumCde(String numCde) {
	 	 this.numcde = numCde;}

	 
	 
	 public   String GetnumCde(){
	 	return this.numcde; }
	 
	 
	 
	 public  String EditerFacture(Commande51<String> commande51, TablesDesArticles51  tabart) { 
		 	 
		 float TOTAL = 0;
		 		 String date;
		 String entete;
		 String body = "";
		 String bas;
		 String factureComplet ="";
		 
		 
	date="Date : "+datecde+"\n";
	entete="CODE\tDESIGNATION\t\tQUANTITE\t\tPU(HT)\t\tTOTAL(HT)\n"
					+  "________________________________________________________________________________________________\n";
	 
	 for(int i =0; i<commande51.taille(); i++){
		 
		 ArticleAbstrait51 art = tabart.retourner(commande51.retournerI(i).getCode());
	 	  if(art!=null){
	 		 
	 		 
	 		  		body =body+"\n"+commande51.retournerI(i).getCode()+
				   "\t**"+tabart.retourner(commande51.retournerI(i).getCode()).getDesignation()+
				   "\t\t**"+commande51.retournerI(i).getQuantite()+ 
				   "\t\t**"+tabart.retourner(commande51.retournerI(i).getCode()).getPU()+ 
				   "\t\t**"+ (int)( art).prixFacturer((commande51.retournerI(i).getQuantite())*100)/100f+  art.getInfoReduction();}
	 		  	 
	 	 

	 		  		TOTAL = TOTAL+( art).prixFacturer((commande51.retournerI(i).getQuantite())); }
	  
		 		double TVA ;
		 		double  TOTALTOUTTAXE;
		 		TVA  = TOTAL*19.6/100  ; 
		 		TOTALTOUTTAXE =   TVA+TOTAL ;
				bas="\n________________________________________________________________________________________________\n"
	 					
	 			+ "\n\t\t\t\t\t***TOTAL HORS TAXE   : "+(int)(TOTAL*100)/100f+" ***"
	 			+ "\n\t\t\t\t\t***TVA (19.6%)                : "+(int)(TVA*100)/100f+" ***"
	 			+ "\n\t\t\t\t\t***TOTAL TOUT TAXE    : "+(int)(TOTALTOUTTAXE*100)/100f+" ***";
	 
	 
	 			  factureComplet = factureComplet+date+entete+body+bas;	 
 
 
	 			return factureComplet; }
 
}
