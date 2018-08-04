package Serie41;
import javax.swing.JOptionPane;

import IPane.*;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
public class ClientSerie41 {
	
	
	static ES ES = new ES();  
    public static void main(String[] args) throws ErreurSaisie  {
	
    	 
		
		TablesDesArticles41 tabart = new TablesDesArticles41();
		Commande41<Integer> cde  = new Commande41<Integer> ();
		TablesDesCommandes41 tabcde = new TablesDesCommandes41();
		
		
		
		GestionTablesDesArticles41  gestTabArt = new GestionTablesDesArticles41();
		GestionTablesDesCommandes41 gestTabCde = new GestionTablesDesCommandes41();
		
		
		//menu principal///
		
		int choix;
		do{
			try{
			choix = MenuChoix();
			 
			 
			switch(choix){
			case 1 : gestTabArt.menuGeneral(tabart, cde, tabcde);  break;
			case 2 : gestTabCde.menuGeneral(cde, tabart, tabcde );  break;
			case 0 : break;
			}
			}	catch (AbandonException abE){
				choix = 0;
			}
			 
		}while(choix!=0);
		 
		JOptionPane.showMessageDialog(null,"\nAU REVOIR ET A BIENTOT SUR SUPERETTE !!!...");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU PRINCIPAL//////
	 * @throws ErreurSaisie 
	 **/   
	 
	
	public static int MenuChoix() throws AbandonException, ErreurSaisie   {
		
		String menu = "BIENVENUE A LA SUPERETTE \n\n" +
					  "Gestion Des Articles....................1\n" +
					  "Gestion des COMMANDES..........2\n"
					  + "Fin.....................................................0\n\n";
		
					  
					 
	 
		return ES.saisie(menu, 0,2);
		
	}} 

 

  


