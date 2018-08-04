
package Serie53;
import java.io.Serializable;

import javax.swing.JOptionPane;

import IPane.*;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
 public class ClientSerie53 implements Serializable{
	
	
	static ES ES = new ES();  
    public static void main(String[] args) throws Exception  {
	
    	 
		
	

		Commande53<Integer> cde  = new Commande53<Integer> ();
		 	 
		GestionTablesDesFactures gestFact = new  GestionTablesDesFactures("TablesDesFactures.data");
		GestionTablesDesArticles53  gestTabArt = new GestionTablesDesArticles53("TableDesArticles.data");
		GestionTablesDesCommandes53 gestTabCde = new GestionTablesDesCommandes53("TablesDesCommandes.data");
		GestionTablesDesClients gestTabClient = new GestionTablesDesClients("TablesDesClients.data");
		GestionDesCreationDesArticles gestCreeArt = new  GestionDesCreationDesArticles();
		TablesDesArticles53 tabart  = gestTabArt.recupere();
		TablesDesCommandes53 tabcde = gestTabCde.recupere();
		TablesDesFactures tabFac = gestFact.recupere();
		TablesDesClients tabClient = gestTabClient.recupere();
		 gestCreeArt .miseAJArticlesLotPerime(tabart, tabcde,cde);
		//menu principal///
		
		int choix;
		do{
			try{
			choix = menuChoix();
			 
			 
			switch(choix){
			case 1 : gestTabArt.menuGeneral(tabart,tabcde);  break;
			case 2 : gestTabCde.menuGeneral(tabcde, tabart,cde,tabFac,tabClient );  break;
			case 3 : gestFact.menuGeneral(tabFac, cde,tabcde,tabart);break;
			case 4 : gestTabClient.menuGeneral(tabClient,tabcde,tabFac,cde);break;
			case 5 : gestTabArt.sauvegarder(tabart); 
			gestTabCde.sauvegarder(tabcde);
			gestFact.suppressionLesFacturesPermime(tabFac, tabcde);
			gestTabClient.sauvegarder(tabClient);
			gestCreeArt .miseAJArticlesLotPerime(tabart, tabcde,cde);
			gestFact.sauvegarder(tabFac);break;
			case 0 : break;
			
			}
			}	catch (AbandonException abE){
				choix = 0;
			}
			 
		}while(choix!=0);
		 gestTabArt.sauvegarder(tabart) ;
	     gestTabCde.sauvegarder(tabcde);
		 gestFact.sauvegarder(tabFac);
		 gestTabClient.sauvegarder(tabClient);
		 gestFact.suppressionLesFacturesPermime(tabFac, tabcde);
		
		 
		 JOptionPane.showMessageDialog(null,"\nAU REVOIR ET A BIENTOT SUR SUPERETTE !!!...");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU PRINCIPAL//////
	 * @throws ErreurSaisie 
	 **/   
	 
	
public static int menuChoix() throws AbandonException, ErreurSaisie   {
		
		String menu = "BIENVENUE A LA SUPERETTE \n\n" +
					  "Gestion Des Articles....................1\n" +
					  "Gestion des COMMANDES..........2\n"
					  +"Gestion des FACTURES...............3\n"
					  +"Gestion des CLIENTS...................4\n"
					  +"SAUVEGARDE DES FICHIERS......5\n"
					  + "Fin.....................................................0\n\n";
		
				return ES.saisie(menu, 0,5);
		
	}} 
 

  


