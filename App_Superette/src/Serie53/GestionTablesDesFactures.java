package Serie53;

import Connexion.ConnexionFichier;
import IPane.ES;
import MesInterfaces.InterfaceGestion;

import Utils.DateUser;
public class GestionTablesDesFactures implements InterfaceGestion<TablesDesFactures>{
   ES ES = new ES(); 
 
	   
	   ConnexionFichier<TablesDesFactures>  fichFacture; //establish Connection///
	   
	   
	public 	GestionTablesDesFactures(String nomPhysique){
		
		fichFacture = new ConnexionFichier<TablesDesFactures>(nomPhysique);
		
	}
	 
	
	///La methode qui recupere la tables des articles ///
	
	public TablesDesFactures recupere(){
		
		TablesDesFactures tabFacture = fichFacture.lire();
		if(tabFacture == null){
			tabFacture = new TablesDesFactures();
		}
		return tabFacture;
	}
	
	public void sauvegarder(TablesDesFactures tabFacture){
		
	 ES.affiche("**SAUVEGARDE DES FACTURES EN COURS... *** ");
		fichFacture.ecrie(tabFacture);
	}
	
	public void menuGeneral(TablesDesFactures tab, Object... objects) throws Exception {
		 
		int choix; 		
		Commande53<String> cde = (Commande53<String>)objects[0];
		TablesDesCommandes53 tabcde = (TablesDesCommandes53)objects[1];		
		TablesDesArticles53 tabart = (TablesDesArticles53)objects[2];
				
		 
 		  		
 	 do{	
 		
 		 
 
choix = menuChoix();

	switch (choix){
	case 1 : creer(tab,tabcde, tabart ) ; break;
	case 2 : editerUneFacture( tab, tabcde,tabart); break; 
	case 3 : supprimer(tab,tabcde);break;
	case 4 : editerToutesLesFactures( tab); break;  
 	case 0 : break; 
		 
 		 } 
	
 	 }while(choix!=0); 
		
	}
  
	
	public int menuChoix(Object... objects) throws Exception {
				  String menu = "\n\n\t\t\t\tGESTION des FACTURES \n\n" +
				  "\t\t\tCREER Une FACTURE.......................................1\n" +
				  "\t\t\tEDITER Une FACTURE......................................2\n" +
				  "\t\t\tSUPPRIMER Une FACTURE.............................3\n" +
				  "\t\t\tEDITER Toutes Les FACTURE.........................4\n " +
				  "\t\t\tFin............................................"
				  + "............................0\n" +
			 		  
			  "\t\t\t\n\n";

return ES.saisie (menu, 0, 4);
	}

	 


	public void creer(TablesDesFactures tabFact, Object... objects)throws Exception {

		
		TablesDesCommandes53  tabCde =  (TablesDesCommandes53)objects[0];
		TablesDesArticles53 tabArt = (TablesDesArticles53)objects[1];
 
		String numCde ="";
		if(tabCde.taille()==0){ES.affiche("Aucune COMMANDE est en COURS pour CREER UNE FACTURE!");}
		else{
			if(tabCde.cleNonFacture().isEmpty()){
				numCde = ES.saisie("**** LES FACTURES SONT CREES pour toutes les COMMANDES en COURS**** \n"  +
						"\n **Listes des COMMANDES pour lesquelles les FACTURES sont deja CREES \n"+tabFact.getCleFact()+"\n\n");
		  
			}
			else{
				numCde = ES.saisie("** Pour Quelle Commande Voulez Vous CREER la FACTURE ?\n" +tabCde.cleNonFacture() +
						"\n **Listes des COMMANDES pour lesquelles les FACTURES sont deja CREES \n"+tabFact.getCleFact()+"\n\n");
			}
			
			
		
		if(tabCde.retourner(numCde)==null){
			ES.affiche("Le NUMERO de COMMANDE INEXISTANT !");
		}else if(tabFact.retourner(numCde)==null){
			
			
			
			Commande53<String> cde = tabCde.retourner(numCde);
			
			DateUser dateFacture = new DateUser();
			 cde.getNumCde();
			 Facture<String> fact= new Facture<String> 
			 (cde.getNumCde(),dateFacture,cde.getNumClient(), cde.EditerFacture(cde, tabArt) );
			tabFact.ajouter(fact);
			 cde.setEtatFacture(true);
			 cde.setDateFacture(dateFacture);
			ES.affiche("*** FACTURE de la commande :"+numCde+" est créée ***");
		}else{
			ES.affiche("***** LA FACTUE est deja CREE pour LA COMMANDE :"+numCde+"*****\n");
		}
		}
		
	}
	
	//La Methode qui permet de editer les Factures Crees ////
	public void editerUneFacture(TablesDesFactures tabFact, Object...objects) throws Exception {
	
		TablesDesCommandes53  tabCde =  (TablesDesCommandes53)objects[0];
		TablesDesArticles53 tabArt = (TablesDesArticles53)objects[1];
		 String numCde = " ";
	     boolean b =false;
	     String facture ="";
	 
	     Commande53<String> cde = tabCde.retourner(numCde);
		 if(tabFact.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
		 else{
		 
			 numCde = ES.saisie("\n ********** LISTE des NUMEROS des COMMANDES pour lesquelles les FACTURES sont Crées\n" 
		 +tabFact.getCleFact()+
		 "\nVoulez Vous EDITER la FACTURE pour quelle Commande: ");
		 
			 	if(tabFact.retourner(numCde)!=null ){
			 				 		
			 		ES.affiche("\n\t\t*********** FACTURE DE LA COMMANDE :"+numCde+"*******\n\n"+tabFact.retourner(numCde).toString()+"\n");
			 		}
		else   {
				ES.affiche("Le NUMERO de COMMANDE INEXISTANT !");
			}
		
		}
		  
	}
	
	public void supprimer(TablesDesFactures tabFact, Object... objects) throws Exception {
		TablesDesCommandes53  tabCde =  (TablesDesCommandes53)objects[0];
		
		 
		 String numCde ;
	     DateUser dateAujourdhui = new DateUser();
	 	
	  
		 if(tabFact.taille()==0){ES.affiche("\n*** AUCUNE FACTURE est en COURS ! ***");}
		
		 
		 
		 else{
			 numCde = ES.saisie("\n ********** LISTE des NUMEROS des COMMANDES pour lesquelles les FACTURES sont Crées\n" 
		 +tabFact.getCleFact()+
		 "\nVoulez Vous SUPPRIMER la FACTURE pour quelle Commande ? ");
			 	Facture<String> factActuelle = tabFact.retourner(numCde);
				Commande53<String> cde = tabCde.retourner(numCde); 
			 
			
			   
			 
		if(tabFact.retourner(numCde)!=null ){	 
			if(factActuelle.getdateFacture().ajouterNombrejours(7).avant(dateAujourdhui.getJour(), dateAujourdhui.getMois(), dateAujourdhui.getAnnee())){
			
		 
					
					DateUser retourDateFacture = factActuelle.getdateFacture().decrementeNombrejours(7);
					factActuelle.setDateFacture(retourDateFacture );	 
			 ES.affiche("** Cette FACTURE a été cree MOINS d’1 semaine ... SUPPRESSION NON AUTORISEE!! DESOLE");
						 			 
			}
		  else  { 
			  tabFact.supprimer(numCde);
		  	  tabCde.supprimer(numCde);		
		
		 ES.affiche("La FACTURE n° : "+numCde+ " Vient être SUPPRIMEE");}
		 
			 			  
		 }else  {
			  ES.affiche("Le NUMERO de COMMANDE INEXISTANT !");      }   }}
	
	 

	public void modifier(TablesDesFactures tab, Object... objects)
			throws Exception {
		//// Empty Method not for this Table///
		
	}


	@Override
	public void afficher(TablesDesFactures tab) throws Exception {
	//// Empty Method not for this Table///
		
	}
	public void suppressionLesFacturesPermime(TablesDesFactures tabFact, TablesDesCommandes53 tabCde) {
	
		boolean verif;
		
		 DateUser dateAujourdhui = new DateUser();
	 
		String cle = tabFact.getCleFactSuppressionAuto();
		
		String tab[] = cle.split("-");
		
		for(int  i = 0; i<tab.length ; i++){
			  
			 
	 
		Facture<String> factActuelle = tabFact.retourner(tab[i]);
 
		  if(tabFact.retourner(tab[i])!=null  ){	 
			if(factActuelle.getdateFacture().ajouterNombrejours(7).avant(dateAujourdhui.getJour(), dateAujourdhui.getMois(), dateAujourdhui.getAnnee())){
	 
			DateUser retourDateFacture = factActuelle.getdateFacture().decrementeNombrejours(7);
			factActuelle.setDateFacture(retourDateFacture);	 
	 
					}
			else  { 
	   
				verif  =ES.saisieOuiNon("LA FACTURE  ***"+factActuelle.getnumFacture()+"*** daté  plus de 7 jours. Voulez vous la Supprimée? O/N ");
				if(verif ){
			  tabFact.supprimer(tab[i]);
		  	  tabCde.supprimer(tab[i]);	}	
			}} }}
	
	
		public void editerToutesLesFactures(TablesDesFactures tabFact) {
		if(tabFact.taille()==0){ES.affiche("Aucune COMMANDE est en COURS pour EDITER LA FACTURE!");}
		else{
		
		ES.affiche("\n"+tabFact.toString()+"\n");}
		
	}

} 
 

