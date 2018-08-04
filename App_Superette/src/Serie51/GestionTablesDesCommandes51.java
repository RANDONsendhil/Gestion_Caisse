package Serie51;

 
import Connexion.ConnexionFichier;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
import Utils.DateUser;

 
public class GestionTablesDesCommandes51 implements InterfaceGestion<TablesDesCommandes51>{
	
	

	private	ES ES = new ES();	
	  ConnexionFichier<TablesDesCommandes51>  fichCde; //establish Connection///
 
	
public 	GestionTablesDesCommandes51(String nomPhysique){
		
	fichCde = new ConnexionFichier<TablesDesCommandes51>(nomPhysique);
		
	}
	 
	
	///La methode qui recupere la tables des articles ///
	
	public TablesDesCommandes51 recupere(){
		
		TablesDesCommandes51 tabCde = fichCde.lire();
		if(tabCde == null){
			tabCde = new TablesDesCommandes51();
		}
		return tabCde;
	}
	
	public void sauvegarder(TablesDesCommandes51 tabCde){
		
		ES.affiche("**SAUVEGARDE DES COMMANDES EN COURS... *** ");
		fichCde.ecrie(tabCde);
	}
	
	 
	
	public void menuGeneral(TablesDesCommandes51 TabCde,  Object...objects) throws AbandonException, ErreurSaisie {
		
		
		TablesDesArticles51 Tabart = (TablesDesArticles51)objects[0];
		
		Commande51<String> cde = new Commande51<String>() ;
	
	 		int choix; 
	 		  	 		
	 	 do{ 
	 		  	 		 
	 		 String num =premierNumero(TabCde);
	 		 choix = menuChoix(num);

		switch (choix){
		case 1 : creer(TabCde,Tabart, num) ; break;
		case 2 : supprimer(TabCde,Tabart);break;
		case 3 : afficherUneCommande(Tabart, TabCde);break;
		case 4 : afficher ( TabCde); break;
		case 5 : modifier( TabCde,Tabart);break;
		case 6 : editionFacture(Tabart,TabCde, cde);break;
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
				  "\t\t\tEDITION FACTURE..........................................................6\n" +
				  "\t\t\tFIN......................................................................................0\n\n" +
			  
			  "\t\t\t";
 
	return ES.saisie(menu, 0, 6);
	}
	

///Listes des Methodes pour La GESTION des COMMANDES/////***************************DEBUT********************************//
 



public  void creer(TablesDesCommandes51 tabCde, Object...objects) throws AbandonException, ErreurSaisie {
		
	 TablesDesArticles51 tabart = (TablesDesArticles51)objects[0];
		
	String num =(String)objects[1];
	Commande51 <String> cde = new Commande51<String>();
	
	cde.SetNumCde( num);
	GestionCommande51 gestUneCde = new GestionCommande51();
	gestUneCde.menuGeneral(cde, tabart); 
	if( cde.taille()!=0){tabCde.ajouter(cde);
	cde.setValeurTotale(cde.prixTotalHR(tabart, cde));
	  
	 }
}
	

public  void supprimer(TablesDesCommandes51 tabCde,  Object...objects) throws AbandonException, ErreurSaisie {
boolean b =false;
 
String  cle ="";


if(tabCde.taille()==0){ES.affiche("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");}



  if(tabCde.taille()!=0) {
	  cle = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n"+tabCde.getCLECommande()+
"\nVoulez Vous Supprimer quelle Commande:  ");}
 
	  if(tabCde.retourner(cle) !=null){
		  if(tabCde.retourner(cle).getEtatFacture()==true){
		  
		  
		  ES.affiche("La Commande '"+ cle +"' Vient d'être Supprimé !\n\n");
		  tabCde.supprimer(cle);
		  }else{
			  ES.affiche("SUPPRESSION IMPOSSIBLE CAR LA FACTURE N A PAS ETE ENCORE EDITEE !!! ");
		  }
	}else  { ES.affiche("Le Numéro de Commande '"+ cle +"' N' EXISTE PAS  !\n");}
	 
  
 
 }

 
 


public  void modifier(TablesDesCommandes51 tabCde , Object...objects) throws AbandonException, ErreurSaisie {

	 
	 TablesDesArticles51 tabart = (TablesDesArticles51)objects[0];
	
	if(tabCde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	 	
	String cle = ES.saisie("\n********** LISTE des NUMEROS de COMMANDES PASSEES"
		+ " \n"+tabCde.getCLECommande()+"\n\n"
		+ "Entrer Le NUMERO DE COMMANDE à MODIFIER\n" );
  
	if(tabCde.retourner(cle)==null){
		 ES.affiche("Le Numéro de Commande '"+ cle +"' N' EXISTE PAS  !\n");
		 
	} else {
		ES.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro:  "+cle);
		Commande51 <String> Cde = new Commande51<String>();
		 Cde.SetNumCde(String.valueOf(cle));
		 
		 GestionCommande51 gestUneCde = new GestionCommande51();
		 gestUneCde.menuGeneral(Cde, tabart); 
		
		 if(Cde!=null&&Cde.taille()!=0){tabCde.ajouter(Cde);
		 
		
	}
		 }}}


private  void afficherUneCommande(TablesDesArticles51 tabart, Object...objects) throws AbandonException, ErreurSaisie {
	

	TablesDesCommandes51 tabcde = (TablesDesCommandes51)objects[0];
	
	String cle= "";
	
	if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
		cle= ES.saisie ("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n\n"+tabcde.getCLECommande()+
	"\nVoulez Vous AFFICHER quelle Commande: " );
		 
	if(tabcde.retourner(cle)!=null){
	ES.affiche(""+tabcde.retourner(cle).toString());
	
	}else ES.affiche("Le Numéro de Commande '"+ String.valueOf(cle) +"' N' EXISTE PAS  !\n");
	
}}

public  void afficher ( TablesDesCommandes51 tabcde) {
	 
ES.affiche(tabcde.toString());
}


public  void editionFacture(TablesDesArticles51 tabart,TablesDesCommandes51 tabcde,Commande51<String> cde) throws AbandonException, ErreurSaisie {

	String cle = " ";
boolean b =false;
String facture ="";
 
	
	if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
	else{
	 
		cle = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n" 
			+tabcde.getCLECommande()+ 
			"\nVoulez Vous EDITER la FACTURE pour quelle Commande: ");
	facture= tabcde.editerFactureTC(cde, tabart,cle);

	
	if(tabcde.retourner(cle)!=null ){
		b=	tabcde.retourner(cle).getEtatFacture();
		if(!b){
		
		ES.affiche("\n\t\t*** FACTURE COMMANDE  n°"+cle+" ***\n\n"+facture+"\n");
		
		
		tabcde.retourner(cle).setEtatFacture(true);
		tabcde.retourner(cle).setDateFacture(cde.datecde = new DateUser());}
		else  {
				ES.affiche("LA FACTURE EST DEJA EDITEE POUR LA COMMANDE:  '"+tabcde.retourner(cle));
				}
	
	}
	else  ES.affiche("Le Numéro de Commande '"+ cle +"' N' EXISTE PAS  !\n");}
	
}  
public static String premierNumero(TablesDesCommandes51 tabcde){
	 int num =1;
	 
	 DateUser dat = new DateUser();
	 String fixe = dat.getAnnee()+""+dat.getMois()+""+dat.getJour()+"";
	 String cle;
	 
	do{
		cle = fixe+num;
		if(tabcde.retourner(cle)==null)return  cle;
		 num++;
	}while(true);
}


 

 

 

 

 
}

//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	

	
	
