package Serie31;
import IConsole.ES;
import MesExceptions.AbandonException;
public class ClientSerie31 {
	
	
	static ES ES = new ES();  
    public static void main(String[] args)  {
	
    	 
		
		TablesDesArticles22 tabart = new TablesDesArticles22();
		Commande22<Integer> cde  = new Commande22<Integer> ();
		TablesDesCommandes22 tabcde = new TablesDesCommandes22();
		
		
		
		GestionTablesDesArticles31  gestTabArt = new GestionTablesDesArticles31();
		GestionTablesDesCommandes31 gestTabCde = new GestionTablesDesCommandes31();
		
		
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
		 
		ES.affiche("\n\t\t\tAu revoir... et à bientôt !");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU PRINCIPAL//////
	 **/   
	 
	
	public static int MenuChoix() throws AbandonException   {
		
		String menu = "\n\n\t\t\tBIENVENUE A LA SUPERETTE \n\n" +
					  "\t\t\tGestion Des Articles ..........1\n" +
					  "\t\t\tGestion des COMMANDES..........2\n" +
					  "\t\t\tFIN............................0\n\n" +
					  
					  "\t\t\t";
		ES.affiche(menu);
		return ES.saisie("Choix : ", 0, 2);
		
	}} 

 

  


