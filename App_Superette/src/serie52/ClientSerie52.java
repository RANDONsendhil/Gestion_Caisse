
package serie52;
import java.io.Serializable;

import javax.swing.JOptionPane;

import IPane.*;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
 public class ClientSerie52 implements Serializable{
	
	
	static ES ES = new ES();  
    public static void main(String[] args) throws Exception  {
	
    	 
		
	

		Commande52<Integer> cde  = new Commande52<Integer> ();
		 
	 
		GestionTablesDesFactures gestFact = new  GestionTablesDesFactures("TablesDesFactures.data");
		GestionTablesDesArticles52  gestTabArt = new GestionTablesDesArticles52("TableDesArticles.data");
		GestionTablesDesCommandes52 gestTabCde = new GestionTablesDesCommandes52("TablesDesCommandes.data");
		TablesDesArticles52 tabart  = gestTabArt.recupere();
		TablesDesCommandes52 tabcde = gestTabCde.recupere();
		TablesDesFactures tabFac = gestFact.recupere();
		
		//menu principal///
		
		int choix;
		do{
			try{
			choix = MenuChoix();
			 
			 
			switch(choix){
			case 1 : gestTabArt.menuGeneral(tabart,tabcde);  break;
			case 2 : gestTabCde.menuGeneral(tabcde, tabart,cde,tabFac );  break;
			case 3 : gestFact.menuGeneral(tabFac, cde,tabcde,tabart);break;
			case 4 : gestTabArt.sauvegarder(tabart); 
			gestTabCde.sauvegarder(tabcde);
			gestFact.suppressionLesFacturesPermime(tabFac, tabcde);
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
		 gestFact.suppressionLesFacturesPermime(tabFac, tabcde);
		 
		 JOptionPane.showMessageDialog(null,"\nAU REVOIR ET A BIENTOT SUR SUPERETTE !!!...");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU PRINCIPAL//////
	 * @throws ErreurSaisie 
	 **/   
	 
	
public static int MenuChoix() throws AbandonException, ErreurSaisie   {
		
		String menu = "BIENVENUE A LA SUPERETTE \n\n" +
					  "Gestion Des Articles....................1\n" +
					  "Gestion des COMMANDES..........2\n"
					  +"Gestion des FACTURES..........3\n"
					  +"SAUVEGARDE DES FICHIERS..........4\n"
					  + "Fin.....................................................0\n\n";
		
				return ES.saisie(menu, 0,4);
		
	}} 
 

  


