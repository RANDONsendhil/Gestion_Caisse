package Serie53;

import Connexion.ConnexionFichier;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
import Utils.DateUser;


public class GestionTablesDesClients implements InterfaceGestion<TablesDesClients>  {
	  ES ES = new ES(); 
	   
	   ConnexionFichier<TablesDesClients>  fichClient; //establish Connection///
	   
	  public 	GestionTablesDesClients(){}   
	public 	GestionTablesDesClients(String nomPhysique)throws  AbandonException, ErreurSaisie {
		
		fichClient = new ConnexionFichier<TablesDesClients>(nomPhysique);
		
	}
	 
	
	///La methode qui recupere la tables des articles ///
	
	public TablesDesClients recupere(){
		
		TablesDesClients tabClient = fichClient.lire();
		if(tabClient == null){
			tabClient = new TablesDesClients();
		}
		return tabClient;
	}
	
	public void sauvegarder(TablesDesClients tabClient){
		
		ES.affiche("**SAUVEGARDE DES CLIENTS EN COURS... *** ");
		fichClient.ecrie(tabClient);
	}
	
	 
	
	
	
	
	public void menuGeneral(TablesDesClients tabClient, Object...objects) throws  AbandonException, ErreurSaisie  {
		 TablesDesCommandes53 tabCde =(TablesDesCommandes53)objects[0];
		 TablesDesFactures tabFact =(TablesDesFactures)objects[1];
		 Commande53<String> cde = ( Commande53<String>)objects[2];
	 
	  		
	int choix;
		do{
		 choix = menuChoix();
		 
		 switch(choix){
		 case 1: creer(tabClient);break;
		 case 2: supprimer(tabClient,tabCde,tabFact,cde); break;
		 case 3: modifier(tabClient);break;
		 case 4: afficher(tabClient);break;
		 case 0: break;
		 }
			
		}while(choix!=0);
		
	}

	 
	public int menuChoix(Object... objects) throws  AbandonException, ErreurSaisie {
		String menu = "\n\n\t\t\t\tGESTION des CLIENTS \n\n" +
				  "\t\t\tCREER Un NOUVEAU Client..........................1\n" +
				  "\t\t\tSUPPRIMER UN Client...................................2\n" +
				  "\t\t\tMODIFIER un Client........................................3\n" +
				  "\t\t\tAFFICHER les Clients.....................................4\n" +
				  
				  "\t\t\tFIN......................................................................0\n\n" +
			  
			  "\t\t\t\n\n";

return ES.saisie (menu, 0, 4); 
	}

	 
	public void creer(TablesDesClients tabClient, Object... objects) throws  AbandonException, ErreurSaisie  {
		
		Client client =saisie(tabClient);
		tabClient.ajouter(client);
	}
		 	
		 
	public Client saisie(TablesDesClients tabClient)throws  AbandonException, ErreurSaisie {
		String nomprenom ="";
		String localite = "";

		String troisPremiers = nomprenom;
		
		 
		
		nomprenom = ES.saisie("Entrer le NOM-PRENOM du Client");
	 	localite=ES.saisie("ENTRER la VILLE du Client");
		 
	 for(int i =0; i<nomprenom.length()&&i<3&&nomprenom.charAt(i)!=' ';i++){
		 troisPremiers =troisPremiers+nomprenom.charAt(i);
	 }
		
		String codeClient = retournerPremier(tabClient, troisPremiers);
		ES.affiche("Le CODE client a ete GENERE avec SUCCES. \n"+ "LE CODE CLIENT: *** "+codeClient+ " ***");
		return new Client(codeClient,nomprenom,localite);
		 		  
		 	
		 	 
	}
 

	public String retournerPremier(TablesDesClients tabClient, String cle) {
		 
		
		 
		int compteur =1;
		
	String code = 	cle;
	String codeEnvoye;
	
	do{
		codeEnvoye = code+compteur;
			
			if(tabClient.retourner(codeEnvoye)==null)return codeEnvoye;
			 
			 
			  compteur++;
		
		}while(true);
		
	
	}


	public void supprimer(TablesDesClients tabClient, Object... objects) throws  AbandonException, ErreurSaisie  {
		 TablesDesCommandes53 tabCde =(TablesDesCommandes53)objects[0];
		 TablesDesFactures tabFact =(TablesDesFactures)objects[1];
		 Commande53<String> cde = ( Commande53<String>)objects[2];
		
		boolean ouiNon;
		String codeClient;
		if(tabClient.taille()==0){
			 ES.affiche("Table de Client est Vide !!!");
		 }else{
			
			 
			 
			 codeClient =ES.saisie(tabClient.getCodeClient()+"\nEntrer le CODE du Client.");
			ouiNon = ES.saisieOuiNon("********* AVERTISSEMENT ********* \n SUPPRIMER UN CLIENT PERSISTE DE SUPPRIMER TOUTES LES COMMANDES\n AINSI QUE LES FACUTURES CORRESPONDANTES DU CODE CLIENT: *** "+ codeClient +" ***" ); 
			 if(ouiNon){
			 if(tabClient.retourner(codeClient)!=null){
			
				
				 ES.affiche("Le CLIENT: *** "+codeClient+" *** vient d'être SUPPRIMEE");
			tabClient.supprimer(codeClient);														
			 
		//	tabCde.suppressionCdeParIdentifiantClient(codeClient);
		//	tabFact.suppressionCdeParIdentifiantClient(codeClient);
		//	tabFact.supprimer(codeClient);}
			 
			 }}}  }
		  
		
	

	 
	public void modifier(TablesDesClients tabClient, Object... objects) throws  AbandonException, ErreurSaisie  {
		
		 if(tabClient.taille()==0){
			 ES.affiche("Table de Client est Vide !!!");
		 }else{
			 
			 
			String codeClient =ES.saisie(tabClient.getCodeClient()+"\n"
					+ "Entrer le Code Client pour MODIFIER\n");
			
			if(tabClient.retourner(codeClient)!=null){
				tabClient.supprimer(codeClient);
				Client client =saisie(tabClient);
				tabClient.ajouter(client);
				
				
			}
			 
		 }
		
		
		 
	}
 
	public void afficher(TablesDesClients tab) throws  AbandonException, ErreurSaisie {
	 if(tab.taille()==0){
		 ES.affiche("Table de Client est Vide !!!");
	 }else{
		ES.affiche(tab.toString()+"\n");
	 }
		
	}
	
	
 

}
