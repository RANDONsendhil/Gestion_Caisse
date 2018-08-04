package Serie42;
import javax.swing.JOptionPane;

import IPane.*;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
public class ClientSerie42 {
	
	
	static ES ES = new ES();  
    public static void main(String[] args) throws ErreurSaisie  {
	
    	 
		
		TablesDesArticles42 tabart = new TablesDesArticles42();
		Commande42<Integer> cde  = new Commande42<Integer> ();
		TablesDesCommandes42 tabcde = new TablesDesCommandes42();
		
		
		
		GestionTablesDesArticles42  gestTabArt = new GestionTablesDesArticles42();
		GestionTablesDesCommandes42 gestTabCde = new GestionTablesDesCommandes42();
		
		
		//menu principal///
		
		int choix;
		do{
			try{
			choix = MenuChoix();
			 
			 
			switch(choix){
			case 1 : gestTabArt.menuGeneral(tabart,tabcde);  break;
			case 2 : gestTabCde.menuGeneral(tabcde, tabart,cde );  break;
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

 

  


