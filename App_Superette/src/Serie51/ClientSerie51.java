package Serie51;
import java.io.Serializable;

import javax.swing.JOptionPane;

import IPane.*;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
public class ClientSerie51 implements Serializable{
	
	
	static ES ES = new ES();  
    public static void main(String[] args) throws Exception  {
	
    	 
		
	
		Commande51<Integer> cde  = new Commande51<Integer> ();
		 
		
		
		GestionTablesDesArticles51  gestTabArt = new GestionTablesDesArticles51("TableDesArticles.data");
		GestionTablesDesCommandes51 gestTabCde = new GestionTablesDesCommandes51("TablesDesCommandes.data");
		TablesDesArticles51 tabart  = gestTabArt.recupere();
		TablesDesCommandes51 tabcde = gestTabCde.recupere();
		
		//menu principal///
		
		int choix;
		do{
			try{
			choix = MenuChoix();
			 
			 
			switch(choix){
			case 1 : gestTabArt.menuGeneral(tabart,tabcde);  break;
			case 2 : gestTabCde.menuGeneral(tabcde, tabart,cde );  break;
			case 3 : gestTabArt.sauvegarder(tabart);
			gestTabCde.sauvegarder(tabcde);break;
			case 0 : break;
			}
			}	catch (AbandonException abE){
				choix = 0;
			}
			 
		}while(choix!=0);
		
		gestTabArt.sauvegarder(tabart);   
		gestTabCde.sauvegarder(tabcde);
		JOptionPane.showMessageDialog(null,"\nAU REVOIR ET A BIENTOT SUR SUPERETTE !!!...");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU PRINCIPAL//////
	 * @throws ErreurSaisie 
	 **/   
	 
	
	public static int MenuChoix() throws AbandonException, ErreurSaisie   {
		
		String menu = "BIENVENUE A LA SUPERETTE \n\n" +
					  "Gestion Des Articles....................1\n" +
					  "Gestion des COMMANDES..........2\n"
					  +"SAUVEGARDE DES FICHIERS..........3\n"
					  + "Fin.....................................................0\n\n";
		
				return ES.saisie(menu, 0,3);
		
	}} 

 

  


