package Serie32;
import javax.swing.JOptionPane;

import IPane.*;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
public class ClientSerie32 {
	
	
	static ES ES = new ES();  
    public static void main(String[] args) throws ErreurSaisie  {
	
    	 
		
		TablesDesArticles22 tabart = new TablesDesArticles22();
		Commande22<Integer> cde  = new Commande22<Integer> ();
		TablesDesCommandes22 tabcde = new TablesDesCommandes22();
		
		
		
		GestionTablesDesArticles32  gestTabArt = new GestionTablesDesArticles32();
		GestionTablesDesCommandes32 gestTabCde = new GestionTablesDesCommandes32();
		
		
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
					  "Gestion des COMMANDES..........2\n\n";
		
					  
					 
	 
		return ES.saisie(menu, 0,2);
		
	}} 

 

  


