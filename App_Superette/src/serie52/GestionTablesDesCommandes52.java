package serie52;

 
import Connexion.ConnexionFichier;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
import Utils.DateUser;

 
public class GestionTablesDesCommandes52 implements InterfaceGestion<TablesDesCommandes52>{
	
	

	private	ES ES = new ES();	
	  ConnexionFichier<TablesDesCommandes52>  fichCde; //establish Connection///
 
	
public 	GestionTablesDesCommandes52(String nomPhysique){
		
	fichCde = new ConnexionFichier<TablesDesCommandes52>(nomPhysique);
		
	}
	 
	
	///La methode qui recupere la tables des articles ///
	
	public TablesDesCommandes52 recupere(){
		
		TablesDesCommandes52 tabCde = fichCde.lire();
		if(tabCde == null){
			tabCde = new TablesDesCommandes52();
		}
		return tabCde;
	}
	
	public void sauvegarder(TablesDesCommandes52 tabCde){
		
		ES.affiche("**SAUVEGARDE DES COMMANDES EN COURS... *** ");
		fichCde.ecrie(tabCde);
	}
	
	 
	
	public void menuGeneral(TablesDesCommandes52 tabCde,  Object...objects) throws AbandonException, ErreurSaisie {
		
		
		TablesDesArticles52 tabart = (TablesDesArticles52)objects[0];
		Commande52<String> cde = (Commande52<String>)objects[1];
		TablesDesFactures tabFact = (TablesDesFactures)objects[2];
		
	
	
	 		int choix; 
	 		  	 		
	 	 do{ 
	 		  	 		 
	 		 String num =premierNumero(tabCde);
	 		 choix = menuChoix(num);

		switch (choix){
		case 1 : creer(tabCde,tabart, num) ; break;
		case 2 : supprimer(tabCde,tabFact);break;
		case 3 : afficherUneCommande(tabart, tabCde);break;
		case 4 : afficher ( tabCde); break;
		case 5 : modifier( tabCde,tabart,tabFact );break;
	 
		case 0 : break; 
			  
		}} 
	 	 while(choix!=0); 
		}
		
public  int menuChoix(Object...objects) throws AbandonException, ErreurSaisie {
	
		String num = (String)objects[0].toString();
		String menu = "\n\n\t\t\t\tGESTION Des COMMANDES \n\n" +
				  "\t\t\tCREATION de la COMMANDE Numéro "+num+"...................1\n" +
				  "\t\t\tSUPPRESION d'une COMMANDE...............................2\n" +
				  "\t\t\tVISUALISATION d'une COMMANDE...........................3\n" +
				  "\t\t\tVISUALISATION toutes Les COMMANDES...............4\n" +
				  "\t\t\tMODIFIER UNE COMMANDE.........................................5\n" +
				   
				  "\t\t\tFIN......................................................................................0\n\n" +
			  
			  "\t\t\t";
 
	return ES.saisie(menu, 0, 5);
	}
	

///Listes des Methodes pour La GESTION des COMMANDES/////***************************DEBUT********************************//
 



public  void creer(TablesDesCommandes52 tabCde, Object...objects) throws AbandonException, ErreurSaisie {
	
	
	 TablesDesArticles52 tabart = (TablesDesArticles52)objects[0];
	
 
	
	String num =(String)objects[1];
	Commande52 <String> cde = new Commande52<String>();
	
	cde.SetNumCde( num);
	GestionCommande52 gestUneCde = new GestionCommande52();
	gestUneCde.menuGeneral(cde, tabart); 
	if( cde.taille()!=0){tabCde.ajouter(cde);
	cde.setValeurTotale(cde.prixTotalHR(tabart, cde));
	  
	 }
}
	

public  void supprimer(TablesDesCommandes52 tabCde,  Object...objects) throws AbandonException, ErreurSaisie {
 
boolean ouiNon  ; 
String  cle  = "";

TablesDesFactures tabFact = (TablesDesFactures)objects[0];
if(tabCde.taille()==0){ES.affiche("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");}



  if(tabCde.taille()!=0) {
	  cle = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n"+tabCde.getCLECommande()+
"\nVoulez Vous Supprimer quelle Commande:  " );}
 
	  if(tabCde.retourner(cle) !=null){
		  if(tabCde.retourner(cle).getEtatFacture()==true){
		  
			  ouiNon = ES.saisieOuiNon("Etes-vous certain de vouloir supprimer? (action irréversible) O/N: \n");
		
		if(ouiNon)	 { 
		  ES.affiche("La Commande '"+ cle +"' Vient d'être Supprimé !\n\n");
		  tabCde.supprimer(cle);
		  tabFact.supprimer(cle);}
		else{
			ES.affiche("ACTION ABANDONNEE, COMMANDE N'A PAS ETE SUPPRIMEE... ");
		}
		  
		  }else{
			  ES.affiche("SUPPRESSION IMPOSSIBLE CAR LA FACTURE N A PAS ETE ENCORE FACTUREE !!! ");
		  }
	}else  { ES.affiche("Le Numéro de Commande '"+ cle +"' N' EXISTE PAS  !\n");}
	 
  
 
 }

 
 


public  void modifier(TablesDesCommandes52 tabCde , Object...objects) throws AbandonException, ErreurSaisie {

	 
	 TablesDesArticles52 tabart = (TablesDesArticles52)objects[0];
	 TablesDesFactures tabFact = (TablesDesFactures)objects[1];
	 
	
	if(tabCde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	 	
		String  cle   = ES.saisie("\n********** LISTE des NUMEROS de COMMANDES PASSEES"
		+ " \n"+tabCde.getCLECommande()+"\n\n"
		+ "Entrer Le NUMERO DE COMMANDE à MODIFIER\n" );
  
	if(tabCde.retourner(cle)==null){
		 ES.affiche("Le Numéro de Commande '"+ cle +"' N' EXISTE PAS  !\n");
		 
	} else {
		
		if(tabFact.retourner(cle)!=null){
			ES.affiche(" *** LA FACTURE est deja CREE POUR LA COMMANDE :"+cle+ " MODIFICATION NON-AUTORISEE !!! DESOLEE !");
		}else{
		ES.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro:  "+cle);
		Commande52 <String> cde = new Commande52<String>();
		 cde.SetNumCde(cle);
		 
		 GestionCommande52 gestUneCde = new GestionCommande52();
		 gestUneCde.menuGeneral(cde, tabart); 
		
		 if( cde.taille()!=0){tabCde.ajouter(cde);
		 cde.setValeurTotale(cde.prixTotalHR(tabart, cde));}
		
	}
		 }}}


private  void afficherUneCommande(TablesDesArticles52 tabart, Object...objects) throws AbandonException, ErreurSaisie {
	

	TablesDesCommandes52 tabCde = (TablesDesCommandes52)objects[0];
	
	String  cle  = "";
	
	if(tabCde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
		cle= ES.saisie ("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n\n"+tabCde.getCLECommande()+
	"\nVoulez Vous AFFICHER quelle Commande: " );
		 
	if(tabCde.retourner(cle)!=null){
	ES.affiche(""+tabCde.retourner(cle).toString());
	
	}else ES.affiche("Le Numéro de Commande '"+ String.valueOf(cle) +"' N' EXISTE PAS  !\n");
	
}}

public  void afficher ( TablesDesCommandes52 tabCde) {
	 
ES.affiche(tabCde.toString());
}




/*
 * 
 * ///*****Les facutures sera editer depuis la tables des Factures**** ////
public  void editionFacture(TablesDesArticles52 tabart,TablesDesCommandes52 tabCde,Commande52<String> cde) throws AbandonException, ErreurSaisie {
	String  cle  = "";
boolean b =false;
String facture ="";
 
	
	if(tabCde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
	else{
	 
		cle = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n" 
			+tabCde.getCLECommande()+ 
			"\nVoulez Vous EDITER la FACTURE pour quelle Commande: ");
	facture= tabCde.editerFactureTC(cde, tabart,cle);

	
	if(tabCde.retourner(cle)!=null ){
		 
		
		ES.affiche("\n\t\t*** FACTURE COMMANDE  n°"+cle+" ***\n\n"+facture+"\n");
		
	 }
		 
	
	 
	else  ES.affiche("Le Numéro de Commande '"+ cle +"' N' EXISTE PAS  !\n");}
	
}  */


public static String premierNumero(TablesDesCommandes52 tabCde){
	 int num =1;
	 
	 DateUser dat = new DateUser();
	 String fixe = dat.getAnnee()+""+dat.getMois()+""+dat.getJour()+"";
	 String cle;
	 
	do{
		cle = fixe+num;
		if(tabCde.retourner(cle)==null)return  cle;
		 num++;
	}while(true);
}


 

 

 

 

 
}

//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	

	
	
